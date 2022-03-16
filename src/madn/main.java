package madn;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Begruessung und Anzahl der Spieler waehlen
		System.out.println("Herzlich Willkommen bei >Informatiker*in ärgere dich nicht<!");
		System.out.println("Bitte die Anzahl der Spieler*innen eingeben: ");
		Scanner sc = new Scanner(System.in);
		int anzSpieler = Integer.parseInt(sc.nextLine());
	
		//DAU 2-4 Spieler
		while((anzSpieler < 2)||(anzSpieler>4)) {
			System.out.println("Mensch ärgere dich nicht ist ein Spiel für 2-4 Spieler.");
			System.out.println("Bitte die Anzahl der Spieler*innen eingeben: ");
			anzSpieler = Integer.parseInt(sc.nextLine());
		}
		
	
		//Spieler erstellen, Farben zuweisen, Spielfiguren erstellen und positionieren
		//Dummie name
		String name = "Max Muster";
		for(int i = 0; i < anzSpieler; i++) {
			System.out.println("Bitte den Namen der " + (i+1) + ". Person eingeben: ");
			name = sc.nextLine();
			//Dummie farbe
			String farbe = "bleu";
			
			//Spieler 1, Spielfiguren setzen, Namen zuweisen
			if(i == 0) {
				farbe = "blau";
				Spieler sp1 = new Spieler(name);
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				Spielfigur BlauA = new Spielfigur("blauA", 1);
				Spielfigur BlauB = new Spielfigur("blauB", 2);
				Spielfigur BlauC = new Spielfigur("blauC", 3);
				Spielfigur BlauD = new Spielfigur("blauD", 4);
			}
			
			//Spieler 2, Spielfiguren setzen, Namen zuweisen
			if(i == 1) {
				farbe = "gelb";
				Spieler sp2 = new Spieler(name);
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				Spielfigur GelbA = new Spielfigur("gelbA", 5);
				Spielfigur GelbB = new Spielfigur("gelbB", 6);
				Spielfigur GelbC = new Spielfigur("gelbC", 7);
				Spielfigur GelbD = new Spielfigur("gelbD", 8);
			}
			
			//Spieler 3, Spielfiguren setzen, Namen zuweisen
			if(i == 2) {
				farbe = "rot";
				Spieler sp3 = new Spieler(name);
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				Spielfigur RotA = new Spielfigur("gelbA", 9);
				Spielfigur RotB = new Spielfigur("gelbB", 10);
				Spielfigur RotC = new Spielfigur("gelbC", 11);
				Spielfigur RotD = new Spielfigur("gelbD", 12);			
			}
			
			//Spieler 4, Spielfiguren setzen, Namen zuweisen
			if(i == 3) {
				farbe = "grün";
				Spieler sp4 = new Spieler(name);
				System.out.println("Hallo " + name + "! Deine Spielfiguren haben die Farbe " + farbe);
				Spielfigur GruenA = new Spielfigur("grünA", 13);
				Spielfigur GruenB = new Spielfigur("grünB", 14);
				Spielfigur GruenC = new Spielfigur("grünC", 15);
				Spielfigur GruenD = new Spielfigur("grünD", 16);
			}
			
		}
		
		
		Spielfeld meinSpielfeld = new Spielfeld();
		
		boolean finished = false;
		
		while(finished != true) {
			
			
			
			finished = true;
		}
		sc.close();
	}

}
