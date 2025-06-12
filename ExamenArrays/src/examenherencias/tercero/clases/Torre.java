package examenherencias.tercero.clases;

public class Torre   extends Ajedrez{

	public Torre (String color, char posicionX, int posicionY, String nombre) {
		super(color, posicionX, posicionY, nombre);
	}

	@Override
	public void moverse() {
		
	}

	@Override
	public String toString () {
		return super.toString() + "(" + this.getPosicionY() + ", " + this.getPosicionX() + ")";
	}
}
