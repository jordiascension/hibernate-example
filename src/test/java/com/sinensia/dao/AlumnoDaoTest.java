package com.sinensia.dao;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sinensia.model.Alumno;

public class AlumnoDaoTest {

	AlumnoDao alumnoDao = null;
	static Integer idUpdated = 0;
	static Integer idDeleted = 0;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Alumno alumno = new Alumno();
		alumno.setNombre("Pepe");
		alumno.setApellidos("Soto");
		alumno.setDni("343434343z");

		Alumno alumno1 = new Alumno();
		alumno1.setNombre("Deleted");
		alumno1.setApellidos("Soto");
		alumno1.setDni("343434343z");

		AlumnoDao alumnoDaoBeforeClass = new AlumnoDao();

		idUpdated = alumnoDaoBeforeClass.save(alumno);
		idDeleted = alumnoDaoBeforeClass.save(alumno1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		alumnoDao = new AlumnoDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		assertTrue(alumnoDao.findAll().size() > 1);
	}

	@Test
	public void testPersist() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Persisted");
		alumno.setApellidos("Soto");
		alumno.setDni("343434343z");
		assertTrue(alumnoDao.persist(alumno) == true);
	}

	@Test
	public void testSaveOrUpdate() {
		Alumno alumno = new Alumno();
		alumno.setNombre("SaveOrUpdate");
		alumno.setApellidos("Soto");
		alumno.setDni("343434343z");
		assertTrue(alumnoDao.saveOrUpdate(alumno) == true);
	}

	@Test
	public void testDelete() {
		assertTrue(alumnoDao.delete(idDeleted) == true);
	}

	@Test
	public void testMerge() {
		assertTrue(alumnoDao.merge(idUpdated) != null);
	}

}
