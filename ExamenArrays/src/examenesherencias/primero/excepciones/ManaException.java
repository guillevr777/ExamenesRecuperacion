package examenesherencias.primero.excepciones;

public class ManaException extends Exception {

	@Override
	public String toString () {
		return "El mana no puede ser inferior a 0";
	}
}
