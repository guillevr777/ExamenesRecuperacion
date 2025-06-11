package examenherencias.segundo.clases;

public class Mando implements Comparable<Mando>{

	private String modelo;
	private double anchura;
	private double altura;
	private double precio;
	private boolean encendido = false;
	
	public Mando (String modelo, double anchura, double altura, double precio) {
		if (modelo != null && !modelo.isBlank()) {
			this.modelo = modelo;
		}
		if (anchura > 0) {
			this.anchura = anchura;
		}
		if (altura > 0) {
			this.altura = altura;
		}
		if (precio > 0) {
			this.precio = precio;
		}
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public double getAnchura() {
		return this.anchura;
	} 
	
	public double getAltura() {
		return this.altura;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public boolean isEncendido () {
		return this.encendido;
	}
	
	public void alternarEncendido() {
		this.encendido = this.encendido != true ? true : false;
	}
	
	@Override
	public boolean equals (Object obj) {
		boolean iguales = false;
		
		Mando mando = (Mando) obj;
		if (mando.modelo.equals(this.modelo)) {
			iguales = true;
		}
		
		return iguales;
	}
	
	@Override
	public int compareTo (Mando mando) {
		return this.modelo.compareTo(mando.modelo);
	}
	
	@Override
	public String toString () {
		String frase = "";
		
		frase += "Modelo: " + this.modelo + " Altura: " + this.altura + " Anchura: " + this.anchura + " Precio: " + this.precio;
		
		return frase;
	}
}
