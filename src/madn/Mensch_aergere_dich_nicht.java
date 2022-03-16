package madn;

import java.util.ArrayList;
import java.util.Scanner;

public class Mensch_aergere_dich_nicht {
	
	
	// Anfang Attribute
	//Attribute
	private int anzSpieler;
	private Spieler[] spieler;
	ArrayList<Spieler> players = new ArrayList<Spieler>();
	private Spielfeld meinSpielfeld;
	private Regelwerk meinRegelwerk;
	// Ende Attribute
	
	
	//Konstruktor
	/*public Mensch_aergere_dich_nicht (int anzSpieler, Spieler[] Spieler, Spielfeld meinSpielfeld, Regelwerk meinRegelwerk){
		
		this.anzSpieler = anzSpieler;  
		//this.Spieler[] = Spieler[];
		this.meinSpielfeld = meinSpielfeld;
		this.meinRegelwerk = meinRegelwerk;
	}*/
		  
	
	//Methoden
	public Spielfeld initialisiereSpielfeld() {
		//Begruessung und Anzahl der Spieler waehlen
		System.out.println("Herzlich Willkommen bei >Informatiker*in aergere dich nicht<!");
		System.out.println("Bitte die Anzahl der Spieler*innen eingeben: ");
		Scanner sc = new Scanner(System.in);
		int anzSpieler = Integer.parseInt(sc.nextLine());
	
		//DAU 2-4 Spieler
		while((anzSpieler < 2)||(anzSpieler>4)) {
			System.out.println("Mensch aergere dich nicht ist ein Spiel für 2-4 Spieler.");
			System.out.println("Bitte die Anzahl der Spieler*innen eingeben: ");
			anzSpieler = Integer.parseInt(sc.nextLine());
		}
		
		
		//Spieler erstellen, Farben zuweisen, Spielfiguren erstellen und positionieren
		//Dummy name
		String name = "Max Muster";
		for(int i = 0; i < anzSpieler; i++) {
		
			System.out.println("Bitte den Namen der " + (i+1) + ". Person eingeben: ");
			name = sc.nextLine();
			//Dummy farbe
			String farbe = "bleu";
	
			switch(i) {
			case 0: 
				farbe = "blau";
				//cathy.setName(name);
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				break;
			case 1:
				farbe = "gelb";				
				//tobi.setName(name);
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);				
				break;
			case 2:	
				farbe = "rot";
				//hendrik.setName(name);
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				break;
			case 3:
				farbe = "gruen";
				//florian.setName(name);
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				break;	
			}
			spieler[i]  = new Spieler(name, farbe);
			
			//aktives Spielfeld erzeugen
			Spielfeld meinspielfeld=new Spielfeld(Spieler... spieler);
			meinspielfeld.ausgabe();
			System.out.println(spieler[i].getFiguren());
		
		}			

		//System.out.println(cathy.getName());
		sc.close();
	return meinSpielfeld;
	}
	
	

	public void spielen() {
		
		
		
		//Abbruchbedingung anlegen
		boolean finished = false;
		
		//Zaehler fuer aktiven Spieler
		int zaehler = 0;
		int zaehlerAktiv = 0;
		
		//Eigentlicher Spielablauf
		while(finished != true) {
			
			for(int k = 0; k < anzSpieler; k++) {
				meinSpielfeld.wuerfeln();
				spielfigurWaehlen(Spieler[k]);
				//meinSpielfeld.sucheFeldposition(meinSpielfeld, spielfigur);
				//meinSpielfeld.ziehen(w, i, zugMoeglich);
			}
			
			finished = true;
			zaehler ++;
		}
		
	}
	
	
	public Spielfigur spielfigurWaehlen(Spieler[]) {
		System.out.println("Welche Figur soll bewegt werden? 0-3?");
		meinSpieler.getFiguren();
		return Spielfigur;
	}
	
	public void addPlayer() {
		players.add( spieler );
	}
	
}

