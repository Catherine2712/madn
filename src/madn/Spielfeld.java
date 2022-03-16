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
	
	public void schlagen(Spielfigur raus, boolean zugMoeglich, Spielfigur[]sf, Spielfigur spielfigur,int p){
		if (zugMoeglich == true) {
			for (int i = 0; i < sf.length; i++) {
			if (sf[i] == spielfigur) {
				sf[i] = null;
				sf[i] = sf[p];
				spielfigur = startfeld[i];
				System.out.println("Du hast gerade " + spielfigur + "rausgeworfen.");
			}else {
				System.out.println("Fail");
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
					schlagen(feld[0]);
				}
				feld[0]=figur;
			}
		}
		if (a=false) {
		System.out.println("Die Figur befindet sich nicht im Startfeld!");
		}	
		
		return a;	
	}
}

