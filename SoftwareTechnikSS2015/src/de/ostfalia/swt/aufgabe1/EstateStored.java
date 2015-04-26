package de.ostfalia.swt.aufgabe1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EstateStored implements Estate{
	List<EstateUnit> units = new ArrayList<>();
	
	private double apartmentsAreaTotal = 0;
	private int numberOfUnits = 0;
	BigDecimal rentalTotal = new BigDecimal(0);
	private double tradeAreaTotal = 0;
	
	public EstateStored() {
		
	}

	@Override
	public void addUnit(EstateUnit unit) {
		if(unit.getAot().equals(ApartmentOrTrade.Apartment)) {
			apartmentsAreaTotal += unit.getArea();
		}
		else{
			tradeAreaTotal += unit.getArea();
		}

		numberOfUnits++;
		rentalTotal = rentalTotal.add(unit.getRental());
		units.add(unit);
	}

	@Override
	public double getApartmentsAreaTotal() {
		return apartmentsAreaTotal;
	}

	@Override
	public int getNumberOfUnits() {
		return numberOfUnits;
	}

	@Override
	public BigDecimal getRentalTotal() {
		return rentalTotal;
	}

	@Override
	public double getTradeAreaTotal() {
		return tradeAreaTotal;
	}

	@Override
	public List<EstateUnit> getUnits() {
		return units;
	}

}
