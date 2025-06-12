package examenherencias.tercero.clases;

public abstract class Pieza implements Comparable<Pieza> {

	private enum Tipo {BLANCO, NEGRO, GRIS};
	private Tipo color;
	private char posicionX;
	private int posicionY;
	
	public Pieza (String color, char posicionX, int posicionY) {
		
		if (color != null && !color.isBlank()) {
			switch (color) {
			case "BLANCO" -> this.color = Tipo.BLANCO;
			case "NEGRO" -> this.color = Tipo.NEGRO;
			case "GRIS" -> this.color = Tipo.GRIS;
			}
		}
								
		if (String.valueOf(posicionX) != null && !String.valueOf(posicionX).isBlank()) {
			this.posicionX = posicionX;
		}
		
		if (posicionY > 0) {
			this.posicionY = posicionY;
		}
	}
	
	public String getColor () {
		return String.valueOf(this.color);
	}
	
	public char getPosicionX () {
		return this.posicionX;
	}
	
	public int getPosicionY () {
		return this.posicionY;
	}
	
	public int cambioChar (char posX, int posY) {
		int x = 0;
		
		x = (int)(posX - 65);
		
		return x;
	}
	
	@Override
	public abstract boolean equals(Object obj);
		
	@Override
	public String toString () {
		return "";
	}
	
	@Override
	public int compareTo(Pieza o) {
		int posicion = 0;
		
		if (this.posicionY != o.posicionY) {
			posicion = this.posicionY - o.posicionY;
		} else {
			posicion = String.valueOf(this.posicionX).compareTo(String.valueOf(o.posicionX));
		}
		return posicion;
	}
}
