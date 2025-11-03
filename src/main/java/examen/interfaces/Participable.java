package main.java.examen.interfaces;

@FunctionalInterface
public interface Participable {
	
	String getIdentificador();
	
	//METODO DEFAULT
	default public void participar() {
		System.out.println("Participando");
	}

}
