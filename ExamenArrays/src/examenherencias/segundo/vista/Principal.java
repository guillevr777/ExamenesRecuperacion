package examenherencias.segundo.vista;

import java.util.ArrayList;
import java.util.List;

import examenherencias.segundo.clases.AireAcondicionado;
import examenherencias.segundo.clases.Aspiradora;
import examenherencias.segundo.clases.Mando;
import examenherencias.segundo.clases.Minicadenas;
import examenherencias.segundo.clases.Television;
import examenherencias.segundo.excepciones.NegativeVelocityException;
import examenherencias.segundo.excepciones.NegativeVolumeException;

public class Principal {

	public static void main(String[] args) {

		List<Mando> lista = new ArrayList<Mando>();
		
		Television tele = new Television ("Sansung",2.4,1.2,333.33);
		Aspiradora aspi = new Aspiradora ("Rumba",1.1,1.1,505.33);
		Minicadenas mini = new Minicadenas ("LaSexta",0,0,0);
		AireAcondicionado aire = new AireAcondicionado ("Bosch",3.2,3.3,1300);
		
		lista.add(aire);
		lista.add(mini);
		lista.add(aspi);
		lista.add(tele);
		
		for (Mando man : lista) {
			System.out.println(man);
			man.alternarEncendido();
			System.out.println(man.isEncendido() ? "Encendido":"Apagado");
			System.out.println("-------------------------------------------------");
			
			if (man instanceof Television) {
				((Television) man).setCanal(3);
				((Television) man).subirVolumen();
				((Television) man).subirVolumen();
				try {
					((Television) man).bajarVolumen();
				} catch (NegativeVolumeException e) {
					System.out.println(e);
				}
			} else if (man instanceof Minicadenas) {
				((Minicadenas) man).subirVolumen();
				((Minicadenas) man).subirVolumen();
				try {
					((Minicadenas) man).bajarVolumen();
				} catch (NegativeVolumeException e) {
					System.out.println(e);
				}
			} else if (man instanceof Aspiradora) {
				((Aspiradora) man).subirVelocidad();
				((Aspiradora) man).subirVelocidad();
				try {
					((Aspiradora) man).bajarVelocidad();
				} catch (NegativeVelocityException e) {
					System.out.println(e);
				}
			} else if (man instanceof AireAcondicionado) {
				((AireAcondicionado) man).setModo("CALIENTE");
				((AireAcondicionado) man).setTemperatura(28);
				((AireAcondicionado) man).subirVelocidad();
				((AireAcondicionado) man).subirVelocidad();
				((AireAcondicionado) man).subirVelocidad();
				((AireAcondicionado) man).subirVelocidad();
			}
		}
		
		System.out.println("Comprobaciones:");
		System.out.println("--Televion--");
		System.out.println("Volumen -> "+tele.getVolumen());
		System.out.println("Canal -> " + tele.getCanal());
		System.out.println("\n--Minicadena--");
		System.out.println("Volumen -> "+mini.getVolumen());
		System.out.println("\n--Aspiradora--");
		System.out.println("Velocidad -> " + aspi.getVelocidad());
		System.out.println("\n--aireAcondicionado--");
		System.out.println("Modo -> " + aire.getModo());
		System.out.println("Temperatura -> " + aire.getTemperatura());
		System.out.println("Velocidad -> " + aire.getVelocidad());
		
	}
}
