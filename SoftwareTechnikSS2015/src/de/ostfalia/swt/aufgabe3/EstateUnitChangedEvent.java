package de.ostfalia.swt.aufgabe3;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.EventObject;

public class EstateUnitChangedEvent extends EventObject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ApartmentOrTrade oldApartmentOrTrade;
	private double oldArea = -1;
	private BigDecimal oldRental;
	
	private String toStringMessage;

	public EstateUnitChangedEvent(Object source, ApartmentOrTrade oldApartmentOrTrade) {
		super(source);
		this.oldApartmentOrTrade = oldApartmentOrTrade;
		
		toStringMessage = "Old value: " + oldApartmentOrTrade.toString() + " | ";
		toStringMessage += " New value: " + ((EstateUnit) source).getAot().toString();
	}
	
	public EstateUnitChangedEvent(Object source, double oldArea) {
		super(source);
	this.oldArea = oldArea;
	
		toStringMessage = "Old value: " + oldArea + " | ";
		toStringMessage += " New value: " + ((EstateUnit) source).getArea();
	}
	
	public EstateUnitChangedEvent(Object source, BigDecimal oldRental) {
		super(source);
		this.oldRental = oldRental;
		
		toStringMessage = "Old value: " + oldRental.toString() + " | ";
		toStringMessage += " New value: " + ((EstateUnit) source).getRental().toString();
	}
	
	public ApartmentOrTrade getOldApartmentOrTrade() {
		return oldApartmentOrTrade;
	}
	
	public double getOldArea() {
		return oldArea;
	}
	
	public BigDecimal getOldRental(){
		return oldRental;
	}
	
	public String toString() {
		return toStringMessage;
	}
	
}
