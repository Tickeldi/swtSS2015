package de.ostfalia.swt.aufgabe1;

public interface Estate {
	
	void addUnit(EstateUnit unit);	
	double getApartmentsAreaTotal();	
	int getNumberOfUnits();	
	java.math.BigDecimal getRentalTotal();	
	double getTradeAreaTotal();	
	java.util.List<EstateUnit> getUnits();
	
}
