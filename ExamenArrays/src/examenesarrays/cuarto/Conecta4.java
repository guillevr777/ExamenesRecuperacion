package examenesarrays.cuarto;

public class Conecta4 {
	
	static char tablero[][];

	public static void inicializaTablero(int filas, int columnas) {
		tablero = new char[filas][columnas];
		
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero[i].length ; j++) {
				tablero[i][j] = '-';
			}
		}
	}
	public static void imprimeTablero () {
		
		for (int i = 0 ; i < tablero.length ; i++) {
			System.out.print("\t" + (i + 1));
		}
		
		System.out.println();
		
		for (int i = 0 ; i < tablero.length ; i++) {
			System.out.print(i + 1);
			for (int j = 0 ; j < tablero[i].length ; j++) {
				System.out.print("\t" + tablero[i][j]);
			}
			System.out.println("\n");
		}
	}
	public static boolean insertarFicha(int columna, char ficha) {
		boolean acierto = false;
		int contador = 0;
		
		while (!acierto && contador < 4) {
			int i = tablero.length - 1;
			while (i >= 0 && !acierto) {
				if (tablero[i][columna] == '-') {
					acierto = true;
					tablero[i][columna] = ficha;
				} else {
					contador++;
				}
				i--;
			}
		}
		
		return acierto;
	}
	public static boolean comprobarGanador(char ficha) {
		boolean acierto = false;
		
		int i = 0;
		int j = 0;
		int contadorF = 0;
		int contadorC = 0;
		int contadorD = 0;
		
		while (i < tablero.length && !acierto) {
			while (j < tablero[i].length && !acierto) {
				
				if (tablero[i][j] == ficha) {
					contadorF++;
					if (contadorF == 4) {
						acierto = true;
					}
				}
				
				if (tablero[j][i] == ficha) {
					contadorC++;
					if (contadorC == 4) {
						acierto = true;
					}
				}
				
				j++;
			}
			contadorF = 0;
			contadorC = 0;
			i++;
		}
		
		i = 0;
		
		while (i < tablero.length && !acierto) {
			if (tablero[i][i] == ficha) {
				contadorD++;  
				if (contadorD == 4) {
					acierto = true;
				}
			}
			i++;
		}
		
		i = tablero.length;
		j = 0;
		contadorD = 0;
		
		while (i > tablero.length && !acierto) {
			while (j < tablero[0].length && !acierto) {
				if (tablero[i][j] == ficha) {
					contadorD++;
					if (contadorD == 4) {
						acierto = true;
					}
				}
				j++;
			}
			i--;
		}
		
		return acierto;
	}
	public static boolean tableroVacio() {
		boolean lleno = false;
		int i = 0;
		int j = 0;
		
		while (i < tablero.length && !lleno) {
			while (j < tablero[i].length && !lleno) {
				if (tablero[i][j] == '-') {
					lleno = true;
				}
				j++;
			}
			i++;
		}
		
		return lleno;
	}
}
