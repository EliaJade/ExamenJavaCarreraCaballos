package main.java.examen.utilidades;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.examen.clases.Caballo;
import main.java.examen.clases.Carrera;
import main.java.examen.clases.Jinete;

public class SimUtils {

	private final static Logger Log = LoggerFactory.getLogger(SimUtils.class);
	public static int calcularEdad (int anioNacimiento) {
		int edad = 0;
		
		edad = 2025 - anioNacimiento;
		
		return edad;
	}
	
	public static void pintaMenu (String[] opciones) {
		
//		for (String opcion : opciones) {
//			System.out.println(opcion);
//		}
//		System.out.println("Introduce una opción");
		pintaMenu(opciones,"Introduce una opción");
	}
	
	public static void pintaMenu (String[] opciones, String texto) {
//		pintaMenu(opciones);
		for (String opcion : opciones) {
			System.out.println(opcion);
		}
		System.out.println(texto);
	}
	
	public static int pideDatoNumerico (String texto) {
		int numero=0;
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		numero = scan.nextInt();
		
		return numero;
	}
	
	public static String pideDatoCadena (String texto) {
		String dato="";
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		dato = scan.nextLine();
		
		return dato;
	}

	public static Caballo crearCaballoAleatorio(String nombreBase, Jinete j) {
		double peso= (int) (Math.random()*100)+100;
		Log.debug("Peso:" + peso);
		if (peso<200) {
			peso=200;

			Log.debug("Peso nuevo:" + peso);
		}
		
		double velocidad= (int) (Math.random()*10)+20;

		Log.debug("Velocidad:" + velocidad);
		if (velocidad>50) {
			velocidad=50;
			Log.debug("Velocidad nueva:" + velocidad);
		}
		
		int experiencia= (int) (Math.random()*10)+1;

		Log.debug("Experiencia:" + experiencia);
		if (experiencia>50) {
			experiencia=50;
			Log.debug("Experiencia nueva:" + experiencia);
		}
		Caballo caballoRandom= new Caballo (nombreBase, peso, velocidad,  experiencia, j );
		return caballoRandom;
	}
}
