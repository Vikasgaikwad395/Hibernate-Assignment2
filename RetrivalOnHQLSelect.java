package com.vgsoft.customer.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vgsoft.customer.model.Customer;

public class RetrivalOnHQLSelect {

	public static void main(String[] args) {
		
			Configuration cfg = new Configuration();
			cfg.configure("/com/vgsoft/customer/cfg/hibernate.cfg.xml");
			
			SessionFactory fact = cfg.buildSessionFactory();
			Session session = fact.openSession();
			
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Employee id : ");
			int id = in.nextInt();
			
			String hql = "from Customer where id = ?1";
			Query<Customer> query = session.createQuery(hql);
			query.setParameter(1, id);
			List<Customer> list = query.list();
			
			if(list.size() !=0) {
				for(Customer e : list ) {
					System.out.println(e);
				}
			}else {
				System.out.println("No data found with id : "+id);
			}
			session.close();
			fact.close();
	}

}
