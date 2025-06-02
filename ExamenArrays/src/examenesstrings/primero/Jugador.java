package examenesstrings.primero;

import java.util.Random;
import java.util.Scanner;

public class Jugador {

	String palabras[] = {"humanidad","persona","hombre","mujer","individuo","cuerpo","pierna","cabeza","brazo","familia"};
	
	final int NUMINTENTOS = 7;
	
	String palabraSecreta = "";
	
	String palabraPista = "";
	
	String noAcertadas = "";
	
	public void generaPalabra () {
		Random random = new Random();
		
		palabraSecreta = palabras[random.nextInt(0,10)];
	}
	public int menu () {
		Scanner reader = new Scanner(System.in);
		int opc;
		
		System.out.println("Seleccione una de las siguientes opciones:\n1.Introducir letra\n2.Introducir palabra");
		opc = reader.nextInt();
		
		return opc;
	}
	public void compruebaLetra (char letra) {
		
		if (palabraSecreta.contains(String.valueOf(letra).toLowerCase())) {
			
		}
	}
	public void compruebaPalabra (String palabra) {
		
		if (palabraSecreta.equalsIgnoreCase(palabra)) {
			palabraPista = palabra;
		}
	}
	public void pintaPista () {
		
		if (noAcertadas.length() > 0) {
			for (int i = 0 ; i < noAcertadas.length() ; i++) {
				if (i == noAcertadas.length() - 1) {
					System.out.print(noAcertadas.charAt(i) + ".");
				} else {
					System.out.print(noAcertadas.charAt(i) + ", ");
				}
			}
			
			System.out.println();
		}
		
		for (int i = 0 ; i < palabraPista.length() ; i++) {
			System.out.print(palabraPista.charAt(i) + " ");
		}
	}
}
