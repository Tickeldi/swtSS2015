package de.ostfalia.swt.tests.aufgabe3;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import de.ostfalia.swt.aufgabe3.Estate;
import de.ostfalia.swt.aufgabe3.EstateUnit;

import org.junit.Before;
import org.junit.Test;

import de.ostfalia.swt.aufgabe3.ApartmentOrTrade;

public class EstateTest {
	
	Estate estate;
	
	EstateUnit unitOne;
	EstateUnit unitTwo;
	
	@Before
	public void setUp() throws Exception {
		estate = new Estate();
		
		unitOne = new EstateUnit(ApartmentOrTrade.Trade, 100.0d, new BigDecimal(200));
		unitTwo = new EstateUnit(ApartmentOrTrade.Apartment, 50.0d, new BigDecimal(100));
		
		estate.addUnit(unitOne);
		estate.addUnit(unitTwo);
	}

	@Test
	public void testNumberOfUnits() {
		assertEquals(2, estate.getNumberOfUnits());		
	}
	
	@Test
	public void testRemoveUnits() {
		estate.removeUnit(unitOne);
		
		assertEquals(0.0, estate.getTradeAreaTotal(), 0.1);
		assertEquals(BigDecimal.valueOf(100).toString(), 
				estate.getRentalTotal().toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveUnitException() {
		estate.removeUnit(unitOne);
		estate.removeUnit(unitOne);
	}
	
	@Test(expected=Exception.class)
	public void testGetUnits() {
		List<EstateUnit> list = estate.getUnits();
		list.remove(0);
	}
	
	
}
