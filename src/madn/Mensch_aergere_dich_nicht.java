package madn;
import java.util.Scanner;

public class Mensch_aergere_dich_nicht {
	
	//Attribute
	int anzSpieler;
	
	
	//Methoden
	public static int begruessen() {
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
		sc.close();
	return anzSpieler;
	}
	
	
	public static void spielfeldVorbereiten(int anzSpieler) {
		
		//Scanner
		Scanner sc = new Scanner(System.in);
				
		//Dummy Spieler
		Spieler cathy = new Spieler("Cathy", "blau");
		Spieler tobi = new Spieler("Tobi", "rot");
		Spieler hendrik = new Spieler("Hendrik", "grün");
		Spieler florian = new Spieler("Florian", "gelb");
						
		//aktives Spielfeld erzeugen
		Spielfeld meinspielfeld=new Spielfeld(cathy, tobi, hendrik, florian);
		//meinspielfeld.ausgabe();
		//meinspielfeld.wuerfeln();			
						
		//Spieler erstellen, Farben zuweisen, Spielfiguren erstellen und positionieren
		//Dummy name
		String name = "Max Muster";
		for(int i = 0; i < anzSpieler; i++) {
		System.out.println("Bitte den Namen der " + (i+1) + ". Person eingeben: ");
		name = sc.nextLine();
		
		//Dummy farbe
		String farbe = "bleu";
							
							
		//Spieler 1, Spielfiguren setzen, Namen zuweisen
		if(i == 0) {
			farbe = "blau";
			cathy.setName(name);
			System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
			/*Spielfigur BlauA = new Spielfigur("blauA");
			Spielfigur BlauB = new Spielfigur("blauB");
			Spielfigur BlauC = new Spielfigur("blauC");
			Spielfigur BlauD = new Spielfigur("blauD");*/
							
		}
							
						
		//Spieler 2, Spielfiguren setzen, Namen zuweisen
							
		if(i == 1) {					
			farbe = "gelb";				
			tobi.setName(name);
			System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);				
			/*Spielfigur GelbA = new Spielfigur("gelbA");				
			Spielfigur GelbB = new Spielfigur("gelbB");
			Spielfigur GelbC = new Spielfigur("gelbC");
			Spielfigur GelbD = new Spielfigur("gelbD");*/
		}
							
		//Spieler 3, Spielfiguren setzen, Namen zuweisen
		if(i == 2) {
		farbe = "rot";
		hendrik.setName(name);
		System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
		/*Spielfigur RotA = new Spielfigur("gelbA");
		Spielfigur RotB = new Spielfigur("gelbB");
		Spielfigur RotC = new Spielfigur("gelbC");
		Spielfigur RotD = new Spielfigur("gelbD");*/			
		}
							
		//Spieler 4, Spielfiguren setzen, Namen zuweisen
		if(i == 3) {
			farbe = "gruen";
			florian.setName(name);
			System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
			/*Spielfigur GruenA = new Spielfigur("gruenA");
			Spielfigur GruenB = new Spielfigur("gruenB");
			Spielfigur GruenC = new Spielfigur("gruenC");
			Spielfigur GruenD = new Spielfigur("gruenD");*/
							
		}
							
						
		}
						
						
						

		
		
	}
	
	
	public static void spielen() {
		
		
		
		//Abbruchbedingung anlegen
		boolean finished = false;
		
		//Zaehler fuer aktiven Spieler
		int zaehler = 0;
		int zaehlerAktiv = 0;
		
		//Eigentlicher Spielablauf
		while(finished != true) {
			
			for(int k = 0; k < 6; k++) {
				
			}
			
			finished = true;
			zaehler ++;
		}
		
	}
	
}

