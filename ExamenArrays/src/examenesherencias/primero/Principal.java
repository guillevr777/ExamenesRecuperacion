package examenesherencias.primero;

import examenesherencias.primero.clases.Personaje;

import java.util.ArrayList;
import java.util.List;

import examenesherencias.primero.clases.Guerrero;
import examenesherencias.primero.clases.Mago;
import examenesherencias.primero.clases.Picaro;
import examenesherencias.primero.excepciones.ManaException;
import examenesherencias.primero.excepciones.VidaException;

public class Principal {

	public static void main(String[] args) throws VidaException, ManaException {
		
		List<Personaje> lista = new ArrayList<Personaje>();

		Guerrero p1 = new Guerrero ("Guillermo", 140, 120);
		Mago p2 = new Mago ("Elena", 130, 100);
		Picaro p3 = new Picaro ("Alba", 100, 180);
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		for (Personaje per : lista) {
			System.out.println(per);
			
			System.out.println("---------------------");
		}
	}
}
