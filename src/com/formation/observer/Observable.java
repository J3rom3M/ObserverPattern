package com.formation.observer;

public interface Observable {
	
	public void addObservateur(Observeur obs);
	
	public void delObservateur();
	
	public void updateObservateur();

}
