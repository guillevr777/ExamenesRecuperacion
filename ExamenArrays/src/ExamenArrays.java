import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class ExamenArrays {

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
			
		boolean ganador = false;
		char[][] tableroPrincipal;
		char[][] tableroJ1;
		char[][] tableroJ2;
		int numBarquitos;
		boolean turnoJugadorUno = true;
		boolean repite = true;
		int contadorJugadorUno = 0;
		int contadorJugadorDos = 0;
		int fila;
		int columna;
		
		System.out.println("Bienvenido a hundir la flota\nDime cuantas filas y columnas quieres que tenga el tablero:");
		fila = reader.nextInt();
		columna = reader.nextInt();
		reader.nextLine();
		
		numBarquitos = (int) Math.sqrt(fila*columna);
		
		tableroPrincipal = creaTablero (fila, columna);
		tableroJ1 = inicializaTablero (fila, columna);
		tableroJ2 = inicializaTablero (fila, columna);
		generarBarquitos(tableroPrincipal, numBarquitos);

		do {
			
			System.out.println("Turno del Jugador " + (turnoJugadorUno ? "Jugador1" : "Jugador2"));

			if (turnoJugadorUno) {
				
				do {
					
				pintaTablero (tableroJ1);
				repite = turnoJugador(tableroPrincipal, tableroJ1);
	
				if (repite) {
					contadorJugadorUno++;
				} else {
					turnoJugadorUno = false;
				}
				
				if (contadorJugadorUno == numBarquitos) {
					ganador = true;
				}
				
				} while (repite && !ganador);
				
			} else {
				
				do {
				pintaTablero (tableroJ2);
				repite = turnoJugador(tableroPrincipal, tableroJ2);
				
				if (repite) {
					contadorJugadorUno++;
				} else {
					turnoJugadorUno = true;
				}
				
				if (contadorJugadorDos == numBarquitos) {
					ganador = true;
				}
				
				} while (repite && !ganador);
			}
			
			if (contadorJugadorUno == numBarquitos || contadorJugadorDos == numBarquitos) {
				ganador = true;
			}
			
		} while (!ganador);
		
		pintaTablero(tableroPrincipal);
		System.out.println("Gano el " + (turnoJugadorUno ? "Jugador 1" : "Jugador 2"));
	}
	public static char[][] inicializaTablero (int filas, int columnas) {
		char[][] tablero = new char[filas][columnas];
		
		for (int i = 0 ; i < filas ; i++) {
			for (int j = 0 ; j < columnas ; j++) {
				tablero[i][j] = '-';
			}
		}
		return tablero;
	}
	public static char[][] creaTablero (int filas, int columnas) {
		char tablero[][] = new char[filas][columnas];

		for (int i = 0 ; i < filas ; i++) {
			for (int j = 0 ; j < columnas ; j++) {
				tablero[i][j] = 'A';
			}
		}
		return tablero;
	}
	public static void generarBarquitos(char tablero[][], int numBarquitos) {
		Random random = new Random();
		int fila;
		int columna;
		int contador = numBarquitos;
		
		while (contador > 0) {
			fila = random.nextInt(0,tablero.length);
			columna = random.nextInt(0,tablero[0].length);
			
			if (tablero[fila][columna] != 'B') {
				tablero [fila][columna] = 'B';
				contador--;
			}
		}
	}
	public static void pintaTablero(char tableroJugador[][]) {
		int letra = 'A';
		
		System.out.print("\t");
		for (int i = 0 ; i < tableroJugador[0].length ; i++) {
			System.out.print(i + 1 + "\t");
		}
		
		System.out.println();
		
		for (int i = 0 ; i < tableroJugador.length ; i++) {
			System.out.print((char)letra + "\t");
			letra++;
			for (int j = 0 ; j < tableroJugador[i].length ; j++) {
				System.out.print(tableroJugador[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		boolean acierto = false;
		char fila;
		int columna;
		
		System.out.println("En que posicion del tablero crees que hay un barco? (Fila como letra, Columna como numero)");
		fila = reader.next().charAt(0);
		columna = reader.nextInt();
		
		if (tablero[(fila - 65)][(columna - 1)] != 'B') {
			System.out.println("AGUA");
			tableroJugador[fila - 65][(columna - 1)] = 'A';
		} else {
			System.out.println("HUNDIDO");
			tableroJugador[(fila - 65)][(columna - 1)] = 'H';
			acierto = true;
		}
		
		return acierto;
	}
}
