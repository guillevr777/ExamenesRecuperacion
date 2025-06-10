package examenherencias.segundo.interfaces;

import examenherencias.segundo.excepciones.NegativeVolumeException;

public interface Velocidad {
	
	public void subirVelocidad ();
	public void bajarVelocidad () throws NegativeVolumeException;
	
}
