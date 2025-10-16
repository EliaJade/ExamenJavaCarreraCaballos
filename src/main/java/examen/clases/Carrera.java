package main.java.examen.clases;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Carrera {
	private final static Logger Log = LoggerFactory.getLogger(Carrera.class);
	

	String  nombre;
	double distanciaObjetivo = 200;
	List<Caballo> participantes = new ArrayList();
	List<Apuesta> apuestas = new ArrayList();
	public Carrera(String nombre, double distanciaObjetivo, List<Caballo> participantes, List<Apuesta> apuestas) {
		super();
		this.nombre = nombre;
		this.distanciaObjetivo = distanciaObjetivo;
		this.participantes = participantes;
		this.apuestas = apuestas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDistanciaObjetivo() {
		return distanciaObjetivo;
	}
	public void setDistanciaObjetivo(double distanciaObjetivo) {
		this.distanciaObjetivo = distanciaObjetivo;
	}
	public List<Caballo> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Caballo> participantes) {
		this.participantes = participantes;
	}
	public List<Apuesta> getApuestas() {
		return apuestas;
	}
	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	
	public void iniciar() {
		boolean ganador = false;
	int contadorTurno = 1;
	for (Caballo caballo : participantes) {
		caballo.resetear();
	}
		while (ganador==false) {
			System.out.println("Turno " + contadorTurno + ";" );
			for (Caballo caballo : participantes) {
				Jinete jinete = caballo.getJinete();
				double distanciaRecorrido = caballo.calcularAvanceTurno(); //this might not work
				caballo.aplicarAvance(distanciaRecorrido);
				
				System.out.println("El jinete" + jinete.getNombre() + " con su caballo " + caballo.getNombre() +" han avanzado un total de " + distanciaRecorrido + "m"); 
			
				if (distanciaRecorrido>=distanciaObjetivo) {
					Log.debug("Ha entrado en el if de ganador cambiandolo a true");
					ganador = true;
					;// falta poner aqui el metodo de decir el ganador o sino el dialogo
					break;
				}
				
			}
			contadorTurno++;
		
		}

	
	}
	
}
