package examenesstrings.segundo;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		Jugador jugador = new Jugador ();
		String palabra = "";
		int contador = jugador.NUMINTENTOS;
		
		jugador.seleccionaJuego();
		System.out.println("palabraInicio: " + jugador.palabraInicio + " - palabraObjetivo: " + jugador.palabraObjetivo);
		
		do {			
		do {
		try {
		System.out.println("Dime una palabra a probar:");
		palabra = reader.nextLine();
		assert (palabra.length() == 4) : "La cadena tiene que tener una longitud de 4 caracteres variando solo 1 con la palabra anterior.";
		} catch (AssertionError e) {
			System.out.println(e);
		}
		} while (palabra.length() != 4);		
		
		if (!jugador.compruebaIntento(palabra)) {
			System.out.println("Cometiste un error o cambiaste mas de 1 letra simultanea en el mismo turno.");
		} else {
			contador--;
		}
		
		System.out.println("Jugada: " + jugador.jugada);

		} while (contador > 0 && !jugador.ultimoIntento().equalsIgnoreCase(jugador.palabraObjetivo));
		
		if (contador > 0) {
			System.out.println("Ganaste!");
		} else {
			System.out.println("Perdiste!");
		}
	}
}
