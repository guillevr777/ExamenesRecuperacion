package examenesstrings.primero;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		Jugador jugador = new Jugador ();
		
		
		int opc = 0;
		char letra;
		String palabra;
		
		jugador.generaPalabra();
				
		do {
			
			jugador.pintaPista();
			
			do {
			try {
			opc = jugador.menu();
			assert (opc >= 1 && opc <= 2) : "El valor debe ser 1 o 2";
			} catch (AssertionError e) {
				System.out.println(e);
			}
			} while (opc < 1 && opc > 2);
			
			switch (opc) {
			case 1 -> {
				System.out.println("Dime la letra a comprobar:"); 
				letra = reader.next().charAt(0);
				jugador.compruebaLetra(letra);
			}
			case 2 -> {
				System.out.println("Dime la palabra a comprobar:");
				palabra = reader.nextLine();
				jugador.compruebaPalabra(palabra);
			}
			default -> {
				System.out.println("Opcion incorrecta!");
			}
			}
			
		} while (jugador.NUMINTENTOS > 0 && !jugador.palabraPista.equalsIgnoreCase(jugador.palabraSecreta));
		
		if (jugador.NUMINTENTOS > 0) {
			System.out.println("Acertaste la palabra!");
		} else {
			System.out.println("Perdiste el juego...");
		}
	}
}
