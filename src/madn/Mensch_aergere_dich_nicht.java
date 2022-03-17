package madn;

import java.util.ArrayList;
import java.util.*;

public class Mensch_aergere_dich_nicht {
	
	
	// Anfang Attribute
	//Attribute
	private int anzSpieler;
	public Spieler[] spieler = new Spieler[4] ;
	ArrayList<Spieler> players = new ArrayList<Spieler>();
	private Spielfeld meinspielfeld;
	// Ende Attribute
	
	
	//Konstruktor
	/*public Mensch_aergere_dich_nicht (Regelwerk meinRegelwerk){
		
		//this.anzSpieler = anzSpieler;  
		//this.Spieler[] = Spieler[];
		//this.meinspielfeld = meinspielfeld;
		this.meinRegelwerk = meinRegelwerk;
	}*/
		  
	
	//Methoden
	public void initialisiereSpielfeld() {
		//Begruessung und Anzahl der Spieler waehlen
		System.out.println("Herzlich Willkommen bei >Informatiker*in aergere dich nicht<!");
		System.out.println("Bitte die Anzahl der Spieler*innen eingeben: ");
		//Scanner sc = new Scanner(System.in);
		//int anzSpieler = Integer.parseInt(sc.nextLine());
		int anzSpieler = Integer.parseInt(eingabeAbfragen());
		
		//DAU 2-4 Spieler
		while((anzSpieler < 2)||(anzSpieler>4)) {
			System.out.println("Mensch aergere dich nicht ist ein Spiel fuer 2-4 Spieler.");
			System.out.println("Bitte die Anzahl der Spieler*innen eingeben: ");
			//anzSpieler = Integer.parseInt(sc.nextLine());
			anzSpieler = Integer.parseInt(eingabeAbfragen());
		}
		
		setAnzSpieler(anzSpieler);
		
		//Dummy Spieler
		/*Spieler cathy = new Spieler("Cathy", "blau");
		Spieler tobi = new Spieler("Tobi", "rot");
		Spieler hendrik = new Spieler("Hendrik", "grün");
		Spieler florian = new Spieler("Florian", "gelb");*/
		//Spieler[] spieler = new Spieler[4] ;
		
		//Spieler erstellen, Farben zuweisen, Spielfiguren erstellen und positionieren
		//Dummy name
		String name = "Max Muster";
		for(int i = 0; i < anzSpieler; i++) {
		
			System.out.println("Bitte den Namen der " + (i+1) + ". Person eingeben: ");
			//name = sc.nextLine();
			name = eingabeAbfragen();
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
		
		}	
		
		if(anzSpieler < 4) {
			for(int l = anzSpieler; l<4 ; l++)
			spieler[l] = new Spieler("Dummy", "--");
		}
		
		
		
		//aktives Spielfeld erzeugen
		Spielfeld meinspielfeld=new Spielfeld(spieler[0], spieler[1], spieler[2], spieler[3]);
		
		meinspielfeld.ausgabe();
		System.out.println(spieler[0].getFiguren());

		//System.out.println(cathy.getName());
		//sc.close();
	
		setMeinSpielfeld(meinspielfeld);
		//return meinspielfeld;
	}
	
	

	public void spielen() {
		
		//Abbruchbedingung anlegen
		boolean finished = false;
		int wuerfel;
		//Scanner sc1 = new Scanner(System.in);
		//String eingabe = "test";
		//eingabe = sc1.nextLine();
		//System.out.println(getMeinSpielfeld());
		//Eigentlicher Spielablauf
		while(finished != true) {
			meinspielfeld.ausgabe();
			for(int k = 0; k < anzSpieler; k++) {
				Spieler curSpieler = this.spieler[k];
				System.out.println(curSpieler.getName() + " du bist an der Reihe!");
				//wuerfel = meinspielfeld.wuerfeln();
				wuerfel = 6;
				//System.out.println(wuerfel);
				//System.out.println(meinspielfeld.wuerfeln());
				System.out.println("Welche Spielfigur?");
				String eingabe = eingabeAbfragen();
				
				//Rausziehen
				for(int j = 0; j < 20; j++) {
					if((wuerfel==6)/* && (meinspielfeld[i]==null)*/) {
						if(Regelwerk.zugErlaubt(meinspielfeld, meinspielfeld.spielfigurselect(eingabe), wuerfel)) {
							meinspielfeld.rausgehen(meinspielfeld.spielfigurselect(eingabe));
							wuerfel = meinspielfeld.wuerfeln();
						}
						
					}	
				}
				
				meinspielfeld.ausgabe();
				//meinspielfeld.spielfigurWaehlen(Spieler[k]);
				
				//meinSpielfeld.sucheFeldposition(meinSpielfeld, spielfigur);
				//meinSpielfeld.ziehen(w, i, zugMoeglich);
			
				if(meinspielfeld.sieg()) {
					finished = true;
					break;
				}
			}
	
			//sc1.close();
		}
		
	}
	
	public String eingabeAbfragen() {
		String eingabe = "test";
		Scanner scan = new Scanner(System.in);
		eingabe = scan.nextLine();
		return eingabe;
	}
	
	public void setAnzSpieler(int anzSpieler) {
		this.anzSpieler = anzSpieler;
	}
	
	public void setMeinSpielfeld(Spielfeld meinspielfeld) {
		this.meinspielfeld = meinspielfeld;
	}
	
	//get meinSpielfeld
	public Spielfeld getMeinSpielfeld() {
			return meinspielfeld;
		}
	
	//get Spieler
		public Spieler getMeinSpieler(int i) {
				return spieler[i];
			}
	
	/*public Spielfigur spielfigurWaehlen(Spieler curSpieler) {
		System.out.println("Welche Figur soll bewegt werden? " + curSpieler.getFiguren().getFarbe());
		Scanner sc = new Scanner(System.in);
		String eingabe = sc.nextLine();
		for(int i = 0; i < 4; i++) {
			figur[i];
		}
		return spielfigur;
	}*/
	
}


