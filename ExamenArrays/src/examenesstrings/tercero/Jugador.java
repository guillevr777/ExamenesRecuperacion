package examenesstrings.tercero;

import java.util.Random;

public class Jugador {

	char abecedario[][] = {{'a','b','c','d','e','f','g','h','i'},{'j','k','l','m','n','ñ','o','p','q'},{'r','s','t','u','v','w','x','y','z'}};
	String frases[] = {"ae","las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos","aprende a vivir y sabras morir bien","cada dia sabemos mas y entendemos menos","el dinero no puede comprar la vida","la verdadera sabiduria esta en reconocer la propia ignorancia"};
	String fraseReal = "";
	String fraseCodificada = "";
	
	public void desordenaAbecedario () {
		Random random = new Random ();
		int fila;
		int columna;
		char respaldo;
		
		for (int i = 0 ; i < abecedario.length ; i++) {
			for (int j = 0 ; j < abecedario[0].length ; j++) {
				
					fila = random.nextInt(0,abecedario.length);
					columna = random.nextInt(0,abecedario[0].length);
					
					respaldo = abecedario[i][j];
					
					abecedario[i][j] = abecedario[fila][columna];
					abecedario[fila][columna] = respaldo;
					
			}
		}
	}
	public void eligeFrase () {
		Random random = new Random ();
		int i = random.nextInt(0,frases.length);
		
		fraseReal = frases[i];
	}
	public void codificaFrase () {
		int fila = 0;
		int columna = 0;
		boolean acierto = false;
		char caracter;
		
		for (int i = 0 ; i < fraseReal.length() ; i++) {
			fila = 0;
			acierto = false;
			caracter = fraseReal.charAt(i);
			
			if (caracter == ' ') {
				fraseCodificada += "  ";
			} else {
				while (fila < abecedario.length && !acierto) {
					columna = 0;
					while (columna < abecedario[fila].length && !acierto) {
						
						if (abecedario[fila][columna] == caracter) {
							fraseCodificada += fila + "" + columna + " ";
						}
						columna++;
					}
				fila++;
				}
			}
		}
	}
	public boolean compruebaCodigo (int codigo, char letra) {
		boolean exito = false;
		int fila = codigo / 10;
		int columna = codigo % 10;
		
		if (abecedario[fila][columna] == letra) {
			
			fraseCodificada = fraseCodificada.replace(fila + "" + columna, String.valueOf(letra));
			exito = true;
		}
		
		return exito;
	}
	public boolean sonIguales () {
		String intentoFrase = fraseCodificada.replace(" ", "");
		String intentoReal = fraseReal.replace(" ", "");

		boolean iguales = true;
		boolean acierto = false;
		int fila = 0;
		
		if (intentoFrase.length() == intentoReal.length()) {
			while (fila < intentoFrase.length() && !acierto) {
				if (String.valueOf(intentoFrase).charAt(fila) != ' ') {
					if (String.valueOf(intentoFrase).charAt(fila) != String.valueOf(intentoReal).charAt(fila)) {
						acierto = true;
						iguales = false;
					}
				}
				fila++;
			}
		} else {
			iguales = false;
		}
		
		return iguales;
	}
}
