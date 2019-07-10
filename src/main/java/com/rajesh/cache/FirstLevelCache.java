package com.rajesh.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rajesh.model.Student;

public class FirstLevelCache {
	public static void main(String[] args) {
		Configuration c = new Configuration();
		c.configure("/hibernate.cfg.xml");
		SessionFactory sf = c.buildSessionFactory();

		Session s1 = sf.openSession();
	    Session s2 = sf.openSession();
		      
	    Student std1 = (Student) s1.get(Student.class, new Integer(100));
	    System.out.println(std1.getId() + " " + std1.getName() + " " + std1.getMarks());
	 
	    Student std2 = (Student) s2.get(Student.class, new Integer(100));
	    System.out.println(std2.getId() + " " + std2.getName() + " " + std2.getMarks());
	}
}
