package examenesarrays.cuarto;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		Random random = new Random();
		int filas = 0;
		int columnas = 0;
		char ficha;
		
		System.out.println("Bienvenido al Conecta4");
		
		do {
		try {
		System.out.println("Dime las dimenciones del tablero:");
		filas = reader.nextInt();
		columnas = reader.nextInt();
		reader.nextLine();
		assert (filas > 3 || columnas > 3) : "No puede ser inferior a 4 filas y 4 columnas";
		} catch (AssertionError e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
		} while (filas < 4 && columnas < 4);
		
		Conecta4.inicializaTablero(filas, columnas);
		ficha = random.nextInt(0,2) == 0 ? 'O' : 'X';
				
		do {
			
			System.out.println("Turno de los/as " + ficha);
			Conecta4.imprimeTablero();
			System.out.println("Dime la columna en la que quieres poner la ficha :");
			columnas = reader.nextInt();
			reader.nextLine();
			
			if (Conecta4.insertarFicha(columnas, ficha)) {
				if (!Conecta4.comprobarGanador(ficha)) {
					ficha = ficha == 'O' ? 'X' : 'O';
				}
			} else {
				System.out.println("Hubo un error en el movimiento...");
			}
			
			
			
		} while (!Conecta4.comprobarGanador(ficha) && Conecta4.tableroVacio());
		
		Conecta4.imprimeTablero();
		if (Conecta4.comprobarGanador(ficha)) {
			System.out.println("Ha ganado el jugador " + ficha + "!");
		} else {
			System.out.println("Fue un empate...");
		}
		
		reader.close();
	}
}
