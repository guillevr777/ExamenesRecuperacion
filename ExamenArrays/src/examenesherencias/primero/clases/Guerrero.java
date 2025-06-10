package examenesherencias.primero.clases;

import examenesherencias.primero.excepciones.ManaException;
import examenesherencias.primero.excepciones.VidaException;
import examenesherencias.primero.interfaces.Atacar;
import examenesherencias.primero.interfaces.Defender;

public class Guerrero extends Personaje implements Atacar, Defender{

	public Guerrero (String nombre, int puntosVida, int puntosMana) throws VidaException, ManaException {
		super(nombre, puntosMana, puntosMana);
	}

	@Override
	public void defender(Personaje aliado) {
		
		aliado.activaEscudo();
	}

	@Override
	public void atacar(Personaje enemigo) {
		
		int puntos = (int)(this.puntosMana * 0.05);
		
		if (this.puntosMana >= puntos) {
			enemigo.recibirDaño(puntos);
			this.puntosMana -= puntos;
		}
	}
	
	@Override
 	public String toString() {
		return "Guerrero - " + super.toString();
	}
}
