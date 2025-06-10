package examenherencias.segundo.interfaces;

import examenherencias.segundo.excepciones.NegativeVolumeException;

public interface Volumen {

	public void subirVolumen ();
	public void bajarVolumen () throws NegativeVolumeException;

}
