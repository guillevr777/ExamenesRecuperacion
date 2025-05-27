package examenes.segundo;

import java.util.Random;

import javax.swing.text.TableView.TableRow;

public class BusquedaDelTesoro {
	
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
		Random random = new Random();
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
			if (tablero[posI][posJ+1] != '*' && posJ+1 <= tablero[0].length) {
				posJ++;
			} else if (tablero[posI][posJ+1] != ' ' && posJ+1 > tablero[0].length) {
				correcto = -1;
			} else {
				correcto = -2;
			}			
		}
		case "IZQUIERDA" -> {
			if (tablero[posI][posJ-1] != '*' && posJ-1 <= tablero[0].length) {
				posJ--;
			} else if (tablero[posI][posJ-1] != ' ' && posJ-1 > tablero[0].length) {
				correcto = -1;
			} else {
				correcto = -2;
			}	
		}
		case "ARRIBA" -> {
			if (tablero[posI-1][posJ] != '*' && posI-1 <= tablero.length) {
				posI--;
			} else if (tablero[posI-1][posJ] != ' ' && posI-1 > tablero.length) {
				correcto = -1;
			} else {
				correcto = -2;
			}	
		}
		case "ABAJO" -> {
			if (tablero[posI+1][posJ] != '*' && posI+1 <= tablero.length) {
				posI++;
			} else if (tablero[posI+1][posJ] != ' ' && posI+1 > tablero.length) {
				correcto = -1;
			} else {
				correcto = -2;
			}	
		}
		}
		
		return correcto;
	}
	public static void generaObstaculos(int numObstaculos) {
		
	}
}
