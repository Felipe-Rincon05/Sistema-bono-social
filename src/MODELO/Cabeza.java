package MODELO;

public class Cabeza {
	private String nombre;
	private int id;
	private int salario;
	private int estrato;
	private int edad;
	private int cant;
	private boolean estado = true;
	
	public Cabeza(String nombre, int id, int salario, int estrato, int edad) {
		this.nombre = nombre;
		this.id = id;
		this.salario = salario;
		this.estrato = estrato;
		this.edad = edad;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCant() {
		return cant;
	}	
	
	public void setCant(int cant) {
		this.cant = cant;
	}
	public String getNombre() {
		return nombre;
	}
	public int getId() {
		return id;
	}
	public int getSalario() {
		return salario;
	}
	public int getEstrato() {
		return estrato;
	}
	public int getEdad() {
		return edad;
	}
}

