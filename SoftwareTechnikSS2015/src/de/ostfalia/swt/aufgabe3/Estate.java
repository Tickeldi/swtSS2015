package de.ostfalia.swt.aufgabe3;

import java.math.BigDecimal;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Estate implements EstateUnitChangedListener, EventListener {
	
	private List<EstateUnit> estateUnits = new LinkedList<>();
	private double apartmentArea;
	private double tradeArea;
	private BigDecimal rentalTotal = new BigDecimal(0);
	
	
	public void addUnit(EstateUnit unit) {
		estateUnits.add(unit);

		if(unit.getAot().equals(ApartmentOrTrade.Trade)) {
			tradeArea += unit.getArea();
		}
		else {
			apartmentArea += unit.getArea();
		}
		rentalTotal = rentalTotal.add(unit.getRental());
		
		unit.addEstateUnitChangedListener(this);
	}
	
	public int getNumberOfUnits() {
		return estateUnits.size();
	}
	
	public double getApartmentsAreaTotal() {
		return apartmentArea;
	}
	
	public double getTradeAreaTotal() {
		return tradeArea;
	}
	
	public BigDecimal getRentalTotal() {
		return rentalTotal;
	}
	
	public void removeUnit(EstateUnit unit) {
		if(unit == null || !estateUnits.contains(unit)) {
			throw new IllegalArgumentException();
		}
		estateUnits.remove(unit);
		
		if(unit.getAot().equals(ApartmentOrTrade.Trade)) {
			tradeArea -= unit.getArea();
		}
		else {
			apartmentArea -= unit.getArea();
		}
		
		rentalTotal = rentalTotal.subtract(unit.getRental());
	}
	
	public List<EstateUnit> getUnits() {
		return Collections.unmodifiableList(estateUnits);
	}

	@Override
	public void estateUnitChanged(EstateUnitChangedEvent e) {
		EstateUnit unit = (EstateUnit) e.getSource();
		
		double oldArea = e.getOldArea();
		double newArea = unit.getArea();

		if(oldArea != newArea && oldArea >= 0) {
			double differenz = newArea - oldArea;
			if(unit.getAot().equals(ApartmentOrTrade.Trade)) {
				tradeArea += differenz;
			}
			else {
				apartmentArea += differenz;
			}
		}
		
		else if(unit.getRental() != null
				&& e.getOldRental() != null
				&& !unit.getRental().equals(e.getOldRental())) {
			BigDecimal rentalDifference = 
					unit.getRental().subtract(e.getOldRental());
			rentalTotal = rentalTotal.add(rentalDifference);
		}
		
		else if(!e.getOldApartmentOrTrade().equals(unit.getAot())) {
			if(unit.getAot().equals(ApartmentOrTrade.Trade)) {
				apartmentArea -= newArea;
				tradeArea += newArea;
			}
			else {
				tradeArea -= newArea;
				apartmentArea += newArea;
			}
		}

	}
}