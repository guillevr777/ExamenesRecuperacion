package examenes.segundo;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int numObstaculos;
		int filas = 0;
		int columnas = 0;
		String movimiento;
		int resultado;
		
		System.out.println("Bienvenido al juego de la busqueda del tesoro!");
		do {
		try {
		System.out.println("Dime cuantas filas y columnas va a tener tu mapa :");
		filas = reader.nextInt();
		columnas = reader.nextInt();
		reader.nextLine();
			assert filas >= 2 && columnas >= 2 : "No se admiten tableros tan pequeños.";
		} catch (AssertionError e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
		} while (filas < 2 && columnas < 2);
		
		numObstaculos = (int) Math.sqrt(filas*columnas/2);
		
		BusquedaDelTesoro.inicializaTablero(filas, columnas);
		BusquedaDelTesoro.generaPosicionJugador();
		BusquedaDelTesoro.pintaTablero();
		BusquedaDelTesoro.generaObstaculos(numObstaculos);
		BusquedaDelTesoro.generaPosicionTesoro();
		BusquedaDelTesoro.pintaTablero();
		
		do {
			
			System.out.println("Dime a que direccion quieres tirar:");
			movimiento = reader.nextLine().toUpperCase();
			resultado = BusquedaDelTesoro.mueveJugador(movimiento);
			if (resultado != 0) {
				System.out.println("Fue mal");
			} else {
				System.out.println("Fue bien!");
			}
			
			BusquedaDelTesoro.pintaTablero();
		} while (BusquedaDelTesoro.tablero[BusquedaDelTesoro.posI][BusquedaDelTesoro.posJ] != 'X');
		System.out.println("Has ganado encontraste el tesoro!");
	}
}
