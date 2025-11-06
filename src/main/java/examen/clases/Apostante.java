package main.java.examen.clases;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.examen.interfaces.Imprimible;
import main.java.examen.utilidades.SimUtils;

public class Apostante extends Persona implements Imprimible{

	private final static Logger Log = LoggerFactory.getLogger(Apostante.class);
	
	private double saldo = SimUtils.pideDatoNumerico("Cuanto saldo tienes " +getNombre()+ "?"); //might be wrong
	private List<Apuesta> apuestasDelApostante = new CopyOnWriteArrayList<Apuesta>();
	
	
	
	public Apostante(String nombre, int edad) {
		super(nombre, edad);
//		this.saldo=saldo; //se crea automaticamente
	}





	
	
	public List<Apuesta> getApuestasDelApostante() {
		return apuestasDelApostante;
	}







	public void setApuestasDelApostante(List<Apuesta> apuestasDelApostante) {
		this.apuestasDelApostante = apuestasDelApostante;
	}







	public double getSaldo() {
		return saldo;
	}







	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}




       


	@Override
	public String toString() {
		return "Saldo inicial: " + saldo + 
				"/nNombre del apostador: " + getNombre() + "/nEdad: "+ getEdad();
	}







	@Override
	public void imprimeDatos() {
		System.out.println(this);
	}


	public double apostarDinero(Caballo caballoApostado) {
		double cantidadApostada = -1;
		while(!(cantidadApostada>=0 && cantidadApostada<=this.saldo)) {
			double cantidadQuererApostar= SimUtils.pideDatoNumerico("Cuanto quieres apostar " + this.getNombre()+ "?");
			if(cantidadQuererApostar<=this.saldo) {
				cantidadApostada = cantidadQuererApostar;
			}
			else {
				System.err.println("No tienes suficiente saldo");
			}
		}
		
		String Y_N= SimUtils.pideDatoCadena("Estas seguro que quieres apostar: " + cantidadApostada +" euros en " + caballoApostado.getNombre());
		if(Y_N.equalsIgnoreCase("si")) {
			double saldoRestante= this.saldo-cantidadApostada;
			this.setSaldo(saldoRestante);
			Log.info("Has apostado " + cantidadApostada + " a " + caballoApostado.getNombre() + " y se ha quedado con " + saldoRestante );
		}
		else {
			cantidadApostada = 0;
			Log.info("No has apostado nada al caballo " + caballoApostado);
		}
		
		return cantidadApostada;
	}

	

}
