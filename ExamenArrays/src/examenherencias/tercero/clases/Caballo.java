package examenherencias.tercero.clases;

public class Caballo extends Ajedrez{

	public Caballo(String color, char posicionX, int posicionY, String nombre) {
		super(color, posicionX, posicionY, nombre);
	}

	@Override
	public void moverse() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		if (obj instanceof Caballo p) {
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
