package com.wangdm.tutorial.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App 
{
    public static void main( String[] args )
    {
    	Logger loger = LoggerFactory.getLogger(App.class);
    	
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.getTransaction().commit();
    	session.close();
    	loger.info( "Hello World!");
    }
}
