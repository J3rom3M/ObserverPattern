package com.formation.test;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.formation.observer.Horloge;
import com.formation.observer.Observeur;

public class ObserverTest  extends JFrame {
	

  private JLabel label = new JLabel();
  private Horloge horloge;

  public ObserverTest(){
    //On initialise la JFrame
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setSize(200, 80);
    //On initialise l'horloge
    this.horloge = new Horloge();
    
    this.horloge.addObservateur(new Observeur() {
    	public void update(String hour) {
    	  label.setText(hour);
    	}
    });
    
    //On initialise le JLabel
    Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
    this.label.setFont(police);
    this.label.setHorizontalAlignment(JLabel.CENTER);
    //On ajoute le JLabel � la JFrame
    this.getContentPane().add(this.label, BorderLayout.CENTER);
    this.setVisible(rootPaneCheckingEnabled);
    this.horloge.run();
  }

  //M�thode main() lan�ant le programme
  public static void main(String[] args){
    ObserverTest fen = new ObserverTest();
    fen.setVisible(true);
  }
}
