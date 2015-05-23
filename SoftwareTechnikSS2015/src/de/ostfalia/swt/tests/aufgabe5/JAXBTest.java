package de.ostfalia.swt.tests.aufgabe5;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.ostfalia.swt.aufgabe5.ApartmentOrTrade;
import de.ostfalia.swt.aufgabe5.Estate;
import de.ostfalia.swt.aufgabe5.EstateUnit;

public class JAXBTest {
		
	private static final String ESTATE_XML = "./estate-jaxb.xml";

	@Before
	public void setUp() throws Exception {

		
	}

	@After
	public void tearDown() throws Exception {
		File xmlFile = new File(ESTATE_XML);
		if(xmlFile.exists()) {
			xmlFile.delete();
		}
	}

	@Test
	public void test() throws JAXBException {
		Estate estate = new Estate();
		EstateUnit unitOne = new EstateUnit(ApartmentOrTrade.Trade, 100, BigDecimal.valueOf(200));
		EstateUnit unitTwo = new EstateUnit(ApartmentOrTrade.Apartment, 300, BigDecimal.valueOf(100));
		
		estate.addUnit(unitOne);
		estate.addUnit(unitTwo);
		
		System.out.println(estate.getApartmentsAreaTotal());
		
		
		JAXBContext context = JAXBContext.newInstance(Estate.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		 
		marshaller.marshal(estate, System.out);
		 
		//marshaller.marshal(estate, new File(ESTATE_XML));
	}

}
