package com.sinensia.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sinensia.model.Alumno;

public class HibernateSessionFactory {

	private static final Logger logger = Logger
			.getLogger(HibernateSessionFactory.class.getName());

	public SessionFactory getSessionFactory(String configurationFile) {
		try {
			Configuration config = new Configuration()
					.configure(configurationFile)
					.addAnnotatedClass(Alumno.class);
			SessionFactory sessionFactory = config.buildSessionFactory();
			return sessionFactory;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory", e);
			throw new IllegalStateException("Could not locate SessionFactory");
		}
	}

}
