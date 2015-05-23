package de.ostfalia.swt.tests.aufgabe5;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import de.ostfalia.swt.aufgabe5.ApartmentOrTrade;
import de.ostfalia.swt.aufgabe5.Estate;
import de.ostfalia.swt.aufgabe5.EstateUnit;

public class JAXBTest {
		
	private static final String ESTATE_XML = "./estate-jaxb.xml";

	@Test
	public void test() throws JAXBException, 
			FileNotFoundException, 
			SecurityException, 
			NoSuchMethodException, 
			IllegalAccessException, 
			IllegalArgumentException, 
			InvocationTargetException {
		Estate estate = new Estate();
		EstateUnit unitOne = new EstateUnit(ApartmentOrTrade.Trade, 100, BigDecimal.valueOf(200));
		EstateUnit unitTwo = new EstateUnit(ApartmentOrTrade.Apartment, 300, BigDecimal.valueOf(100));
		
		estate.addUnit(unitOne);
		estate.addUnit(unitTwo);
		
		JAXBContext context = JAXBContext.newInstance(Estate.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	
		//XML Output auf Konsole für Fehlersuche
		marshaller.marshal(estate, System.out);
	
		File file = new File(ESTATE_XML);
		file.deleteOnExit();
		
		marshaller.marshal(estate, file);
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Estate estateFromXML = (Estate) unmarshaller.unmarshal(new FileReader(ESTATE_XML));
		
		assertEquals(estate.getNumberOfUnits(), estateFromXML.getNumberOfUnits());
		
		/*
		 * Nun etwas schwarze reflection Magie um Werte in den EstatUnits
		 * direkt vergleichen zu können 
		 */
		EstateUnit unitOneFromXML = estateFromXML.getUnits().get(0);
		EstateUnit unitTwoFromXML = estateFromXML.getUnits().get(1);
		
		Method methodGetArea = EstateUnit.class.getDeclaredMethod("getArea", new Class[0]);
		methodGetArea.setAccessible(true);
		
		double areaUnitOne = (double) methodGetArea.invoke(unitOne, new Object[0]);
		double areaUnitTwo = (double) methodGetArea.invoke(unitTwo, new Object[0]);
		double areaUnitOneFromXML = (double) methodGetArea.invoke(unitOneFromXML, new Object[0]);
		double areaUnitTwoFromXML = (double) methodGetArea.invoke(unitTwoFromXML, new Object[0]);
				
		assertEquals(areaUnitOne, areaUnitOneFromXML, 0.1);
		assertEquals(areaUnitTwo, areaUnitTwoFromXML, 0.1);
	}

}
