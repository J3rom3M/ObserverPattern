package com.formation.observer;

import java.util.Calendar;
import java.util.ArrayList;

public class Horloge implements Observable {
  //Objet calendrier pour r�cup�rer l'heure courante
  private Calendar cal;
  private String hour = "";
  
  private ArrayList<Observeur> listObservateur = new ArrayList<Observeur>();

  public void run() {
    while(true){
    //On r�cup�re l'instance d'un calendrier � chaque tour
    //Elle va nous permettre de r�cup�rer l'heure actuelle
    this.cal = Calendar.getInstance();
    this.hour =  //Les heures
      this.cal.get(Calendar.HOUR_OF_DAY) + " : "
      +
      (    //Les minutes
        this.cal.get(Calendar.MINUTE) < 10
        ? "0" + this.cal.get(Calendar.MINUTE)
        : this.cal.get(Calendar.MINUTE)
      )
      + " : "
      +
      (    //Les secondes
        (this.cal.get(Calendar.SECOND)< 10)
        ? "0"+this.cal.get(Calendar.SECOND)
        : this.cal.get(Calendar.SECOND)
      );
    
      // On avertit les observateurs que l'heure � �t� mise � jour
      this.updateObservateur();
    
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

@Override
public void addObservateur(Observeur obs) {
	// TODO Auto-generated method stub
	this.listObservateur.add(obs);
}


@Override
public void delObservateur() {
	// TODO Auto-generated method stub
	this.listObservateur = new ArrayList<Observeur>();
}

@Override
public void updateObservateur() {
	// TODO Auto-generated method stub
	for(Observeur obs : this.listObservateur )
		obs.update(this.hour);
}
}