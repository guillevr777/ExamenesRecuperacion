
public class ClasePaEliminar {

	static char tablero[][];

	public static void inicializaTablero(int filas, int columnas) {

		tablero = new char[filas][columnas];

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = '-';
			}
		}
	}

	public static void imprimeTablero() {

		for (int i = 0; i < tablero.length; i++) {
			System.out.print("\t" + (i + 1));
		}

		System.out.println();

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print("\t" + tablero[i][j]);
			}
			System.out.println();
		}
	}

	public static int insertarFicha(int columna, char ficha) {
		int posI = -1;
		int i = tablero.length - 1;

		if(columna >= 0 && columna < tablero[0].length) {
			while (i >= 0 && posI == -1) {
				if (tablero[i][columna] == '-') {
					tablero[i][columna] = ficha;
					posI = i;
				}
				i--;
			}
		}
		return posI;
	}

	public static boolean comprobarGanador(char ficha, int fila, int columna) {
		boolean acierto = false;

		int i = (fila + 3);
		int j = columna;
		int contadorF = 0;
		int contadorC = 0;
		int contadorD = 0;

		while (i >= fila && !acierto) {
			
			if (i >= 0 && i < tablero.length) {
				if (tablero[i][columna] != ficha) {
					contadorF = 0;
				} else {
					contadorF++;
					if (contadorF == 4) {
						acierto = true;
					}
				}
			}
			
			i--;
		}

		j = columna + 3;

		while (j >= (columna - 3) && !acierto) {
			
			if (j >= 0 && j < tablero[0].length) {
				if (tablero[fila][j] != ficha) {
					contadorC = 0;
				} else {
					contadorC++;
					if (contadorC == 4) {
						acierto = true;
					}
				}
			}
			
			j--;
		}
		
		i = fila + 3;
		j = columna + 3;
		
		while (i > (fila - 3) && !acierto) {
			while (j > (columna - 3) && !acierto) {
				if (j > 0 && j < tablero[0].length && i > 0 && i < tablero.length) {
					if (tablero[i][j] != ficha) {
						contadorD = 0;
					} else {
						contadorD++;
						if (contadorD == 4) {
							acierto = true;
						}
					}
				}
				j--;
			}
			
			i--;
		}

		return acierto;
	}

	public static boolean tableroLleno() {
		boolean acierto = true;

		int i = 0;
		int j = 0;
		int contador = 0;

		while (i < tablero.length && acierto) {
			while (j < tablero[i].length && acierto) {
				if (tablero[i][j] == '-') {
					acierto = false;
				}
				j++;
			}

			i++;
		}

		return acierto;
	}
}
