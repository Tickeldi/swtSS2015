package de.ostfalia.swt.aufgabe4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Estate implements Entity{
	private Integer id;
	private List<EstateUnit> units = new ArrayList<>();
	
	public Estate() {
		
	}

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
	
	public double getApartmentsAreaTotal() {
		return getAreaTotal(ApartmentOrTrade.Apartment);
	}

	public int getNumberOfUnits() {
		return units.size();
	}

	public BigDecimal getRentalTotal() {
		BigDecimal rentalTotal = new BigDecimal(0);
		for(EstateUnit unit:units) {
			rentalTotal = rentalTotal.add(unit.getRental());
		}
		return rentalTotal;
	}

	public double getTradeAreaTotal() {
		return getAreaTotal(ApartmentOrTrade.Trade);
	}

	public List<EstateUnit> getUnits() {
		return units;
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

