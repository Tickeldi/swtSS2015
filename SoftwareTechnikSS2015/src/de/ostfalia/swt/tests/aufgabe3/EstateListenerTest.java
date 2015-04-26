package de.ostfalia.swt.tests.aufgabe3;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import de.ostfalia.swt.aufgabe3.ApartmentOrTrade;
import de.ostfalia.swt.aufgabe3.Estate;
import de.ostfalia.swt.aufgabe3.EstateUnit;

public class EstateListenerTest {
	
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
	public void testInitialValues() {
		assertEquals(100.0d, estate.getTradeAreaTotal(), 0.1);
		assertEquals(50.0d, estate.getApartmentsAreaTotal(), 0.1);
	}

	@Test
	public void testEstateListenerSetAot() {
	
		unitTwo.setAot(ApartmentOrTrade.Trade);
		
		assertEquals(150.0d, estate.getTradeAreaTotal(), 0.1);
		assertEquals(0.0d, estate.getApartmentsAreaTotal(), 0.1);
		
		unitOne.setAot(ApartmentOrTrade.Apartment);
		
		assertEquals(50.0d, estate.getTradeAreaTotal(), 0.1);
		assertEquals(100.0d, estate.getApartmentsAreaTotal(), 0.1);
		
	}
	
	@Test
	public void testEstateListenerSetRental() {
		unitOne.setRental(new BigDecimal(300));
		unitTwo.setRental(new BigDecimal(400));

		assertEquals(BigDecimal.valueOf(700).toString(), estate.getRentalTotal().toString());
	}
	
	@Test
	public void testEstateListenerSetArea() {
		unitOne.setArea(350.0d);
		unitTwo.setArea(450.0d);

		assertEquals(350.0d, estate.getTradeAreaTotal(), 0.1);
		assertEquals(450.0d, estate.getApartmentsAreaTotal(), 0.1);
	}

}
