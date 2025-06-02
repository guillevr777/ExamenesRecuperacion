package examenesarrays.segundo;

import java.util.Random;

import javax.swing.text.TableView.TableRow;

public class BusquedaDelTesoro {
	
	public static Random random = new Random();
	public static char tablero[][];
	public static int posJ;
	public static int posI;

	public static void inicializaTablero(int numFilas, int numColumnas) {
		tablero = new char[numFilas][numColumnas];
		
		for (int i = 0 ; i < numFilas ; i++) {
			for (int j = 0 ; j < numColumnas ; j++) {
				tablero[i][j] = ' ';
			}
		}
	}
	public static void generaPosicionTesoro() {
		int valorI;
		int valorJ;
		boolean tesoro = false;
		
		do {
			valorI = random.nextInt(0,tablero.length);
			valorJ = random.nextInt(0,tablero[0].length);
			if (tablero[valorI][valorJ] == ' ') {
				tablero[valorI][valorJ] = 'X';
				tesoro = true;
			}
		} while (!tesoro);
	}
	public static void pintaTablero() {
		
		int numero = 1;
		
		System.out.print("\t");
		for (int i = 0 ; i < tablero.length ; i++) {
			System.out.print("\t" + numero);
			numero++;
		}
		
		numero = 1;
		System.out.println();
		
		for (int i = 0 ; i < tablero.length ; i++) {
			System.out.print("\t" + numero);
			numero++;
			for (int j = 0 ; j < tablero[i].length ; j++) {
				if (tablero[i][j] == 'X') {
					System.out.print("\t" + ' ');
				} else if (posI == i && posJ == j) {
					System.out.print("\t" + 'J');
				} else {
					System.out.print("\t" + tablero[i][j]);
				}
			}
			System.out.println();
		}
	}
	public static void generaPosicionJugador() {
		Random random = new Random();
		int valorI;
		int valorJ;
		boolean jugador = false;
		
		do {
			valorI = random.nextInt(0,tablero.length);
			valorJ = random.nextInt(0,tablero[0].length);
			if (tablero[valorI][valorJ] == ' ') {
				posI = valorI;
				posJ = valorJ;
				jugador = true;
			}
		} while (!jugador);
	}
	public static int mueveJugador(String movimiento) {
		int correcto = 0;
		
		switch (movimiento) {
		case "DERECHA" -> {
			if (posJ+1 < tablero[0].length && tablero[posI][posJ+1] != '*') {
				posJ++;
			} else {
				correcto = -1;
			}		
		}
		case "IZQUIERDA" -> {
			if (posJ-1 < tablero[0].length && tablero[posI][posJ-1] != '*') {
				posJ--;
			} else {
				correcto = -1;
			}	
		}
		case "ARRIBA" -> {
			if (posI-1 < tablero.length && tablero[posI-1][posJ] != '*') {
				posI--;
			} else {
				correcto = -1;
			}	
		}
		case "ABAJO" -> {
			if (posI+1 < tablero.length && tablero[posI+1][posJ] != '*') {
				posI++;
			} else {
				correcto = -1;
			}
		}
		default -> {
			correcto = -2;
		}
		}
		
		return correcto;
	}
	public static void generaObstaculos(int numObstaculos) {
		
		int contador = 0;
		int posJ;
		int posI;
		
		while (contador != numObstaculos) {
			
			posJ = random.nextInt(0,tablero[0].length);
			posI = random.nextInt(0,tablero.length);
			
			if (tablero[posJ][posI] == ' ' && !obstaculoDiagonal(posJ, posI)) {
				tablero[posI][posJ] = '*';
				contador++;
			}
		}
	}
	public static boolean obstaculoDiagonal (int posJ, int posI) {
		boolean acierto = false;
		int i = posI - 1 > 0 ? posI - 1 : posI + 1;
		int j = 0;
		
		while (i < tablero.length && i <= posI + 1 && !acierto) {
			j = posJ -1 > 0 ? posJ -1 : posJ + 1;
			while (j < tablero[0].length && j <= posJ + 1 && !acierto) {
				if (tablero[i][j] == '*') {
					acierto = true;
				}
				
				j+=2;
			}
			i+=2;
		}
		
		return acierto;
	}
}
