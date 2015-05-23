package de.ostfalia.swt.aufgabe5;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "estateUnit")
public class EstateUnit {
	
	private ApartmentOrTrade aot;
	private double area;
	private java.math.BigDecimal rental;
	private Integer id;
	
	public EstateUnit(){
		
	}
	
	public EstateUnit(ApartmentOrTrade aot, double area, BigDecimal rental) {
		this.aot = aot;
		this.area = area;
		this.rental = rental;
	}
	
	
	ApartmentOrTrade getAot() {
		return aot;
	}
	void setAot(ApartmentOrTrade aot) {
		this.aot = aot;
	}
	double getArea() {
		return area;
	}
	void setArea(double area) {
		this.area = area;
	}
	java.math.BigDecimal getRental() {
		return rental;
	}
	void setRental(java.math.BigDecimal rental) {
		this.rental = rental;
	}
	
}
