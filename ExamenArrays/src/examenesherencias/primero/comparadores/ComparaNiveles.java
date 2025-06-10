package examenesherencias.primero.comparadores;

import java.util.Comparator;

import examenesherencias.primero.clases.Personaje;

public class ComparaNiveles implements Comparator<Personaje> {

	@Override
	public int compare(Personaje o1, Personaje o2) {
		return o1.getNivel() - o2.getNivel();
	}
}
