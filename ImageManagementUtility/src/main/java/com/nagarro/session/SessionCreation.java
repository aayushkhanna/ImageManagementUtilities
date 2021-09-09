package com.nagarro.session;
/*
 * @Aayush Khanna

 * Trainee Technology
 * 
 * This file is used to create session 
 * */

//Imports
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.nagarro.pojo.ImageDetails;
import com.nagarro.pojo.LoginDetails;



public class SessionCreation {
	
	//Session Factory method creation
	public SessionFactory getSessionFactory() {
	
		//Initializing configuration object 
		Configuration connection = new Configuration();
		
		//configuring the session factory object using annotaed class
		connection.configure().addAnnotatedClass(LoginDetails.class);
		connection.configure().addAnnotatedClass(ImageDetails.class);
		
		//Service Registry object creation
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(connection.getProperties()).buildServiceRegistry();
		
		//Configuring the service registry build factory
		SessionFactory sessionFactory = connection.buildSessionFactory(serviceRegistry);
		
		//Returning Session factory object
		return sessionFactory;
	}
}



