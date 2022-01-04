package com.vgsoft.savedata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vgsoft.model.Employee;

public class Update {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("/com/vgsoft/cfg/hibernate.cfg.xml");
		
		SessionFactory  fact = cfg.buildSessionFactory();
		
		Session session = fact.openSession();
		
		int id = 105;
		
		Employee emp  = session.get(Employee.class, id);
		 
		Transaction tx = null;
		if(emp != null) {
			emp.setId(105);
			emp.setName("Redmi note 7");
			emp.setPrice(100000);
			emp.setBrand("Redmi");
			
			try {
				tx = session.beginTransaction();
				session.update(emp);
				tx.commit();
				System.out.println("Data will be updated....!!!!!");
			} catch (Exception e) {
				tx.rollback();
				System.out.println(e);
			}
		}else {
			System.out.println("Data could'nt updated.........!!!!");
		}
	}

}
