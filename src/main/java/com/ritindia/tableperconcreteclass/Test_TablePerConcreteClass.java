package com.ritindia.tableperconcreteclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//Program 2 Strategy mapping
//Demo of Table per concrete class Strategy
/*Included files:
 * 1.Employee.java,RegularEmployee.java,ContractEmployee.java
 * 2.Employee.hbm.java
 * 3.tableperconcreteclass.cfg.xml
 * 
 * Note:
 * 1.The union-subclass subelement of class, specifies the subclass. 
 * 2.It adds the columns of parent table into this subclass table
 * */


public class Test_TablePerConcreteClass {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("tableperconcreteclass.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setEmpName("Amruta Patil");
		
		RegularEmployee regularEmployee= new RegularEmployee();
		regularEmployee.setEmpId(1111);
		regularEmployee.setEmpName("Raghav Patil");
		regularEmployee.setSalary(500000);
		
		ContractEmployee contractEmployee = new ContractEmployee();
		contractEmployee.setEmpId(2222);
		contractEmployee.setEmpName("Adira Patil");
		contractEmployee.setContractPeriod("20 Hours");
		
		session.save(employee);
		session.save(regularEmployee);
		session.save(contractEmployee);
		
		txn.commit();
		session.close();
		
		System.out.println("Success");
		
	}

}
