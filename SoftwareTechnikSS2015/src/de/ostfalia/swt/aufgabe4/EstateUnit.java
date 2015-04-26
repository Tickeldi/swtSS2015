package de.ostfalia.swt.aufgabe4;

public class EstateUnit implements Entity{
	
	private Integer id;
	private ApartmentOrTrade aot;
	private double area;
	private java.math.BigDecimal rental;
	
	public EstateUnit(ApartmentOrTrade aot, 
			double area, 
			java.math.BigDecimal rental) {
		
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

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setID(Integer id) {
		this.id = id;
		
	}
	
	
}
