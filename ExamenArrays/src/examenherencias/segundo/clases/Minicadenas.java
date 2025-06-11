package examenherencias.segundo.clases;

import examenherencias.segundo.excepciones.NegativeVolumeException;
import examenherencias.segundo.interfaces.Volumen;

public class Minicadenas extends Mando implements Volumen {

	private int volumen;

	public Minicadenas(String modelo, double anchura, double altura, double precio) {
		super(modelo, anchura, altura, precio);
	}

	public int getVolumen() {
		return this.volumen;
	}

	@Override
	public void subirVolumen() {
		this.volumen += 10;
	}

	@Override
	public void bajarVolumen() throws NegativeVolumeException {
		if (this.volumen >= 10) {
			this.volumen -= 10;
		} else {
			throw new NegativeVolumeException();
		}
	}

	@Override
	public String toString() {
		return "Mando para: Minicadenas - " + super.toString();
	}
}
