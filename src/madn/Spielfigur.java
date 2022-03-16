package madn;


public class Spielfigur {
	
		//Attribute
		private String farbe;
		private int nummer;
		//Konstruktor
		public Spielfigur(String farbe, int nummer) {
			this.farbe = farbe;
			this.nummer = nummer;
		}
		//getter
		
		public String getFarbe() {
			return farbe;
		}
		
		public void setFarbe(String farbe) {
			this.farbe = farbe;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return farbe.substring(0, 2).toUpperCase() + this.nummer;
		}
		
		
	}
