package madn;

import java.util.*;

public class Mensch_aergere_dich_nicht {
	
	
	// Anfang Attribute
	//Attribute
	private int anzSpieler;
	public Spieler[] spieler = new Spieler[4] ;
	private Spielfeld meinspielfeld;
	// Ende Attribute
	
	//Methoden
	public void initialisiereSpielfeld() {
		//Begruessung und Anzahl der Spieler waehlen
		System.out.println("Herzlich Willkommen bei >Informatiker*in aergere dich nicht<!");
		System.out.println("Bitte die Anzahl der Spieler*innen eingeben: ");
		int anzSpieler = Integer.parseInt(eingabeAbfragen());
		
		//DAU 2-4 Spieler
		while((anzSpieler < 2)||(anzSpieler>4)) {
			System.out.println("Mensch aergere dich nicht ist ein Spiel fuer 2-4 Spieler.");
			System.out.println("Bitte die Anzahl der Spieler*innen eingeben: ");
			anzSpieler = Integer.parseInt(eingabeAbfragen());
		}
		
		setAnzSpieler(anzSpieler);
		
		String name = "Max Muster";
		for(int i = 0; i < anzSpieler; i++) {
		
			System.out.println("Bitte den Namen der " + (i+1) + ". Person eingeben: ");
			
			name = eingabeAbfragen();
			
			String farbe = "bleu";
	
			switch(i) {
			case 0: 
				farbe = "blau";
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				break;
			case 1:
				farbe = "gelb";				
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);				
				break;
			case 2:	
				farbe = "rot";
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				break;
			case 3:
				farbe = "gruen";
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				break;	
			}
			spieler[i]  = new Spieler(name, farbe);	
		
		}	
		
		if(anzSpieler < 4) {
			for(int l = anzSpieler; l<4 ; l++)
			spieler[l] = new Spieler("Dummy", "--");
		}
			
		
		//aktives Spielfeld erzeugen
		Spielfeld meinspielfeld=new Spielfeld(spieler[0], spieler[1], spieler[2], spieler[3]);
		
		meinspielfeld.ausgabe();
		
		setMeinSpielfeld(meinspielfeld);
	}
	
	

	public void spielen() {
		
		boolean finished = false;
		int wuerfel;
		
		//Eigentlicher Spielablauf
		meinspielfeld.ausgabe();
		while(finished != true) {
			for(int k = 0; k < anzSpieler; k++) {
				Spieler curSpieler = this.spieler[k];
				System.out.println(curSpieler.getName() + " du bist an der Reihe!");
				
				boolean ok=false;
				int counterRaus = 0;
				do{			
					wuerfel = meinspielfeld.wuerfeln();
					System.out.println("Welche Spielfigur?");
					String eingabe = eingabeAbfragen();
					Spielfigur figur=meinspielfeld.spielfigurselect(eingabe);
					while(curSpieler.figurTeilSpieler(figur)==false) {
						System.out.println("Bitte eine andere Figur wählen!");
						eingabe = eingabeAbfragen();
						figur=meinspielfeld.spielfigurselect(eingabe);
					}	
					if (Regelwerk.arrayFinden(meinspielfeld, meinspielfeld.spielfigurselect(eingabe))==1) {
					meinspielfeld.ziehen(wuerfel, meinspielfeld.spielfigurselect(eingabe));
					} else {
						if ((Regelwerk.arrayFinden(meinspielfeld, meinspielfeld.spielfigurselect(eingabe))==0) && (wuerfel==6)) {	
							meinspielfeld.rausgehen(meinspielfeld.spielfigurselect(eingabe));
						} else {
							if ((Regelwerk.arrayFinden(meinspielfeld, meinspielfeld.spielfigurselect(eingabe))==0) && (wuerfel!=6) && (meinspielfeld.spielfeldLeer(curSpieler)==false)) {
								System.out.println("Bitte wählen Sie eine andere Figur, sie können mit der Würfelzahl nicht herausziehen.");
								ok=true;
							} else {
								if ((Regelwerk.arrayFinden(meinspielfeld, meinspielfeld.spielfigurselect(eingabe))==0) && (wuerfel!=6)) {
									System.out.println("Rausgehen nicht möglich, da keine Sechs gewürfelt wurde!");
								}
							}		
						}
					}
					System.out.println();			
					meinspielfeld.ausgabe();
					counterRaus++;
					/*if(wuerfel == 6) {
						wuerfel = meinspielfeld.wuerfeln();
					}*/
					//System.out.println(meinspielfeld.spielfeldLeer(curSpieler));
				}while (((meinspielfeld.spielfeldLeer(curSpieler)==true) && (wuerfel != 6) && (counterRaus < 3) )|| ( (wuerfel == 6) && (ok==false))); 
			}
			if(meinspielfeld.sieg()) {
				finished = true;
			}
		}
	}
	
	// Hilfsmethoden
	
	private String eingabeAbfragen() {
		String eingabe = "test";
		Scanner scan = new Scanner(System.in);
		eingabe = scan.nextLine();
		return eingabe;
	}
	
	private void setAnzSpieler(int anzSpieler) {
		this.anzSpieler = anzSpieler;
	}
	
	private void setMeinSpielfeld(Spielfeld meinspielfeld) {
		this.meinspielfeld = meinspielfeld;
	}
	
}
