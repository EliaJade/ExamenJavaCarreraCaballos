

package main.java.examen.utilidades;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.examen.clases.Apostante;
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
		Log.debug(nombreBase+": Peso:" + peso);
		if (peso>200) {
			peso=200;

			Log.debug(nombreBase+ ": Peso nuevo:" + peso);
		}
		
		double velocidad= (int) (Math.random()*10)+20;

		Log.debug(nombreBase+": Velocidad:" + velocidad);
		if (velocidad>50) {
			velocidad=50;
			Log.debug(nombreBase+": Velocidad nueva:" + velocidad);
		}
		
		int experiencia= (int) (Math.random()*10)+1;

		Log.debug(nombreBase+": Experiencia:" + experiencia);
		if (experiencia>50) {
			experiencia=50;
			Log.debug(nombreBase+": Experiencia nueva:" + experiencia);
		}
		Caballo caballoRandom= new Caballo (nombreBase, peso, velocidad,  experiencia, j );
		return caballoRandom;
	}
	
	public static List<Apostante> crearApostantes() {
		Apostante apostante1 = new Apostante("Lucifer", 20000);
		Apostante apostante2 = new Apostante("Flor", 26);
		List<Apostante> apostantes = Arrays.asList(apostante1, apostante2);
		return apostantes;
	}
	
}
