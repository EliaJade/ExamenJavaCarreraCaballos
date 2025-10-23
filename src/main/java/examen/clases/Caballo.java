package main.java.examen.clases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.examen.interfaces.Avanzable;
import main.java.examen.interfaces.Imprimible;
import main.java.examen.interfaces.Participable;

public class Caballo implements Participable, Avanzable, Imprimible{
	
	private final static Logger Log = LoggerFactory.getLogger(Caballo.class);
	

	String nombre;
	double peso;
	double velocidad;
	int experiencia;
	Jinete jinete;
	double metrosRecorridos; //se tienen que resetear cada carrera
	
	public Caballo(String nombre, double peso, double velocidad, int experiencia, Jinete jinete) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.velocidad = velocidad;
		this.experiencia = experiencia;
		this.jinete = jinete;
//		this.metrosRecorridos = metrosRecorridos = 0; //may hay to delete this from constructor
	}
	
	public Caballo(String nombre, Jinete jinete) {
		this.nombre = nombre;
		this.jinete = jinete;
	}
	
	
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}


	public int getExperiencia() {
		return experiencia;
	}


	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}


	public Jinete getJinete() {
		return jinete;
	}


	public void setJinete(Jinete jinete) {
		this.jinete = jinete;
	}


	public double getMetrosRecorridos() {
		return metrosRecorridos;
	}


	public void setMetrosRecorridos(double metrosRecorridos) {
		this.metrosRecorridos = metrosRecorridos;
	}


	
	
	@Override
	public String getIdentificador() {
		String id = nombre;
		return id;
	}
	



	@Override
	public double calcularAvanceTurno() {
		int baseAleatoria= (int) (Math.random()*10)+1;
		if (baseAleatoria >10) {
			baseAleatoria= baseAleatoria-1;
		}
		double avanceTurno =  baseAleatoria + velocidad + experiencia - peso;
		if(avanceTurno<0) {
			avanceTurno = 0;
		}
		Log.info("El caballo "+ getNombre() + " ha avanzado +" + avanceTurno + "m");
		return avanceTurno ;
	}




	@Override
	public void aplicarAvance(double metros) {
		metrosRecorridos = metros; //might be more complicated than this
	}




	@Override
	public String imprimeDatos() {
		String datosCaballo = "Nombre del caballo: " + nombre + "/Peso: "+ peso + 
				"\nJinete: "+ jinete + "\nExperiencia: " + experiencia + 
				"\nVelocidad: " + velocidad + "km/h\nDistancia recorrido: " + metrosRecorridos ;
		
		return datosCaballo;
	}


	public void resetear() {
		metrosRecorridos=0;
	}
	
	public void sumarExperiencia() { //segun el enunciado debe tener el parametro de int puntos
		experiencia = experiencia+1;
	}


	
}
