package examenesherencias.primero.clases;

import examenesherencias.primero.excepciones.ManaException;
import examenesherencias.primero.excepciones.VidaException;
import examenesherencias.primero.interfaces.Atacar;

public class Picaro extends Personaje implements Atacar {

	public Picaro (String nombre, int puntosVida, int puntosMana) throws VidaException, ManaException {
		super(nombre, puntosMana, puntosMana);
	}
	
	@Override
	public void atacar(Personaje enemigo) {

		int puntos = (int)(this.puntosMana * 0.1);
		
		if (enemigo.recibirDaño(puntos)) {
			this.puntosMana -= puntos;
		}
	}
	
	@Override
 	public String toString() {
		return "Picaro - " + super.toString();
	}
}
