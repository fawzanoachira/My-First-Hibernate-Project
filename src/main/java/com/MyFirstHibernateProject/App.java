package com.MyFirstHibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.MyFirstHibernateProject.entity.Employee;

public class App {
	public static void main(String[] args) {
		try {
			// For creating data into database
			Configuration config = new Configuration();
			config.configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			Employee employee = new Employee();

			employee.setEmpId(1);
			employee.setEmpName("fawzan");
			employee.setEmpSalary(56000.0);

			session.persist(employee);
			Transaction beginTransaction = session.beginTransaction();
			beginTransaction.commit();
			
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
