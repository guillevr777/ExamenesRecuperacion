package examenherencias.segundo.excepciones;

public class NegativeVelocityException extends Exception {

	@Override
	public String getMessage () {
		return "La velocidad tiene que ser superior o igual a 0";
	}
}
