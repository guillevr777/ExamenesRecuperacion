package examenherencias.tercero.clases;

import examenherencias.tercero.interfaces.Movimiento;

public class Damas extends Pieza implements Movimiento{

	public Damas(String color, char posicionX, int posicionY) {
		super(color, posicionX, posicionY);
	}

	@Override
	public boolean moverse() {
		boolean acierto = false;
		
		return acierto;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		if (obj instanceof Damas p) {
			if (String.valueOf(this.getPosicionX()).equals(String.valueOf(p.getPosicionX())) && this.getPosicionY() == p.getPosicionY()) {
				iguales = true;
			}
		}
		
		return iguales;
	}
	
	@Override
	public String toString () {
		return "D: " + String.valueOf(this.getColor()) + " " + "(" + this.getPosicionY() + ", " + this.getPosicionX() + ")";
	}
}
