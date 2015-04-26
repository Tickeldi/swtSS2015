package de.ostfalia.swt.aufgabe1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EstateComputed implements Estate{
	List<EstateUnit> units = new ArrayList<>();
	
	public EstateComputed() {
		
	}

	@Override
	public void addUnit(EstateUnit unit) {
		units.add(unit);
	}

	private double getAreaTotal(ApartmentOrTrade aot) {
		double areaTotal = 0;
		for(EstateUnit unit:units) {
			if(unit.getAot().equals(aot)) {
				areaTotal += unit.getArea();
			}
		}
		return areaTotal;
	}
	
	@Override
	public double getApartmentsAreaTotal() {
		return getAreaTotal(ApartmentOrTrade.Apartment);
	}

	@Override
	public int getNumberOfUnits() {
		return units.size();
	}

	@Override
	public BigDecimal getRentalTotal() {
		BigDecimal rentalTotal = new BigDecimal(0);
		for(EstateUnit unit:units) {
			rentalTotal = rentalTotal.add(unit.getRental());
		}
		return rentalTotal;
	}

	@Override
	public double getTradeAreaTotal() {
		return getAreaTotal(ApartmentOrTrade.Trade);
	}

	@Override
	public List<EstateUnit> getUnits() {
		return units;
	}

}

