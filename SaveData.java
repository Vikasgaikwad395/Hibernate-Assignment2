package com.vgsoft.customer.main;
import com.vgsoft.customer.model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.vgsoft.customer.model.Customer;

public class SaveData {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("/com/vgsoft/customer/cfg/hibernate.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();
		
		Customer c = new Customer();
		c.setId(104);
		c.setName("RadheShyam");
		c.setMobile(882288994);
		c.setEmail("Rasheshyam@gmail.com");
		
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();
			System.out.println("Data will be saved..........!!!!!!");			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Data could'nt be saved............!!!!");
		}
		session.close();
		fact.close();

	}

}
