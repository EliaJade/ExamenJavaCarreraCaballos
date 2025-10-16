package main.java.examen.clases;

import java.util.List;


import main.java.examen.utilidades.SimUtils;

public class GranPremio {

	String nombre;
	List<Carrera> carreras;
	List <Apostante> apostantes;
	
	public static void main(String[]args) {

		Jinete jinete1 = new Jinete("Josef", 20, 1);
		Jinete jinete2 = new Jinete("Samuel", 28, 5 );
		Jinete jinete3 = new Jinete("Ford", 36, 10 );
	
	
		Caballo caballo1 =(SimUtils.crearCaballoAleatorio("Midnight", jinete1));
		Caballo caballo2 =(SimUtils.crearCaballoAleatorio("Juan", jinete2));
		Caballo caballo3 =(SimUtils.crearCaballoAleatorio("Storm", jinete3));
		
		Apostante apostante1 = new Apostante("Flor", 30);
		Apostante apostante2 = new Apostante("Lucifer", 1000);
		
		
		GranPremio granPremio = new GranPremio("Gran Premio");
		granPremio.agregarApostante(apostante1);
		granPremio.agregarApostante(apostante2);
		
	}
	

	
	
	
	
	public GranPremio(String nombre) {
		super();
		this.nombre = nombre;
//		this.carreras = carreras;
//		this.apostantes = apostantes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Carrera> getCarreras() {
		return carreras;
	}
	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}
	public List<Apostante> getApostantes() {
		return apostantes;
	}
	public void setApostantes(List<Apostante> apostantes) {
		this.apostantes = apostantes;
	}
	
	
	public void agregarApostante(Apostante apostante){
		apostantes.add(apostante);
		
	}
	
	public void empezarGranPremio() {
		
		
	}
	
	public void mostrarResumen() {
		
	}
	
}
