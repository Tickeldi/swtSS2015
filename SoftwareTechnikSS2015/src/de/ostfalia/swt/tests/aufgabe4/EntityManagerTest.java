package de.ostfalia.swt.tests.aufgabe4;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import org.junit.Test;

import de.ostfalia.swt.aufgabe4.ApartmentOrTrade;
import de.ostfalia.swt.aufgabe4.EntityManager;
import de.ostfalia.swt.aufgabe4.EntityNotFoundException;
import de.ostfalia.swt.aufgabe4.Estate;
import de.ostfalia.swt.aufgabe4.EstateUnit;

public class EntityManagerTest {
	EntityManager manager = EntityManager.getInstance();

	@Test
	public void testSingleton() throws NoSuchMethodException, SecurityException {
		assertTrue("Singleton Pattern nicht richtig umgesetzt.",
				EntityManager.getInstance() == EntityManager.getInstance());
		assertEquals("Konstruktor nicht privat.",
				Modifier.PRIVATE,
				EntityManager.class.getDeclaredConstructor().getModifiers());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSaveOrUpdateIllegalArgumentException() {
		manager.saveOrUpdate(null);
	}
	
	@Test
	public void testSaveOrUpdateGiveNewID() {
		Estate entity = new Estate();
	
		assertTrue(entity.getId() == null);
		manager.saveOrUpdate(entity);
		assertFalse(entity.getId() == null);
	}
	
	@Test
	public void testSaveOrUpdateAndFind() throws EntityNotFoundException {
		Estate estateEntity = new Estate();
		EstateUnit unitEntity = new EstateUnit(
				ApartmentOrTrade.Trade, 
				200.0d, 
				new BigDecimal(100)
				);
		
		estateEntity.setID(0);
		unitEntity.setID(0);
		
		manager.saveOrUpdate(estateEntity);
		manager.saveOrUpdate(unitEntity);
		
		assertTrue(manager.find(Estate.class, 0) == estateEntity);
		assertTrue(manager.find(EstateUnit.class, 0) == unitEntity);
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void testFindEntityNotFoundException() throws EntityNotFoundException {
		manager.find(Estate.class, Integer.MAX_VALUE);
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void testRemove() throws EntityNotFoundException {
		manager.remove(manager.find(Estate.class, 0));
		manager.find(Estate.class, 0);
	}

}
