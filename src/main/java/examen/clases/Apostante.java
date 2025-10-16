package main.java.examen.clases;

import main.java.examen.interfaces.Imprimible;
import main.java.examen.utilidades.SimUtils;

public class Apostante extends Persona implements Imprimible{
	
	double saldo = SimUtils.pideDatoNumerico("Cuanto saldo tienes?"); //might be wrong
	
	
	
	public Apostante(String nombre, int edad) {
		super(nombre, edad);
//		this.saldo=saldo; //se crea automaticamente
	}





	
	
	public double getSaldo() {
		return saldo;
	}







	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}







	@Override
	public String imprimeDatos() {
		
		String datosApuesta = "Saldo inicial: " + saldo + 
				"/nNombre del apostador: " + nombre + "/nEdad: "+ edad;
		return datosApuesta;
	}




	

}
