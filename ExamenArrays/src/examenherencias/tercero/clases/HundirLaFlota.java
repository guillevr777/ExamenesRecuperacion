package examenherencias.tercero.clases;

public class HundirLaFlota extends Pieza {

	private enum Tipo {DERECHA, IZQUIERDA, ARRIBA, ABAJO};
	private Tipo direccion;
	private int tamaño;
	
	public HundirLaFlota (String color, char posicionX, int posicionY, String direccion, int tamaño) {
		super(color, posicionX, posicionY);
		
		if (direccion != null && !direccion.isBlank()) {
			switch (direccion) {
			case "ARRIBA" -> this.direccion = Tipo.ARRIBA;
			case "ABAJO" -> this.direccion = Tipo.ABAJO;
			case "IZQUIERDA" -> this.direccion = Tipo.IZQUIERDA;
			case "DERECHA" -> this.direccion = Tipo.DERECHA;
			}
		}
		
		if (tamaño > 0) {
			this.tamaño = tamaño;
		}
	}
	
	public String getDireccion () {
		return String.valueOf(this.direccion);
	}
	
	public int getTamaño () {
		return this.tamaño;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
		if (obj instanceof HundirLaFlota p) {
			if (String.valueOf(this.getPosicionX()).equals(String.valueOf(p.getPosicionX())) && this.getPosicionY() == p.getPosicionY()) {
				iguales = true;
			}
		}
		
		return iguales;
	}
	
	@Override
	public String toString () {
		return "HF: " + String.valueOf(this.getColor()) + " " + "(" + this.getPosicionY() + ", " + this.getPosicionX() + ")";
	}
 }
