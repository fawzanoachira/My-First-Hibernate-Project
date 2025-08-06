package com.MyFirstHibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.MyFirstHibernateProject.entity.Employee;

public class App3 {
	public static void main(String[] args) {
		try {
			// For deleting data from database
			Configuration config = new Configuration();
			config.configure();
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction beginTransaction = session.beginTransaction();

			Employee employee = session.find(Employee.class, 2);
			session.remove(employee);

			// session.persist(employee);
			beginTransaction.commit();

			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
