package CONTROL;

import MODELO.Proceso;

public class Ejecutar {
	public static void main(String []args) {
		Proceso ob = new Proceso ();
		ob.mercados();
		ob.registrarCabeza();
		ob.resumen ();
		ob.consulta();
	}
}
