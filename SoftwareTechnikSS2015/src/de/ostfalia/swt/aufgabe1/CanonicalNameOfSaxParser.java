package de.ostfalia.swt.aufgabe1;

import javax.xml.parsers.SAXParserFactory;

public class CanonicalNameOfSaxParser {

	public static void main(String[] args) {
		System.setProperty("javax.xml.parsers.SAXParserFactory", "org.apache.xerces.jaxp.SAXParserFactoryImpl");
		String kanonischerName = 
				SAXParserFactory.newInstance().getClass().getCanonicalName();
		
		System.out.println(kanonischerName);

	}

}
