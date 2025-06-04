package examenesstrings.segundo;

import java.util.Random;

public class Jugador {

	String juegos[][] = {{"CASA","PATO"},{"PISO","TUBO"},{"CENA","MURO"},{"BONO","DEDO"},{"ROJO","PASA"}};
	
	final int NUMINTENTOS = 7;

	String palabraInicio = "";
	
	String palabraObjetivo = "";
	 
	String jugada = "";
	
	public void seleccionaJuego () {
		Random random = new Random();
		int fila = random.nextInt(0,juegos.length);
		
		palabraInicio = juegos[fila][0];
		palabraObjetivo = juegos[fila][1];
		jugada = palabraInicio;
	}
	public String ultimoIntento() {
		String palabra = jugada;
		int posicion;
		
		posicion = jugada.lastIndexOf(" ");
		
		if (posicion >= 0) {
			
 		palabra = jugada.substring(posicion + 1);
 		
		}
		
		return palabra;
	}
	public boolean compruebaIntento(String intento) {
		boolean exito = false;
		String palabra = ultimoIntento(); 
		char palabraDesglozada[] = palabra.toUpperCase().toCharArray();
		char intentoDesglozado[] = intento.toUpperCase().toCharArray();
		int contador = 0;
		
			for (int i = 0 ; i < palabra.length() ; i++) {
				if (palabraDesglozada[i] != intentoDesglozado[i]) {
					contador++;
				}
			}
			
			if (contador == 1) {
				exito = true;
				jugada += " - " + intento.toUpperCase();
			}
		
		return exito;
	}
}
