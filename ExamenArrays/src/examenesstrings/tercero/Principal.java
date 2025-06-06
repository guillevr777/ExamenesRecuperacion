package examenesstrings.tercero;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		Jugador jugador = new Jugador();
		char letra;
		int numero;
		
		jugador.desordenaAbecedario();
		jugador.eligeFrase();
		jugador.codificaFrase();
		
		do {
			System.out.println(jugador.fraseReal);
			System.out.println(jugador.fraseCodificada);
			
			for (int i = 0 ; i < jugador.abecedario.length ; i++) {
				for (int j = 0 ; j < jugador.abecedario[i].length ; j++) {
					
					System.out.print(jugador.abecedario[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println("Dime un numero y una letra:");
			numero = reader.nextInt();
			reader.nextLine();
			letra = reader.nextLine().charAt(0);
			
			if (jugador.compruebaCodigo(numero, letra)) {
				System.out.println("hacertaste");
			}
			
		} while (!jugador.sonIguales());
		
		System.out.println(jugador.fraseReal);

		System.out.println("Ganaste!");
	}
}
