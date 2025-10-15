package com.student.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.student.entity.Student;

public class StudentImp  implements StudentDao{
	
	private Session session = ConfigurationFactory.conneection().openSession();
	@Override
	public void insert(Student std) {
		Student student = new Student(std.getRollNo(),std.getName(),std.getAge(),std.getAddress(),std.getPercentage());
		
		session .save(student);
		session.beginTransaction().commit();
		
	}

	@Override
	public void update(Student std) {
		Student student = new Student(std.getRollNo(),std.getName(),std.getAge(),std.getAddress(),std.getPercentage());
		session.saveOrUpdate(student);
		session.beginTransaction().commit();
		
		
	}

	@Override
	public void delete(Student std) {
		session.delete(std);
		session.beginTransaction().commit();
		
	}
	
	
	public Student view(int id) {
		Student student = session.get(Student.class, id);
		session.beginTransaction().commit();
		return student;
	}
	
	public List<Student> viewAll() {
		 @SuppressWarnings({ "deprecation", "unchecked" })
		 List<Student> list = session.createCriteria(Student.class).list();
		 return list;
	}
	
	
	public List<Integer> studentCount() {
		
		Criteria criteria = session.createCriteria(Student.class);
		 criteria.setProjection(Projections.count("rollNo"));
		
		 List<Integer> list = criteria.list();
		
		return list;
		
	}
	
	public List<Object[]> max_min_Percentage() {
		Criteria criteria = session.createCriteria(Student.class);
		criteria.setProjection(Projections.projectionList().add(Projections.min("percentage"))
				  .add(Projections.max("percentage")));
		List<Object[]>list = criteria.list();
		return list;
		  
		  
		  
		  
		  
		
		 
		 	
	}
	

}
