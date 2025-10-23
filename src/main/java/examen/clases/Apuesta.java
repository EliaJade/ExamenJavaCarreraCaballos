package main.java.examen.clases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.examen.utilidades.SimUtils;

public class Apuesta {

	private final static Logger Log = LoggerFactory.getLogger(Apuesta.class);
	
	
	Apostante apostante;
	Caballo caballo;
	double importe;
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
	
//	public double apostarDinero() {
//		String Y_N = "";
//		double cantidadApostada = 0;
//		String caballoApostado = "";
//
//		
//		while(!(Y_N.equalsIgnoreCase("yes"))) {
//		String caballoQuererApostar= SimUtils.pideDatoCadena("En quien quieres aposatar?");
//		double cantidadQuererApostar= SimUtils.pideDatoNumerico("Cuanto quieres apostar?");
//		if(cantidadQuererApostar<=apostante.getSaldo()) {
//			cantidadApostada = cantidadQuererApostar;
//		}
//		else {
//			System.out.println("No tienes suficiente saldo");
//		}
//		
//		if(caballoQuererApostar.equalsIgnoreCase(caballo.getIdentificador())) {
//			caballoApostado=caballoQuererApostar;
//			Y_N= SimUtils.pideDatoCadena("Estas seguro que quieres apostar: " + cantidadApostada + " en " + caballo.getNombre());
//			if(Y_N.equalsIgnoreCase("yes")) {
//				apostante.setSaldo(apostante.saldo-cantidadApostada);
//			}
//		}
//			
//		}
//		
//		return ;
//
//		
//	}
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
