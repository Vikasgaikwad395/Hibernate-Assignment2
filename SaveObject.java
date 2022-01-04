package com.vgsoft.savedata;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vgsoft.model.Employee;

public class SaveObject {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("/com/vgsoft/cfg/hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Employee emp = new Employee();
		emp.setBrand("Apple");
		emp.setName("Apple 11");
		emp.setPrice(100000);
		emp.setId(103);
		
		
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
			System.out.println("Successfully saved data");
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Failed to Saved data................!!!!");
		}
		session.close();
		factory.close();
	}
	
}
