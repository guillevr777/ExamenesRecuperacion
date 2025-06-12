package examenherencias.tercero.clases;

public class Go extends Pieza {

	public Go (String color, char posicionX, int posicionY) {
		super(color, posicionX, posicionY);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		if (obj instanceof Go p) {
			if (String.valueOf(this.getPosicionX()).equals(String.valueOf(p.getPosicionX())) && this.getPosicionY() == p.getPosicionY()) {
				iguales = true;
			}
		}
		
		return iguales;
	}
	
	@Override
	public String toString () {
		return "G: " + String.valueOf(this.getColor()) + " " + "(" + this.getPosicionY() + ", " + this.getPosicionX() + ")";
	}
}
