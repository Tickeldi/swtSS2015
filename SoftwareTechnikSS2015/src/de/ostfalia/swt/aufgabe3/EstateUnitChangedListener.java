package de.ostfalia.swt.aufgabe3;

import java.util.EventListener;

public interface EstateUnitChangedListener extends EventListener{
	void estateUnitChanged(EstateUnitChangedEvent e);
}
