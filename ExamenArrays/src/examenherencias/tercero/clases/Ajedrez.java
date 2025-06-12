package examenherencias.tercero.clases;

import examenherencias.tercero.interfaces.Movimiento;

public abstract class Ajedrez extends Pieza implements Movimiento {

	private String nombre;
	
	public Ajedrez(String color, char posicionX, int posicionY, String nombre) {
		super(color, posicionX, posicionY);
		this.nombre = nombre;
	}
	
	public String getNombre () {
		return this.nombre;
	}
	
	@Override
	public abstract void moverse();
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		if (obj instanceof Ajedrez p) {
			if (String.valueOf(this.getPosicionX()).equals(String.valueOf(p.getPosicionX())) && this.getPosicionY() == p.getPosicionY()) {
				iguales = true;
			}
		}
		
		return iguales;
	}
	
	@Override
	public String toString () {
		return "A: " + this.nombre + " " + String.valueOf(this.getColor()) + " ";
	}
}
