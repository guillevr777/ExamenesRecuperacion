package examenherencias.tercero.clases;

public class Alfil  extends Ajedrez{

	public Alfil (String color, char posicionX, int posicionY, String nombre) {
		super(color, posicionX, posicionY, nombre);
	}

	@Override
	public void moverse() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		if (obj instanceof Alfil p) {
			if (String.valueOf(this.getPosicionX()).equals(String.valueOf(p.getPosicionX())) && this.getPosicionY() == p.getPosicionY()) {
				iguales = true;
			}
		}
		
		return iguales;
	}

	@Override
	public String toString () {
		return "";
	}
}
