package main.java.examen.clases;

import main.java.examen.interfaces.Participable;

public class Jinete extends Persona implements Participable{
	

	int aniosExperiencia;
	
	
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
		// TODO Auto-generated method stub
		return null;
	}

}
