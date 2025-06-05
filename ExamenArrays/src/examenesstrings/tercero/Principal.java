package examenesstrings.tercero;

public class Principal {

	public static void main(String[] args) {

		Jugador jugador = new Jugador();
		
		jugador.desordenaAbecedario();
		System.out.println(jugador.abecedario);
		jugador.eligeFrase();
		jugador.codificaFrase();
		jugador.compruebaCodigo(12, 'a');
		System.out.println(jugador.sonIguales());
		System.out.println(jugador.fraseCodificada);
	}
}
