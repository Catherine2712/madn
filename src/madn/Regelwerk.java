package madn;

public class Regelwerk {

	public static boolean zugErlaubt(Spielfeld sf, Spielfigur auswahl, int wuerfel) {
		if(rauskommenErlaubt(sf, auswahl, wuerfel) || ziehenErlaubt(sf, auswahl, wuerfel)) return true;
		return false;
	}
	
	
	//Figur im Startfeld und 6 gewürfelt -->rauskommen erlaubt?
	private static boolean rauskommenErlaubt(Spielfeld sf, Spielfigur auswahl, int wuerfel){
		if((arrayFinden(sf, auswahl)==0 && wuerfel==6)) {
			if(!(sf.getStartfeld()[0].getFarbe().equals(auswahl.getFarbe()))) {
				return true;
			}else return false;	
		}else return false;
	}
	
	//Ziehen im Feld erlaubt?
	private static boolean ziehenErlaubt(Spielfeld sf, Spielfigur auswahl, int wuerfel) {
		int idxZiel;
		idxZiel=sf.sucheFeldposition(sf.getFeld(), auswahl)+wuerfel;
		
		if(arrayFinden(sf, auswahl)==1) {
			if(!(auswahl.getFarbe().equals(sf.getFeld()[idxZiel].getFarbe()))) {
				return true;
			}else return false;
		}else return false;
	}
	
	/*
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
	
	//Ziel: Array ausgeben, in welchem die zu ziehende Figur liegt: Start: 0, Haupt: 1, Ziel:2
	private static int arrayFinden(Spielfeld sf, Spielfigur auswahl) {
		if(sf.sucheFeldposition(sf.getStartfeld(), auswahl) !=-1) {
			return 0;
		}else {
			if(sf.sucheFeldposition(sf.getFeld(), auswahl)!=-1) {
				return 1;
			}else return 2;
		}
	}
}
