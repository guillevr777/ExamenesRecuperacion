package examenesarrays.tercero;

import java.util.Random;

public class TresEnRaya {

	static char tablero[][] = new char[3][3];
	
	public static void imprimeTablero () {
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero[0].length ; j++) {	
				System.out.print("\t" + tablero[i][j]);
			}
			System.out.println();
		}
	}
	public static int jugadorInicial () {
		Random random = new Random();
		int jugador;
		
		jugador = random.nextInt(0,2);
		
		return jugador;
	}
	public static void mueveFichaAleatoria () {
		Random random = new Random();
		boolean acierto = false;
		int i;
		int j;
		
		do {
			i = random.nextInt(0,3);
			j = random.nextInt(0,3);
			if (tablero[i][j] == '-') {
				tablero[i][j] = 'X';
				acierto = true;
			}
		} while (!acierto);
	}
	public static boolean usuarioMueveFicha (int i, int j) {
		boolean acierto = false;
			
		if (i >= 0 && j >= 0 && i < tablero.length && j < tablero[0].length && tablero[i][j] == '-') {
			tablero[i][j] = 'O';
			acierto = true;
		}
		
		return acierto;
	}
	public static void limpiarTablero () {
		
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero[0].length ; j++) {
				tablero[i][j] = '-';
			}
		}
	}
	public static boolean esGanador (char ficha) {
		boolean acierto = false;
		int contador;
		boolean fila;
		boolean columna;
		
		for (int i = 0 ; i < tablero.length ; i++) {
			
			fila = true;
			columna = true;
			for (int j = 0 ; j < tablero[0].length ; j++) {
				
				if (tablero[i][j] != ficha) {
					fila = false;
				}
				
				if (tablero[j][i] != ficha) {
					columna = false;
				}
			}
			if (fila == true || columna == true) {
				acierto = true;
			}
		}

		contador = 0;
		
		for (int i = 0 ; i < tablero.length ; i++) {
			if (tablero[i][i] == ficha) {
				contador++;
			}
		} 
		
		if (contador == 3) {
			acierto = true;
		}
		
		contador = 0;
		
		for (int i = tablero.length - 1 ; i >= 0 ; i--) {
			for (int j = 0 ; j < tablero[0].length ; j++) {
			if (tablero[i][j] == ficha) {
				contador++;
			}
			}
		}
		
		if (contador == 3) {
			acierto = true;
		}
		
		return acierto;
	}
	public static boolean incompleto () {
		boolean acierto = false;
		
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero[0].length ; j++) {
				
				if (tablero[i][j] == '-') {
					acierto = true;
				}
			}
		}
		return acierto;
	}
}
