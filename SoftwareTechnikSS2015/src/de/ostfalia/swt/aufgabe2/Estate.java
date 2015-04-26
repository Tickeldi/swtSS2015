package de.ostfalia.swt.aufgabe2;

public interface Estate {
	
	void addUnit(EstateUnit unit);	
	double getApartmentsAreaTotal();	
	int getNumberOfUnits();	
	java.math.BigDecimal getRentalTotal();	
	double getTradeAreaTotal();	
	java.util.List<EstateUnit> getUnits();
	
}
