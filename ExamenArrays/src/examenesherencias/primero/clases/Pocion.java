package examenesherencias.primero.clases;

public class Pocion {

	private enum Tipo {VIDA, MANA};
	private Tipo tipoPocion;
	private int cantidad;
	
	public Pocion (String tipo, int cantidad) {
		
		if (tipo != null && !tipo.isBlank()) {
			switch (tipo) {
			case "MANA" -> this.tipoPocion = Tipo.MANA;
			default -> this.tipoPocion = Tipo.VIDA;		
			}
		}
		
		if (cantidad > 0) {
			this.cantidad = cantidad;
		}
	}
	
	public int getCantidad () {
		return this.cantidad;
	}
	
	public String getTipoPocion () {
		return String.valueOf(tipoPocion);
	}
	
	@Override
 	public String toString() {
		return "Tipo: " + this.tipoPocion + " Cantidad: " + this.cantidad;
	}
}
