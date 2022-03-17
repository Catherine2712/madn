package madn;

public class Regelwerk {

	public static boolean zugErlaubt(Spielfeld sf, Spielfigur auswahl, int wuerfel) {
		if(rauskommenMoeglich(sf, auswahl, wuerfel) || ziehenErlaubt(sf, auswahl, wuerfel)) return true;
		return false;
	}
	
	//out of range auffangen --> auch als Abfrage, ob in den Zielbereich gelaufen wird
	public static boolean insZielLaufen(Spielfeld sf, Spielfigur auswahl, int wuerfel) {
		int idxZiel;
		if(arrayFinden(sf, auswahl)==1) {
			idxZiel=sf.sucheFeldposition(sf.getFeld(), auswahl)+wuerfel;
			if(idxZiel>=sf.getFeld().length) return true;
			else return false;
		}else return false;
	}
	
	//Wird geschlagen?
	public static boolean schlagenMoeglich(Spielfeld sf, Spielfigur auswahl, int wuerfel) {
		int idxZiel;
		idxZiel=sf.sucheFeldposition(sf.getFeld(), auswahl)+wuerfel;
		if(arrayFinden(sf, auswahl)==1) {
			if(insZielLaufen(sf, auswahl, wuerfel)) return false;												//Zug der aus dem Feld ins Zielfeld führt, Schlagen nicht moeglich
			if(!(auswahl.getFarbe().equals(sf.getFeld()[idxZiel].getFarbe()))) {
				return true;
			}else return false;
		}else return false;																									//Figur nicht im Hauptfeld
	}
	
	//Figur im Startfeld und 6 gewürfelt -->rauskommen möglich!
	public static boolean rauskommenMoeglich(Spielfeld sf, Spielfigur auswahl, int wuerfel){
		if((arrayFinden(sf, auswahl)==0 && wuerfel==6)) return true;
		System.out.println("Rausziehen nicht möglich!");
		return false;
	}
	
	//Ziehen im Hauptfeld erlaubt?
	public static boolean ziehenErlaubt(Spielfeld sf, Spielfigur auswahl, int wuerfel) {
		int idxZiel;
		idxZiel=sf.sucheFeldposition(sf.getFeld(), auswahl)+wuerfel;
		if(arrayFinden(sf, auswahl)==1) {
			if(insZielLaufen(sf, auswahl, wuerfel)) return true;												//Zug der aus dem Feld ins Zielfeld führt
			if((sf.getFeld()[idxZiel] != null)&&!(auswahl.getFarbe().equals(sf.getFeld()[idxZiel].getFarbe()))) {
				return true;
			}else return false;
		}else return false;
	}
		
	//Ziel: Array ausgeben, in welchem die zu ziehende Figur liegt: Start: 0, Haupt: 1, Ziel:2
	public static int arrayFinden(Spielfeld sf, Spielfigur auswahl) {
		if(sf.sucheFeldposition(sf.getStartfeld(), auswahl) !=-1) {
			return 0;
		}else {
			if(sf.sucheFeldposition(sf.getFeld(), auswahl)!=-1) {
				return 1;
			}else return 2;
		}
	}
	
	/* //Ziehen ins Zielfeld
	private static boolean ziehenInsZielfeldErlaubt(Spielfeld sf, Spielfigur auswahl, int wuerfel){
		if(outOfRange(sf, auswahl, wuerfel)==true) return true;
		return false;
	}
	
	
	//Index suchen und Rückgeben
	private static int indexFinden(Spielfigur[] suchFeld, Spielfigur auswahl) {
		int a=-1;
		for(int i =0; i<suchFeld.length; i++) {
			if(suchFeld[i]==auswahl) {
				a = i;
			}
		}
		return a;
	}
	*/
}
