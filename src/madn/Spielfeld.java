package madn;
import java.util.Random;
public class Spielfeld {
	

	// Attribute
	
	private int l=20;										// Spielfeldgröße
	private Spielfigur[] startfeld = new Spielfigur[16]; 	// Startfeld der Länge 16 - Spieler 1 (0-3), Spieler 2(4-7), Spieler 3(8-11), Spieler 4 (12-15)
	private Spielfigur[] zielfeld = new Spielfigur[16];  	// Zielfeld der Länge 16 - Spieler 1 (0-3), Spieler 2(4-7), Spieler 3(8-11), Spieler 4 (12-15)
	private Spielfigur[] feld = new Spielfigur[l]; 			// Eigentliches Spielfeld
	private Spieler[] spieler;
	
	//---------------------------------------------------------------------------
	
	// Konstruktor

	public Spielfeld(Spieler... spieler) {
		this.spieler = spieler;
		int x =0;
		for (int z=0; z<4; z++) {
			for (int y=0; y<4; y++) {
				startfeld[x]=spieler[z].getFiguren()[y];
				x++;
			}
		}
	}
	
	//---------------------------------------------------------------------------	
	
	// Setter und Getter

	public Spielfigur[] getStartfeld() {
		return startfeld;
	}


	public void setStartfeld(Spielfigur[] startfeld) {
		this.startfeld = startfeld;
	}


	public Spielfigur[] getZielfeld() {
		return zielfeld;
	}


	public void setZielfeld(Spielfigur[] zielfeld) {
		this.zielfeld = zielfeld;
	}


	public Spielfigur[] getFeld() {
		return feld;
	}


	public void setFeld(Spielfigur[] feld) {
		this.feld = feld;
	}

	//---------------------------------------------------------------------------
	
	// Ausgabe des Spielfeldes

	
	private static void ausgabe_spielfeld(Spielfigur[] ausgabefelder, String spielfeldname) {
		System.out.print(spielfeldname+"\t");						
		for (int z=0; z<ausgabefelder.length; z++) {
			if (ausgabefelder.length<20 && (z==4 || z==8 || z==12))  {					// Viererblöcke im Start- und Zielfeld
				System.out.print("\t");
			}
			if (ausgabefelder[z]!=null) {												// Spielfiguren werden geschrieben
			System.out.print(ausgabefelder[z]+"\t");
			} else {
				System.out.print("O\t");												// Leere Felder werden geschrieben
			}
		}
		System.out.println();	
	}
	
	
	public void ausgabe() {																// Ausgabeaufrufe der verschiedenen Spielfelder		
		Spielfeld.ausgabe_spielfeld(startfeld, "Startfeld:" );
		Spielfeld.ausgabe_spielfeld(feld, "Spielfeld:" );
		Spielfeld.ausgabe_spielfeld(zielfeld, "Zielfeld:" );
		System.out.println();
	}
	
	//---------------------------------------------------------------------------
	
	// Methoden und Funktionen
		
	public int wuerfeln() {																// Methode Würfeln
		Random r = new Random();
		int w = r.nextInt(6)+1;
		System.out.println("Sie haben eine "+w+" gewürfelt!");
		return w;		
	}
	
	public int sucheFeldposition(Spielfigur[]sf, Spielfigur spielfigur) {				// Methode Spielfigur finden
		for (int i = 0; i < sf.length; i++) {
		if (sf[i] == spielfigur) {
		return i;
		}
		}
		return -1;
		}
	
	public int ziehen(int w, int i, boolean zugMoeglich){								// Abfrage, ob ein Zug möglich ist
		if (zugMoeglich == true) {
		int p = i + w;
		return p;
		}else {
			return -1;
		}
	}
	
	public void schlagen(int s){														// Schlagen
		Spielfigur figur= feld[s];
		Spieler sp = spielerZurFigur(figur);
		if (sp==spieler[0]) {
			for (int z=0; z<4; z++) {
				if (startfeld[z]==null) {
					startfeld[z]=figur;
					break;
				}
			}
		}
		if (sp==spieler[1]) {
			for (int z=4; z<8; z++) {
				if (startfeld[z]==null) {
					startfeld[z]=figur;
					break;
				}
			}
		}
		if (sp==spieler[2]) {
			for (int z=8; z<12; z++) {
				if (startfeld[z]==null) {
					startfeld[z]=figur;
					break;
				}
			}
		}
		if (sp==spieler[3]) {
			for (int z=12; z<16; z++) {
				if (startfeld[z]==null) {
					startfeld[z]=figur;
					break;
				}
			}
		}		
		
	}
	
		
	public boolean rausgehen(Spielfigur figur) {										 // rausgehen
		boolean a = false;
		for (int z=0; z<16; z++) {
			if (startfeld[z]==figur) {
				a= true;
				startfeld[z]=null;
				if (feld[0]!=null) {
					schlagen(0);
				}
				feld[0]=figur;
			}
		}
		if (a=false) {
		System.out.println("Die Figur befindet sich nicht im Startfeld!");
		}	
		
		return a;	
	}
	
	public void zielziehen(Spielfigur figur) {								// Methode ins Ziel ziehen!																		
		String farbe = figur.getFarbe();
		Spieler sp = spielerZurFigur(figur);
		for (int z=0; z<20; z++) {
			if (feld[z] == figur) {
				feld[z]=null;
			}
		}
		if (sp==spieler[0]) {
			int x =0;
			zielfeld[x]=figur;
			x++;
		}
		if (sp==spieler[1]) {
			int y =4;
			zielfeld[y]=figur;
			y++;
		}
		if (sp==spieler[2]) {
			int z =8;
			zielfeld[z]=figur;
			z++;
		}
		if (sp==spieler[3]) {
			int v =12;
			zielfeld[v]=figur;
			v++;
		}
			
	}
	
	public Spieler spielerZurFigur(Spielfigur figur) {						// Finde den Spieler zur Spielfigur
		for (int i=0; i<this.spieler.length; i++) {
			Spieler curSpieler = this.spieler[i];
			for (int j=0; j<curSpieler.getFiguren().length; j++) {
				Spielfigur aktFigur=curSpieler.getFiguren()[j];
				if (aktFigur==figur) {
					return curSpieler;
				}
			}
		}
		return null;
	}
	
	public boolean sieg() {													// Abfrage Spielsieg!
		boolean sieg = false;
		if (zielfeld[0]!=null && zielfeld[1]!=null && zielfeld[2]!=null && zielfeld[3]!=null) {
			sieg=true;
			System.out.println("Glückwunsch" +spieler[00].getName()+", Sie haben das Spiel gewonnen!");
		}
		if (zielfeld[4]!=null && zielfeld[5]!=null && zielfeld[6]!=null && zielfeld[7]!=null) {
			sieg=true;
			System.out.println("Glückwunsch" +spieler[01].getName()+", Sie haben das Spiel gewonnen!");
		}
		if (zielfeld[8]!=null && zielfeld[9]!=null && zielfeld[10]!=null && zielfeld[11]!=null) {
			sieg=true;
			System.out.println("Glückwunsch" +spieler[02].getName()+", Sie haben das Spiel gewonnen!");
		}
		if (zielfeld[12]!=null && zielfeld[13]!=null && zielfeld[14]!=null && zielfeld[15]!=null) {
			sieg=true;
			System.out.println("Glückwunsch" +spieler[03].getName()+", Sie haben das Spiel gewonnen!");
		}
		return sieg;
	}
	
	public Spielfigur spielfigurselect(String name) {
		Spielfigur fig=null;
		for (int z=0; z<16; z++) {
			if(startfeld[z].getFarbe()==name) {
				fig = startfeld[z];
			}
		}
		for (int z=0; z<20; z++) {
			if(feld[z].getFarbe()==name) {
				fig = feld[z];
			}
		}
		if (fig==null) {
			System.out.println("Die Figur ist nicht auswählbar");
		}
		return fig;
	}
	
}


