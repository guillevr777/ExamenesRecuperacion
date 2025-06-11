package examenherencias.segundo.clases;

import examenherencias.segundo.excepciones.NegativeVelocityException;
import examenherencias.segundo.excepciones.NegativeVolumeException;
import examenherencias.segundo.interfaces.Velocidad;

public class AireAcondicionado extends Mando implements Velocidad{

	private enum Modo {FRIO, CALIENTE};
	private Modo modo = Modo.FRIO;
	private int temperatura;
	private int velocidad = 0;
	
	public AireAcondicionado(String modelo, double anchura, double altura, double precio) {
		super(modelo, anchura, altura, precio);
	}
	
	public String getModo () {
		return String.valueOf(this.modo);
	}
	
	public int getTemperatura () {
		return this.temperatura;
	}
	
	public void setTemperatura (int temperatura) {
		if (temperatura > 10 && temperatura < 30) {
			this.temperatura = temperatura;
		}
	}
	
	public int getVelocidad () {
		return this.velocidad;
	}
	
	//ESTA MAL QUITA EL PARAMETRO Y HAZ UN TERNARIO
	public void cambiarModo () {
		modo = modo.equals(Modo.FRIO) ? Modo.CALIENTE : Modo.FRIO;
	}
	
	@Override
	public void subirVelocidad() {
		if (this.velocidad < 3) {
			this.velocidad++;
		}
	}

	@Override
	public void bajarVelocidad() throws NegativeVelocityException {
		if (this.velocidad > 0) {
			this.velocidad--;
		} else {
			throw new NegativeVelocityException();
		}
	}
	
	@Override
	public String toString () {
		return "Mando para: AiresAcondicionados - " + super.toString();
	}
}
