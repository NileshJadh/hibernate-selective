package com.rocky.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rocky.model.Employee;

public class LaubnchSelctive {

	public static void main (String args[]) {
		

		SessionFactory sessionFactory = new Configuration().configure().
				addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Employee e = new Employee();
			e.setEid(1);
			e.setEname("Aayush");
			e.setEage(25);
			e.setEcity("Virar");
			
			session.persist(e);
			flag = true;
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) 
				transaction.commit();
			else 
			transaction.rollback();
			
			session.clear();
			sessionFactory.close();
		}
	}
}
