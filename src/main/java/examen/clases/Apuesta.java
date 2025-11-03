package main.java.examen.clases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.examen.utilidades.SimUtils;

public class Apuesta {

	private final static Logger Log = LoggerFactory.getLogger(Apuesta.class);
	
	
	private Apostante apostante;
	private Caballo caballo;
	private double importe;
	
	
	public Apuesta(Apostante apostante, Caballo caballo, double importe) {
		super();
		this.apostante = apostante;
		this.caballo = caballo;
		this.importe = importe;
	}
	public Apostante getApostante() {
		return apostante;
	}
	public void setApostante(Apostante apostante) {
		this.apostante = apostante;
	}
	public Caballo getCaballo() {
		return caballo;
	}
	public void setCaballo(Caballo caballo) {
		this.caballo = caballo;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	

	public double apostarDinero(Apostante apostante) {
	double cantidadApostada = 0;

	double cantidadQuererApostar= SimUtils.pideDatoNumerico("Cuanto quieres apostar " + apostante.getNombre()+ "?");
	if(cantidadQuererApostar<=apostante.getSaldo()) {
		cantidadApostada = cantidadQuererApostar;
	}
	else {
		System.out.println("No tienes suficiente saldo");
	}
	
	
	return cantidadApostada;

	
}
	
	
}
