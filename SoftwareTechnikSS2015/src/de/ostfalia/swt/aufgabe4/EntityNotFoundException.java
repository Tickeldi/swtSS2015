package de.ostfalia.swt.aufgabe4;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException() {
		
	}
	
	EntityNotFoundException(String message) {
		super(message);
	}

}
