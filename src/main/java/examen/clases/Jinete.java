package main.java.examen.clases;

import java.util.Random;

import main.java.examen.interfaces.Participable;

public class Jinete extends Persona implements Participable{
	

	private int aniosExperiencia;
	private String id;
	
	
	public Jinete(String nombre, int edad, int aniosExperiencia) {
		super(nombre, edad);
		this.aniosExperiencia=aniosExperiencia;
	}



	
	
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}





	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}





	@Override
	public String getIdentificador() {
	Random random = new Random();
	this.id = "Jinete "+random.nextInt(1,100);
		return id;
//		String id = getNombre();
//		return id;
	}

}
