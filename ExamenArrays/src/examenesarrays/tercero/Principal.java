package examenesarrays.tercero;

import java.util.Scanner;

public class Principal {
	public static void main (String[]args) {
		
		Scanner reader = new Scanner(System.in);
		char jugador;
		boolean acierto;
		int i = 0;
		int j = 0;
		
		System.out.print("Bienvenido al 3 en rayas");
		do {
		jugador = TresEnRaya.jugadorInicial() == 0 ? 'X' : 'O';
		System.out.println("'X' para Maquina y 'O' para Jugador");
		System.out.println("Empieza a jugar " + jugador);
		TresEnRaya.limpiarTablero();
		TresEnRaya.imprimeTablero();
		
		do {
			
			if (jugador == 'X') {
				System.out.println("Turno de la Maquina");
				TresEnRaya.mueveFichaAleatoria();
			} else {
				System.out.println("Turno del Jugador");
				
				do {
					
					System.out.println("Dime a que posicion quieres mover la ficha:");
					i = reader.nextInt();
					j = reader.nextInt();
					acierto = TresEnRaya.usuarioMueveFicha(i,  j);
					if (!acierto) {
						System.out.println("Posicion no valida!");
					}
				} while (!acierto);
			}
			
			if (!TresEnRaya.esGanador(jugador)) {
				jugador = jugador == 'O' ? 'X' : 'O';
			}
			
			TresEnRaya.imprimeTablero();
			
		} while (!TresEnRaya.esGanador(jugador) && TresEnRaya.incompleto());
		
		if (TresEnRaya.esGanador(jugador)) {
		System.out.println("Ha ganado " + jugador);
		} else {
			System.out.println("Fue empeate");
		}
		
		System.out.println("Quieres volver a jugar? S/N");
		
	} while (reader.next().toUpperCase().charAt(0) == 'S');
		
		reader.close();
	} 
}
