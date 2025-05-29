import java.util.Scanner;

public class Principaleliminar {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		char jugador = 0;
		int filas = 0;
		int columnas = 0;

		System.out.println("Bienvenido al juego del calamar");

		do {
			try {
				System.out.println("Dime cuantas filas y columnas quieres que tenga tu tablero:");
				filas = reader.nextInt();
				columnas = reader.nextInt();
				reader.nextLine();
				assert (filas >= 4 || columnas >= 4) : "Deben ser mas de 4 filas y columnas";
			} catch (AssertionError e) {
				System.out.println(e);
			}
		} while (filas < 4 || columnas < 4);

		ClasePaEliminar.inicializaTablero(filas, columnas);
		ClasePaEliminar.imprimeTablero();

		do {
			jugador = jugador == 'O' ? 'X' : 'O';

			System.out.println("Dime la columna en la que insertar la ficha");
			columnas = reader.nextInt();
			reader.nextLine();
			filas = ClasePaEliminar.insertarFicha(columnas, jugador);
			ClasePaEliminar.imprimeTablero();

		} while (!ClasePaEliminar.comprobarGanador(jugador, filas, columnas) && !ClasePaEliminar.tableroLleno());
	}
}
