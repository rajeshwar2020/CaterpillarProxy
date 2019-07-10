package com.rajesh.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DiskLevelCachingClient 
{
  public static void main(String rags[]) throws Exception 
  {
    Configuration c = new Configuration();
    c.configure("/hibernate.cfg.xml");
    SessionFactory sf = c.buildSessionFactory();
    Session s = sf.openSession();
    Query q = s.createQuery("FROM Course");
    // get Resultset here
  }
}
