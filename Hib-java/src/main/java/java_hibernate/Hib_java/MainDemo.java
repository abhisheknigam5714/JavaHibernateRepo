package java_hibernate.Hib_java;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


public class MainDemo {
	
	
	public static SessionFactory getConnection() {
		 Configuration configuration = new Configuration();
		 
		 Properties properties = new Properties();
		 properties.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
		 properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/employee");
		 properties.put(Environment.JAKARTA_JDBC_USER, "root");
		 properties.put(Environment.JAKARTA_JDBC_PASSWORD, "934349");
		 properties.put(Environment.SHOW_SQL, true);
		 properties.put(Environment.HBM2DDL_AUTO, "update");
		 properties.put(Environment.FORMAT_SQL, true);
		 
		 
		 configuration.setProperties(properties);
		 configuration.addAnnotatedClass(Employee.class);
		 
		 
	SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		return sessionFactory;
		
	}
	
	
	
	// here is the insert method------
	public static void insert(SessionFactory sf) {
	    Session openSession = sf.openSession();
	    Transaction trs = openSession.beginTransaction();
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Enter the employee ID:");
	    int eId = scanner.nextInt();
	    scanner.nextLine(); // Consume leftover newline

	    System.out.println("Enter the employee name:");
	    String eName = scanner.nextLine();

	    System.out.println("Enter the employee address:");
	    String eAdd = scanner.nextLine();

	    System.out.println("Enter the employee salary:");
	    double eSalary = scanner.nextDouble();
	    scanner.nextLine();

	    // Account details
	    System.out.println("----- Account details -----");
	    System.out.println("Enter the account number:");
	    int eAccountNo = scanner.nextInt();
	    scanner.nextLine();

	    System.out.println("Enter the bank name:");
	    String eBankName = scanner.nextLine();

	    System.out.println("Enter the account amount:");
	    double eAmount = scanner.nextDouble();
	    scanner.nextLine();

	    Account account = new Account(eAccountNo, eBankName, eAmount);

	    // Education details
	    System.out.println("----- Education details -----");
	    System.out.println("Enter the roll number:");
	    int eRollNo = scanner.nextInt();
	    scanner.nextLine();

	    System.out.println("Enter the college name:");
	    String eClgName = scanner.nextLine();

	    System.out.println("Enter the percentage:");
	    double ePer = scanner.nextDouble();

	    Education education = new Education(eRollNo, eClgName, ePer);

	    // Now create Employee
	    Employee employee = new Employee(eId, eName, eAdd, eSalary, account, education);

	    openSession.persist(employee);
	    System.out.println("Inserted ");
	    trs.commit();
	    openSession.close();

	    System.out.println("Employee inserted successfully.");
	}

	private static void read(SessionFactory sf) {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
	    Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the employee ID:");
	    int eId = scanner.nextInt();
	    scanner.nextLine();
	    
	    Employee employee = session.find(Employee.class, eId);
	    if(employee!=null) {
	    	System.out.println("id:"+employee.getId());
	    	System.out.println("name:"+employee.getName());
	    	System.out.println("address:"+employee.getAdd());
	    	System.out.println("salary:"+employee.getSalary());
	    	
	    	Account accc = employee.getAccc();
	    	System.out.println("---- Account Details ----");
	    	System.out.println("account no:"+accc.getAccNo());
	    	System.out.println("bank name:"+accc.getBankName());
	    	System.out.println("amount:"+accc.getAmount());
	    	
	    	Education edu = employee.getEdu();
	    	System.out.println("---- Education Details -----");
	    	System.out.println("roll no:"+edu.getRollno());
	    	System.out.println("clg name:"+edu.getClgName());
	    	System.out.println("per:"+edu.getPer());   	
	    	
	    }
	    
	    else {
	    	System.out.println("DATA DO'ES NOT EXISTS");
	    }
	   session.close();	
	}



	public static void update(SessionFactory sf) {
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Enter the Employee ID to update:");
	    int empId = scanner.nextInt();
	    scanner.nextLine(); // consume newline

	    Employee emp = session.find(Employee.class, empId);

	    if (emp == null) {
	        System.out.println("Employee with ID " + empId + " not found.");
	        session.close();
	        return;
	    }

	    System.out.println("What do you want to update?");
	    System.out.println("1. Specific field");
	    System.out.println("2. All fields");
	    int updateChoice = scanner.nextInt();
	    scanner.nextLine();

	    switch (updateChoice) {
	        case 1:
	            System.out.println("Select field to update:");
	            System.out.println("1. Name");
	            System.out.println("2. Address");
	            System.out.println("3. Salary");
	            System.out.println("4. Account details");
	            System.out.println("5. Education details");
	            int fieldChoice = scanner.nextInt();
	            scanner.nextLine();

	            switch (fieldChoice) {
	                case 1:
	                    System.out.println("Enter new name:");
	                    String name = scanner.nextLine();
	                    emp.setName(name);
	                    break;
	                case 2:
	                    System.out.println("Enter new address:");
	                    String address = scanner.nextLine();
	                    emp.setAdd(address);
	                    break;
	                case 3:
	                    System.out.println("Enter new salary:");
	                    double salary = scanner.nextDouble();
	                    emp.setSalary(salary);
	                    break;
	                case 4:
	                    Account acc = emp.getAccc();
	                    System.out.println("Enter new Account Number:");
	                    acc.setAccNo(scanner.nextInt());
	                    scanner.nextLine();
	                    System.out.println("Enter new Bank Name:");
	                    acc.setBankName(scanner.nextLine());
	                    System.out.println("Enter new Amount:");
	                    acc.setAmount(scanner.nextDouble());
	                    emp.setAccc(acc);
	                    break;
	                case 5:
	                    Education edu = emp.getEdu();
	                    System.out.println("Enter new Roll Number:");
	                    edu.setRollno(scanner.nextInt());
	                    scanner.nextLine();
	                    System.out.println("Enter new College Name:");
	                    edu.setClgName(scanner.nextLine());
	                    System.out.println("Enter new Percentage:");
	                    edu.setPer(scanner.nextDouble());
	                    emp.setEdu(edu);
	                    break;
	                default:
	                    System.out.println("Invalid field choice.");
	                    session.close();
	                    return;
	            }
	            break;

	        case 2:
	            // ==== Update All Fields ====
	            System.out.println("Enter new name:");
	            emp.setName(scanner.nextLine());

	            System.out.println("Enter new address:");
	            emp.setAdd(scanner.nextLine());

	            System.out.println("Enter new salary:");
	            emp.setSalary(scanner.nextDouble());
	            scanner.nextLine();

	            Account accAll = emp.getAccc();
	            System.out.println("Enter new Account Number:");
	            accAll.setAccNo(scanner.nextInt());
	            scanner.nextLine();
	            System.out.println("Enter new Bank Name:");
	            accAll.setBankName(scanner.nextLine());
	            System.out.println("Enter new Amount:");
	            accAll.setAmount(scanner.nextDouble());
	            scanner.nextLine();
	            emp.setAccc(accAll);

	            Education eduAll = emp.getEdu();
	            System.out.println("Enter new Roll Number:");
	            eduAll.setRollno(scanner.nextInt());
	            scanner.nextLine();
	            System.out.println("Enter new College Name:");
	            eduAll.setClgName(scanner.nextLine());
	            System.out.println("Enter new Percentage:");
	            eduAll.setPer(scanner.nextDouble());
	            emp.setEdu(eduAll);
	            break;

	        default:
	            System.out.println("Invalid option.");
	            session.close();
	            return;
	    }

	    // Save changes
	    session.merge(emp); 
	    tx.commit();
	    session.close();

	    System.out.println("Employee updated successfully.");
	}

	public static void delete(SessionFactory sf) {
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Enter the Employee ID to delete:");
	    int empId = scanner.nextInt();
	    scanner.nextLine(); // consume newline

	    Employee emp = session.find(Employee.class, empId);

	    if (emp == null) {
	        System.out.println("Employee with ID " + empId + " not found.");
	        session.close();
	        return;
	    }

	    // Optional: Confirm delete
	    System.out.println("Are you sure you want to delete employee: " + emp.getName() + "? (yes/no)");
	    String confirm = scanner.nextLine();

	    if (confirm.equalsIgnoreCase("yes")) {
	        session.remove(emp); // Hibernate 6+ preferred delete method
	        tx.commit();
	        System.out.println("Employee deleted successfully.");
	    } else {
	        tx.rollback(); // cancel deletion
	        System.out.println("Delete operation cancelled.");
	    }

	    session.close();
	}
	
	
	public static void readAll(SessionFactory sf) {
	    Session session = sf.openSession();
	    Scanner scanner = new Scanner(System.in);

	    List<Employee> employeeList = session.createQuery("from Employee", Employee.class).list();

	    if (employeeList.isEmpty()) {
	        System.out.println("📭 No employees found in the database.");
	    } else {
	        System.out.println("\n==================== ALL EMPLOYEES ====================");
	        for (Employee emp : employeeList) {
	            System.out.println("-------------------------------------------------------");
	            System.out.println("🆔 ID: " + emp.getId());
	            System.out.println("👤 Name: " + emp.getName());
	            System.out.println("📍 Address: " + emp.getAdd());
	            System.out.println("💰 Salary: ₹" + emp.getSalary());

	            Account acc = emp.getAccc();
	            if (acc != null) {
	                System.out.println("🏦 Account No: " + acc.getAccNo());
	                System.out.println("🏛️ Bank Name: " + acc.getBankName());
	                System.out.println("💵 Amount: ₹" + acc.getAmount());
	            }

	            Education edu = emp.getEdu();
	            if (edu != null) {
	                System.out.println("🎓 Roll No: " + edu.getRollno());
	                System.out.println("🏫 College Name: " + edu.getClgName());
	                System.out.println("📊 Percentage: " + edu.getPer() + "%");
	            }
	            System.out.println("-------------------------------------------------------");
	        }
	    }

	    session.close();
	}

	
	public static void main(String[] args) {
	    SessionFactory sf = getConnection();
	    Scanner sc = new Scanner(System.in);

	    while (true) {
	        System.out.println("\n=============================");
	        System.out.println("     EMPLOYEE MANAGEMENT");
	        System.out.println("=============================");
	        System.out.println(" 1. ➕ Insert Employee");
	        System.out.println(" 2. 🔄 Update Employee");
	        System.out.println(" 3. 🔍 Read Employee by ID");
	        System.out.println(" 4. 📋 Show All Employees"); 
	        System.out.println(" 5. ❌ Delete Employee");
	        System.out.println(" 6. 🚪 Exit");

	        System.out.println("=============================");
	        System.out.print("👉 Enter your choice: ");

	        int choice = sc.nextInt();
	        sc.nextLine(); // consume newline

	        switch (choice) {
	        case 1:
	            insert(sf);
	            break;
	        case 2:
	            update(sf);
	            break;
	        case 3:
	            read(sf); // assumes you already have a method to read one employee
	            break;
	        case 4:
	            readAll(sf); //  new case
	            break;
	        case 5:
	            delete(sf);
	            break;
	        case 6:
	            System.out.println("\n👋 Exiting the application. Goodbye!");
	            sf.close();
	            System.exit(0);
	            break;
	        default:
	            System.out.println("⚠️ Invalid choice. Please try again.");
	    }

	    }
	}


}
