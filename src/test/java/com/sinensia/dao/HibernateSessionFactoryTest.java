package com.sinensia.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HibernateSessionFactoryTest {

	@Test
	public void testGetSessionDevlopmentFactory() {
		HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();
		assertTrue(hibernateSessionFactory
				.getSessionFactory("hibernate.cfg.xml") != null);
	}

	@Test
	public void testGetSessionProductionFactory() {
		HibernateSessionFactory hibernateSessionFactory = new HibernateSessionFactory();
		assertTrue(hibernateSessionFactory
				.getSessionFactory("hibernate-heroku.cfg.xml") != null);
	}

}
