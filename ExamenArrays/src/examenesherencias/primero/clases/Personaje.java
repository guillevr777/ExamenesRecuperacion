package examenesherencias.primero.clases;

import java.util.ArrayList;
import java.util.List;

import examenesherencias.primero.excepciones.ManaException;
import examenesherencias.primero.excepciones.VidaException;

public class Personaje implements Comparable<Personaje> {

	private String nombre;
	private int nivel = 0;
	private int puntosVida;
	protected int puntosMana;
	private boolean escudo = false;
	private List<Pocion> pociones = new ArrayList<Pocion>();
 	
 	public Personaje (String nombre, int puntosVida, int puntosMana) throws ManaException, VidaException {
 		
 		if (nombre != null && !nombre.isBlank()) {
 			this.nombre = nombre;
 		}
 		
 		if (puntosVida > 0) {
 			this.puntosVida = puntosVida;
 		} else {
 			throw new VidaException();
 		}
 		
 		if (puntosMana > 0) {
 			this.puntosMana = puntosMana;
 		} else {
 			throw new ManaException();
 		}
 	} 
 	
 	public int getNivel () {
 		return this.nivel;
 	}
 	
 	public boolean recibirDaño(int daño) {
 		boolean acierto = false;
 		
 		if (this.escudo != true) {
 			
 			if (this.puntosVida > daño) {
 				this.puntosVida = this.puntosVida - daño;
 			} else {
 				this.puntosVida = 0;
 			}
 			acierto = true;
 		} else {
 			this.escudo = false;
 		}
 		return acierto;
 	}
 	
 	public void recuperarVida(int vida) {
 		this.puntosVida += vida;
 	}
 	
 	public void recuperarMana(int mana) {
 		this.puntosMana += mana;
 	}

 	public void cogerPocion(Pocion pocion) {
 		pociones.add(pocion);
 	}
 	
 	public void activaEscudo() {
		escudo = true;
	}
 	
 	public boolean usarPocion(Pocion pocion) {
 		boolean usada = false;
 		
 		if (pociones.remove(pocion)) {
 			if (pocion.getTipoPocion().equals("VIDA")) {
 				this.puntosVida += pocion.getCantidad();
 			} else {
 				this.puntosMana += pocion.getCantidad();
 			}
 			usada = true;
 		}
 		
 		return usada;
 	}
 	 	
 	@Override
 	public boolean equals(Object obj) {
 		boolean iguales = false;
 		
 		Personaje personaje = (Personaje) obj;
 		if (personaje.nombre.equals(this.nombre)) {
 			iguales = true;
 		}
 		
 		return iguales;
 	}
 	
 	@Override
	public int compareTo(Personaje obj) {
 		
 		return obj.nombre.compareTo(this.nombre);
	}
 	
 	public String stringPociones() {
 		String frase = "";
 		
 		for (Pocion poc : pociones) {
 			frase += poc + ", ";
 		}
 		
 		return frase;
 	}
 	
 	@Override
 	public String toString() {
 		String frase = "";
 		
 		frase += this.nombre + " - nivel:" + this.nivel + " - PV:" + this.puntosVida + " - PH:" + this.puntosMana + " - ";
 		
 		frase += this.escudo == true ? "Escudo Activo" : "Escudo Inactivo";
 		
 		frase += "Pociones: " + stringPociones();
 		
 		return frase;
 	}
}
