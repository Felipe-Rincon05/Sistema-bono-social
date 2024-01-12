package MODELO;

public class Integrantes {
	private String nombre;
	private int id;
	private String parentesco;
	private int edad;
	
	public Integrantes(String nombre, int id, String parentesco, int edad) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.parentesco = parentesco;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getId() {
		return id;
	}
	public String getPariente() {
		return parentesco;
	}
	public int getEdad() {
		return edad;
	}
}

