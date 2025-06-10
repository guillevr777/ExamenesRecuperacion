package examenherencias.segundo.excepciones;

public class NegativeVolumeException extends Exception {

	@Override
	public String getMessage () {
		return "No se puede bajar el volumen por debajo de 0";
	}
 }
