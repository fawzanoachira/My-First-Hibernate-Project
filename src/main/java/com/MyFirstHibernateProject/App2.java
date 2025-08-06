package com.MyFirstHibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.MyFirstHibernateProject.entity.Employee;

public class App2 {
	public static void main(String[] args) {
		try {
			// For updating data in database
			Configuration config = new Configuration();
			config.configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();

			Employee employee = session.find(Employee.class, 1);
			employee.setEmpName("fawzab");
			employee.setEmpSalary(50000.0);

			session.persist(employee);
			beginTransaction.commit();

			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
