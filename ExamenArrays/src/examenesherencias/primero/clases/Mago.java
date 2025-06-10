package examenesherencias.primero.clases;

import examenesherencias.primero.excepciones.ManaException;
import examenesherencias.primero.excepciones.VidaException;
import examenesherencias.primero.interfaces.Atacar;
import examenesherencias.primero.interfaces.Curar;

public class Mago extends Personaje implements Atacar, Curar {

	public Mago (String nombre, int puntosVida, int puntosMana) throws VidaException, ManaException {
		super(nombre, puntosVida, puntosMana);
	}

	@Override
	public void curar (Personaje aliado) {

		int curacion = this.puntosMana * 8;
		aliado.recuperarVida(curacion);
	}

	@Override
	public void atacar(Personaje enemigo) {

		int puntos = (int)(this.puntosMana * 0.25);
		
		if (enemigo.recibirDaño(puntos)) {
			this.puntosMana -= puntos;
		}
	}
	
	@Override
 	public String toString() {
		return "Mago - " + super.toString();
	}
}
