package examenherencias.segundo.clases;

import examenherencias.segundo.excepciones.NegativeVolumeException;
import examenherencias.segundo.interfaces.Volumen;

public class Television extends Mando implements Volumen {
	
	private int volumen;
	private int canal;

	public Television(String modelo, double anchura, double altura, double precio) {
		super(modelo, anchura, altura, precio);
	}

	public int getVolumen() {
		return this.volumen;
	}
	
	public int getCanal() {
		return this.canal;
	}
	
	public void setCanal(int canal) {
		if (canal > 0) {
			this.canal = canal;
		}
	}
	
	@Override
	public void subirVolumen () {
		this.volumen += 5;
	}

	@Override
	public void bajarVolumen () throws NegativeVolumeException {
		if (this.volumen >= 5) {
			this.volumen -= 5;
		} else {
			throw new NegativeVolumeException();
		}
	}
	
	@Override
	public String toString () {
		return "Mando para: Televisiones - " + super.toString();
	}
}
