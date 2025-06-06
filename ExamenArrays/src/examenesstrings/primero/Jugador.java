package examenesstrings.primero;

import java.util.Random;
import java.util.Scanner;

public class Jugador {

	String palabras[] = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza", "brazo",
			"familia" };

	final int NUMINTENTOS = 7;

	String palabraSecreta = "";

	String palabraPista = "";

	String noAcertadas = "";

	public void generaPalabra() {
		Random random = new Random();

		palabraSecreta = palabras[random.nextInt(0, palabras.length)];
		palabraPista = "-".repeat(palabraSecreta.length());
	}

	public int menu() {
		Scanner reader = new Scanner(System.in);
		int opc;

		System.out.println("Seleccione una de las siguientes opciones:\n1.Introducir letra\n2.Introducir palabra");
		opc = reader.nextInt();
		reader.nextLine();

		return opc;
	}
	public boolean compruebaLetra (char letra) {
		
		boolean exito = true;
		String nuevaLetra = String.valueOf(letra).toLowerCase();
		char nuevasPistas[] = palabraPista.toCharArray();

		if (!noAcertadas.contains(nuevaLetra)) {
			if (palabraSecreta.contains(nuevaLetra)) {
				int posicion = palabraSecreta.indexOf(nuevaLetra);
				while (posicion >= 0) {
					nuevasPistas[posicion] = letra;
					posicion = palabraSecreta.indexOf(nuevaLetra, posicion + 1);
				}
			} else {
				noAcertadas += nuevaLetra;
				exito = false;
			}
		}
		palabraPista = String.valueOf(nuevasPistas);
		
		return exito;
	}
	public boolean compruebaPalabra(String palabra) {

		boolean exito = false;
		
		if (palabraSecreta.equalsIgnoreCase(palabra)) {
			palabraPista = palabra;
			exito = true;
		}
		
		return exito;
	}

	public void pintaPista() {

		if (noAcertadas.length() > 0) {
			for (int i = 0; i < noAcertadas.length(); i++) {
				if (i == noAcertadas.length() - 1) {
					System.out.print(noAcertadas.charAt(i) + ".");
				} else {
					System.out.print(noAcertadas.charAt(i) + ", ");
				}
			}

			System.out.println();
		}

		for (int i = 0; i < palabraPista.length(); i++) {

			System.out.print(palabraPista.charAt(i) + " ");
		}

		System.out.println();
	}
}
