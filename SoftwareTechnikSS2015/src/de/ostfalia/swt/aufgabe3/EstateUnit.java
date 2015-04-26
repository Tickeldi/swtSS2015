package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;

public class EstateUnit {
	
	private EstateUnitChangedListener listener;
	private ApartmentOrTrade aot;
	private double area;
	private BigDecimal rental = new BigDecimal(0);
	
	public EstateUnit(ApartmentOrTrade aot, 
			double area, 
			BigDecimal rental) {
		
		this.aot = aot;
		this.area = area;
		this.rental = rental;
		
	}
	
	public void addEstateUnitChangedListener(EstateUnitChangedListener listener) {
		this.listener = listener;
	}
	
	public ApartmentOrTrade getAot() {
		return aot;
	}
	public void setAot(ApartmentOrTrade aot) {
		ApartmentOrTrade oldAot = this.aot;
		this.aot = aot;
		
		listener.estateUnitChanged(new EstateUnitChangedEvent(this, oldAot));
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		double oldArea = this.area;
		this.area = area;
		listener.estateUnitChanged(new EstateUnitChangedEvent(this, oldArea));
		
	}
	public BigDecimal getRental() {
		return rental;
	}
	public void setRental(BigDecimal rental) {
		BigDecimal oldRental = this.rental;
		this.rental = rental;
		listener.estateUnitChanged(new EstateUnitChangedEvent(this, oldRental));
	}
}
