package examenesherencias.primero;

import examenesherencias.primero.clases.Personaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import examenesherencias.primero.clases.Guerrero;
import examenesherencias.primero.clases.Mago;
import examenesherencias.primero.clases.Picaro;
import examenesherencias.primero.clases.Pocion;
import examenesherencias.primero.excepciones.ManaException;
import examenesherencias.primero.excepciones.VidaException;
import examenesherencias.primero.interfaces.Atacar;
import examenesherencias.primero.interfaces.Curar;
import examenesherencias.primero.interfaces.Defender;

public class Principal {

	public static void main(String[] args) throws VidaException, ManaException {
		
//		List<Personaje> lista = new ArrayList<Personaje>();
//
//		Guerrero p1 = new Guerrero ("Guillermo", 140, 120);
//		Mago p2 = new Mago ("Elena", 130, 100);
//		Picaro p3 = new Picaro ("Alba", 100, 180);
//		
//		lista.add(p1);
//		lista.add(p2);
//		lista.add(p3);
//		
//		for (Personaje per : lista) {
//			System.out.println(per);
//			
//			System.out.println("---------------------");
//		}
		
		List<Personaje> personajes = new ArrayList<Personaje>();
		try {
			Personaje per1 = new Guerrero("Minsc", 100, 20);
			Personaje per2 = new Mago("Gale", 120, 80);
			Personaje per3 = new Picaro("Imoen", 80, 60);

			Pocion p1 = new Pocion("MANA", 20);
			Pocion p2 = new Pocion("VIDA", 20);
			Pocion p3 = new Pocion("MANA", 40);
			Pocion p4 = new Pocion("VIDA", 60);
			Pocion p5 = new Pocion("MANA", 20);
			Pocion p6 = new Pocion("VIDA", 30);
			Pocion p7 = new Pocion("MANA", 80);

			per1.cogerPocion(p1);
			per2.cogerPocion(p2);
			per3.cogerPocion(p3);
			per1.cogerPocion(p4);
			per2.cogerPocion(p5);
			per3.cogerPocion(p6);

			personajes.add(per1);
			personajes.add(per2);
			personajes.add(per3);

			Collections.sort(personajes);

			for (Personaje per : personajes) {
				System.out.println(per);
				System.out.println("----------------------------------------------");
			}

			per1.setNivel(15);
			per2.setNivel(5);
			per3.setNivel(25);

			personajes.sort((pers1, pers2) -> {
				return pers2.getNivel() - pers1.getNivel();
			});

			for (Personaje per : personajes) {
				System.out.println(per);
				System.out.println("----------------------------------------------");
			}

			for (Personaje per : personajes) {
				
				System.out.println(per);
				
				per.recibirDaño(5);
				per.recuperarMana(20);
				per.cogerPocion(p7);
				per.cogerPocion(p6);
				per.cogerPocion(p5);

				per.usarPocion(p6);
				per.usarPocion(p7);

				if (per instanceof Atacar) {
					((Atacar) per).atacar(per3);
				} else if (per instanceof Defender) {
					((Defender) per).defender(per3);
				} else if (per instanceof Curar) {
					((Curar) per).curar(per3);
				}
				
				System.out.println(per);
			}
			
			
				for (Personaje per : personajes) {
				
				System.out.println(per);
			}

		} catch (VidaException e) {
			System.out.println(e.getMessage());
		} catch (ManaException e) {
			System.out.println(e.getMessage());
		}
	}
}
