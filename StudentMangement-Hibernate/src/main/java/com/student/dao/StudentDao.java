package com.student.dao;

import com.student.entity.Student;

public interface StudentDao {
	
	void insert(Student std);
	void update(Student std);
	void delete(Student std);

}
