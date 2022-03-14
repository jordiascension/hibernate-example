package com.sinensia.dao;
// Generated 13 mar. 2022 0:14:21 by Hibernate Tools 5.6.3.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sinensia.model.Alumno;

/**
 * Home object for domain model class Alumno.
 * 
 * @see com.sinensia.model.Alumno
 * @author Hibernate Tools
 */
public class AlumnoDao {

	private static final java.util.logging.Logger logger = Logger
			.getLogger(AlumnoDao.class.getName());

	private final SessionFactory sessionFactory = new HibernateSessionFactory()
			.getSessionFactory("hibernate-heroku.cfg.xml");

	// https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
	// https://www.javacodegeeks.com/2012/09/hibernate-save-vs-persist-and.html#:~:text=Difference%20between%20save%20and%20saveOrUpdate%20in%20Hibernate,based%20upon%20existence%20of%20record.
	public boolean persist(Alumno transientInstance) {
		logger.log(Level.INFO, "persisting Alumno instance");
		try {
			Session sessionObj = sessionFactory.getCurrentSession();
			// Getting Transaction Object From Session Object
			Transaction tx = sessionObj.beginTransaction();
			sessionObj.persist(transientInstance);
			tx.commit();
			sessionObj.close();
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
		return true;
	}

	public boolean saveOrUpdate(Alumno instance) {
		logger.log(Level.INFO, "attaching dirty Alumno instance");
		try {
			Session sessionObj = sessionFactory.getCurrentSession();
			Transaction tx = sessionObj.beginTransaction();
			sessionObj.saveOrUpdate(instance);
			tx.commit();
			sessionObj.close();
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
		return true;
	}

	public Integer save(Alumno instance) {
		logger.log(Level.INFO, "attaching dirty Alumno instance");
		Integer alumnoId = 0;
		try {
			Session sessionObj = sessionFactory.getCurrentSession();
			Transaction tx = sessionObj.beginTransaction();
			alumnoId = (Integer) sessionObj.save(instance);
			tx.commit();
			sessionObj.close();
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
		return alumnoId;
	}

	@SuppressWarnings("unchecked")
	public List<Alumno> findAll() {
		logger.log(Level.INFO, "finding Alumno instance by example");

		List<Alumno> studentsList = null;
		try {
			// Getting Session Object From SessionFactory
			Session sessionObj = sessionFactory.getCurrentSession();
			// Getting Transaction Object From Session Object
			sessionObj.beginTransaction();

			Query studentsQuery = sessionObj.createQuery("FROM Alumno");

			studentsList = studentsQuery.getResultList();

			sessionObj.close();

		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
		return studentsList;
	}

	public boolean delete(java.lang.Integer id) {
		logger.log(Level.INFO, "deleting Alumno instance");
		try {
			// Getting Session Object From SessionFactory
			Session sessionObj = sessionFactory.getCurrentSession();
			// Getting Transaction Object From Session Object
			Transaction tx = sessionObj.beginTransaction();
			Alumno instance = (Alumno) sessionObj
					.get("com.sinensia.model.Alumno", id);
			sessionObj.delete(instance);
			tx.commit();
			sessionObj.close();
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}

		return true;
	}

	public Alumno merge(Integer id) {
		logger.log(Level.INFO, "merging Alumno instance");
		try {
			// Getting Session Object From SessionFactory
			Session sessionObj = sessionFactory.getCurrentSession();
			Transaction tx = sessionObj.beginTransaction();
			// Getting Transaction Object From Session Object
			Alumno instance = (Alumno) sessionObj
					.get("com.sinensia.model.Alumno", id);
			instance.setNombre("Merged");
			Alumno result = (Alumno) sessionObj.merge(instance);
			tx.commit();
			logger.log(Level.INFO, "merge successful");
			sessionObj.close();
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Alumno findById(java.lang.Integer id) {
		logger.log(Level.INFO, "getting Alumno instance with id: " + id);
		try {
			// Getting Session Object From SessionFactory
			Session sessionObj = sessionFactory.getCurrentSession();
			Transaction tx = sessionObj.beginTransaction();
			// Getting Transaction Object From Session Object
			Alumno instance = (Alumno) sessionObj
					.get("com.sinensia.model.Alumno", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			tx.commit();
			sessionObj.close();
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}
}
