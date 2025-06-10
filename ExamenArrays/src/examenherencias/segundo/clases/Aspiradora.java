package examenherencias.segundo.clases;

import examenherencias.segundo.excepciones.NegativeVelocityException;
import examenherencias.segundo.excepciones.NegativeVolumeException;
import examenherencias.segundo.interfaces.Velocidad;

public class Aspiradora extends Mando implements Velocidad {

	private int velocidad = 0;
	
	public Aspiradora(String modelo, double anchura, double altura, double precio) {
		super(modelo, anchura, altura, precio);
	}
	
	public int getVelocidad () {
		return this.velocidad;
	}

	@Override
	public void subirVelocidad() {
		if (this.velocidad < 5) {
			this.velocidad++;
		}
	}

	@Override
	public void bajarVelocidad() throws NegativeVelocityException {
		if (this.velocidad > 0) {
			this.velocidad--;
		} else {
			throw new NegativeVelocityException();
		}
	}
	
	@Override
	public String toString () {
		return "Mando para: Aspiradoras - " + super.toString();
	}
}
