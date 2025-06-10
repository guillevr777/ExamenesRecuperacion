package examenherencias.segundo.interfaces;

import examenherencias.segundo.excepciones.NegativeVelocityException;

public interface Velocidad {
	
	public void subirVelocidad ();
	public void bajarVelocidad () throws NegativeVelocityException;
	
}
