package de.ostfalia.swt.aufgabe5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "de.ostfalia.swt.aufgabe5")
public class Estate {
	@XmlElementWrapper(name = "estateUnitList")
	@XmlElement(name = "estateUnit")
	private ArrayList<EstateUnit> units;

	public Estate() {
		units = new ArrayList<>();
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

}

