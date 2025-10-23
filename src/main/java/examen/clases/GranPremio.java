package main.java.examen.clases;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.examen.utilidades.SimUtils;

public class GranPremio {

	private final static Logger Log = LoggerFactory.getLogger(GranPremio.class);

	String nombre;
	List<Carrera> carreras;
	List <Apostante> apostantes = new ArrayList();
	List <Caballo> caballos = new ArrayList();
	
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
		granPremio.agregarCaballo(caballo1);
		granPremio.agregarCaballo(caballo2);
		granPremio.agregarCaballo(caballo3);
		granPremio.empezarGranPremio();

		
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
	public void agregarCaballo(Caballo caballo){
		caballos.add(caballo);
		
	}
	
	public void empezarGranPremio() {
		int contadorNumApuesta =0;
		for (Apostante apostante : apostantes) {
			Caballo caballoApostado = apostarCaballo(apostante);
			double dineroApostado = apostarDinero(apostante, caballoApostado);
			Apuesta apuesta= new Apuesta(apostante, caballoApostado, dineroApostado);
		
			
		}
		
	}
	
	public void mostrarResumen() {
		
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
		
//		
		
		String Y_N= SimUtils.pideDatoCadena("Estas seguro que quieres apostar: " + cantidadApostada +" euros en " + caballoApostado.getNombre());
		if(Y_N.equalsIgnoreCase("yes")) {
			apostante.setSaldo(apostante.saldo-cantidadApostada);
		}
		return cantidadApostada;

		
	}
	public Caballo apostarCaballo(Apostante apostante) {
		Caballo caballoApostado = null;
		mostrarCaballos();
		while(caballoApostado==null) {
			String caballoQuererApostar= SimUtils.pideDatoCadena("En quien quieres aposatar " + apostante.getNombre() + "?");
			for (Caballo caballo : caballos) {
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
		
		
		
		return caballoApostado;
	
	}
	
	public void mostrarCaballos() {
		for (Caballo caballo : caballos) {
			System.out.println("==============\nNombre: " +caballo.getNombre() +"\nVelocidad: " + caballo.getVelocidad()+ 
					"\nPeso: "+caballo.getPeso() + "\nJinete: "+caballo.getJinete().getNombre() + "\nExperiencia de jinete: "+ caballo.getJinete().getAniosExperiencia());
		}
	}
	

	

	
	
}
