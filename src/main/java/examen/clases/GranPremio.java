package main.java.examen.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.examen.utilidades.SimUtils;

public class GranPremio {

	private final static Logger Log = LoggerFactory.getLogger(GranPremio.class);

	private String nombre;
	
	private List <Apostante> apostantes;

	private List<Carrera> carreras;
	
	

	
	
	
	
	public GranPremio(String nombre) {
		super();
		this.nombre = nombre;
//		this.carreras = carreras;
//		this.apostantes = apostantes;
	}
	public GranPremio(String nombre, List<Carrera> carreras) {
		super();
		this.nombre = nombre;
		this.carreras = carreras;
		this.apostantes = new ArrayList<>();
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
	
	
//	public void agregarApostante(Apostante apostante){
//		apostantes.add(apostante);
//		
//	}
//	public void agregarCaballo(Caballo caballo){
//		caballos.add(caballo);
//		
//	}
	
	public void empezarGranPremio() {

		System.out.println("Empezamos el Gran Premio");
		
		
		int contadorNumApuesta =0;
		for (Apostante apostante : apostantes) {
			Caballo caballoApostado = apostarCaballo(apostante);
			double dineroApostado = apostarDinero(apostante, caballoApostado);
			Apuesta apuesta= new Apuesta(apostante, caballoApostado, dineroApostado);
		
			
		}
		
	}
	
	public void mostrarResumen() {
		
	}
	
	public void init(){
		crearCarrera();
		this.apostantes = SimUtils.crearApostantes();
	}
	
	public void crearCarrera() {
		//CREAR Jinete
		Jinete jinete1 = new Jinete("John", 20, 2);
		Jinete jinete2 = new Jinete("Pepe", 32, 12);
		Jinete jinete3 = new Jinete("Samara", 23, 4);
		
		
		//CREAR CABALLOS
		Caballo caballo1 = SimUtils.crearCaballoAleatorio("Midnight", jinete1);
		Caballo caballo2 = SimUtils.crearCaballoAleatorio("Bullseye", jinete2);
		Caballo caballo3 = SimUtils.crearCaballoAleatorio("Gordon", jinete3);
		
		
		//CREar CARRERAS
		Carrera carrera1 = new Carrera("Carrera 1", 500);
		Carrera carrera2 = new Carrera ("Carrera 2", 50);
		
		
		List<Caballo> caballos = Arrays.asList(caballo1, caballo2, caballo3);
		
		carrera1.setParticipantes(caballos);
		carrera2.setParticipantes(caballos);
		
		Carrera carrera3 = new Carrera ("Carrera 3", 700, caballos);
//		carrera3.getParticipantes().add(caballo3);
//		carrera3.addCaballo(caballo3);
		
		this.carreras = Arrays.asList(carrera1, carrera2, carrera3);
		
		
	}
	
	

	public double apostarDinero(Apostante apostante, Caballo caballoApostado) {
		double cantidadApostada = 0;
		while(!(cantidadApostada>0 && cantidadApostada<=apostante.getSaldo())) {
			double cantidadQuererApostar= SimUtils.pideDatoNumerico("Cuanto quieres apostar " + apostante.getNombre()+ "?");
			if(cantidadQuererApostar<=apostante.getSaldo()) {
				cantidadApostada = cantidadQuererApostar;
			}
			else {
				System.err.println("No tienes suficiente saldo");
			}
		}
		
		String Y_N= SimUtils.pideDatoCadena("Estas seguro que quieres apostar: " + cantidadApostada +" euros en " + caballoApostado.getNombre());
		if(Y_N.equalsIgnoreCase("yes")) {
			apostante.setSaldo(apostante.getSaldo()-cantidadApostada);
		}
		return cantidadApostada;

		
	}
	public Caballo apostarCaballo(Apostante apostante) {
		Caballo caballoApostado = null;
//		mostrarCaballos();
		while(caballoApostado==null) {
			String caballoQuererApostar= SimUtils.pideDatoCadena("En quien quieres aposatar " + apostante.getNombre() + "?");
			for (Carrera carrera : carreras) {
				for (Caballo caballo : carrera.getParticipantes()) {
					if(caballoQuererApostar.equalsIgnoreCase(caballo.getIdentificador())) {
						caballoApostado=caballo;
						Log.info(caballoApostado.getNombre());
					}
					
					}
				if(caballoApostado==null) {
					System.err.println("No has apostado a ningun caballo");
					Log.error("caballoApostado is null");
				}
			}
			}
			
		
		
		
		return caballoApostado;
	
	}
	
	public void mostrarCaballos() {
		
		for (Carrera carrera : carreras) {
			for (Caballo caballo : carrera.getParticipantes()) {
				System.out.println("==============\nNombre: " +caballo.getNombre() +"\nVelocidad: " + caballo.getVelocidad()+ 
						"\nPeso: "+caballo.getPeso() + "\nJinete: "+caballo.getJinete().getNombre() + "\nExperiencia de jinete: "+ caballo.getJinete().getAniosExperiencia());
			}
		}
		
	}
	

	

	
	
}
