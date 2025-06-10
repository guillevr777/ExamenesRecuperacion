package examenesherencias.primero.excepciones;

public class VidaException extends Exception {

	@Override
	public String toString () {
		return "La vida no puede ser inferior a 0";
	}
}
