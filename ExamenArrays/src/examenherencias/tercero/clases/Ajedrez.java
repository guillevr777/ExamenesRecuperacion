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
	public abstract boolean moverse();
	
	@Override
	public String toString () {
		return "A: " + this.nombre + " " + String.valueOf(this.getColor()) + " ";
	}
}