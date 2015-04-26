package de.ostfalia.swt.tests.aufgabe2;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ServiceLoader;

import org.junit.Test;

import de.ostfalia.swt.aufgabe2.ApartmentOrTrade;
import de.ostfalia.swt.aufgabe2.Estate;
import de.ostfalia.swt.aufgabe2.EstateUnit;

public class ServiceLoaderTest {

	@Test
	public void testServiceLoader() {
		
		EstateUnit tradeUnit = new EstateUnit(ApartmentOrTrade.Trade, 20.0, new BigDecimal(100));
        EstateUnit apartmentUnit = new EstateUnit(ApartmentOrTrade.Apartment, 40.0, new BigDecimal(400));
        
		ServiceLoader<Estate> EstateServiceLoader = ServiceLoader.load(Estate.class);

		int i = 0;
		for(Estate estateImplementierung: EstateServiceLoader) {
			estateImplementierung.addUnit(tradeUnit);
			estateImplementierung.addUnit(apartmentUnit);
			
			assertEquals(40.0, estateImplementierung.getApartmentsAreaTotal(), 0.1);
			assertEquals(20.0, estateImplementierung.getTradeAreaTotal(), 0.1);
			
			i++;
			
			System.out.println(estateImplementierung.getClass().getName());
		}
		
		assertEquals("Zwei Implementierungen sollten geladen werden.", 2, i);
	}

}
