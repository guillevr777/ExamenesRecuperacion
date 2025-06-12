package examenherencias.tercero.clases;

public class Torre extends Ajedrez{

	public Torre (String color, char posicionX, int posicionY, String nombre) {
		super(color, posicionX, posicionY, nombre);
	}

	@Override
	public void moverse() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		if (obj instanceof Torre p) {
			if (String.valueOf(this.getPosicionX()).equals(String.valueOf(p.getPosicionX())) && this.getPosicionY() == p.getPosicionY()) {
				iguales = true;
			}
		}
		
		return iguales;
	}

	@Override
	public String toString () {
		return super.toString() + "(" + this.getPosicionY() + ", " + this.getPosicionX() + ")";
	}
}
