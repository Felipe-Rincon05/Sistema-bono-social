package MODELO;

public class Familias {
	private Cabeza cabeza[];
	private Integrantes integrantes[];
	public Familias(Cabeza[] cabeza, Integrantes[] integrantes) {
		this.cabeza = cabeza;
		this.integrantes = integrantes;
	}
	public Cabeza[] getCabeza() {
		return cabeza;
	}
	public Integrantes[] getIntegrantes() {
		return integrantes;
	}
	
	

}
