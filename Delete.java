package com.vgsoft.savedata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vgsoft.model.Employee;

public class Delete {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("/com/vgsoft/cfg/hibernate.cfg.xml");
		
		SessionFactory fact = cfg.buildSessionFactory();
		
		Session session = fact.openSession();
		
		Employee emp = new Employee();
		int id = 105;
		Transaction tx = null;
		if(emp !=null) {
			try {
				tx = session.beginTransaction();
				emp.setId(id);
				session.delete(emp);
				tx.commit();
				System.out.println("Deleted...........!!!!!!!!!");
			} catch (Exception e) {
				tx.rollback();
				System.out.println(e);
			}
		}else {
			System.out.println("No data found.........!!!!!");
		}
		
	}

}
