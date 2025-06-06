package examenesstrings.cuarto;

import java.util.Random;

public class Jugador {

	char abecedario[][] = {{'a','b','c','d','e','f','g','h','i'},{'j','k','l','m','n','ñ','o','p','q'},{'r','s','t','u','v','w','x','y','z'}};
	String frases[] = {"ae","las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos","aprende a vivir y sabras morir bien","cada dia sabemos mas y entendemos menos","el dinero no puede comprar la vida","la verdadera sabiduria esta en reconocer la propia ignorancia"};
	String fraseReal = "";
	String fraseCodificada = "";
	
	public void desordenaAbecedario () {
		Random random = new Random ();
		int i = 0;
		int j = 0;
		int fila = 0;
		int columna = 0;
		char letra;
		while (fila < abecedario.length) {
			columna = 0;
			while (columna < abecedario[fila].length) {
				
				i = random.nextInt(0, abecedario.length);
				j = random.nextInt(0, abecedario[0].length);
				
				letra = abecedario[i][j];
				
				abecedario[i][j] = abecedario[fila][columna];
				abecedario[fila][columna] = letra;
				
				columna++;
			}
			
			fila++;
		}
	}
	public void eligeFrase () {
		Random random = new Random ();
		int fila = 0;
		
		fila = random.nextInt(0, frases.length);
		
		fraseReal = frases[fila];
	}
	public void codificaFrase () {
		int fila = 0 ;
		int columna = 0;
		boolean termino = false;
		char letra;
		
		for (int i  = 0 ; i < fraseReal.length() ; i++) {
			fila = 0;
			termino = false;
			letra = fraseReal.charAt(i);
			
				if (letra == ' ') {
					fraseCodificada += "  ";
				} else {
					
					while (fila < abecedario.length && !termino) {
						columna = 0;
						while (columna < abecedario[fila].length && !termino) {
														
							if (abecedario[fila][columna] == letra) {
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
		boolean acierto = false;
		
		int fila = codigo / 10;
		int columna = codigo % 10;
		
		if (abecedario[fila][columna] == letra) {
			
			fraseCodificada = fraseCodificada.replace(String.valueOf(codigo), String.valueOf(letra));
			
			acierto = true;
		}
		
		return acierto;
	}
	public boolean sonIguales () {
		boolean iguales = true;
			
		return iguales;
	}
	public void pinta () {
		for (int i = 0 ; i < abecedario.length ; i++) {
			for (int j = 0 ; j < abecedario[i].length ; j++) {
				System.out.print(abecedario[i][j]);
			}
			System.out.println();
		}
	}
}
