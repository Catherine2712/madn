package madn;

public class Spieler {
		//Attribute
		private String name;
		private Spielfigur[] figuren = new Spielfigur[4];
		//Konstruktor
		public Spieler (String name, String farbe) {
			this.name = name;
			for(int i = 0; i < figuren.length; i++) {
				figuren[i] = new Spielfigur(farbe, i);
			}
		}
		//Methoden
		
	public Spielfigur[] getFiguren() {
		return this.figuren;

	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	
}
