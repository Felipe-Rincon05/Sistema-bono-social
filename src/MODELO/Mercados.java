package MODELO;

public class Mercados {
	private String nombre_prod;
	private int cant;
	
	public Mercados(String nombre_prod, int cant) {
		this.nombre_prod = nombre_prod;
		this.cant = cant;
	}
	public String getNombre_prod() {
		return nombre_prod;
	}
	public int getCant() {
		return cant;
	}
}