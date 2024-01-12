package MODELO;

import VISTA.InOut;

public class Proceso {
	InOut ob = new InOut();
	private String parentesco, nombres[][],parentescos[][];
	private Cabeza cabeza[];
	private Mercados productos[];
	private Integrantes integrantes[];
	private double bonos=0;
	private int cantidad_prod,re =0,precio_merc,cantidad_merc,dados_merc=0,dados_adi=0,aux=0, aux2=0, ids [][],c=0,cant_dispo_adi,cant_dispo_merc,precio_adi=0, edades[][], cantidad=0,cant_vit,precio_vit,cant_col,precio_col,cant_tar,precio_tar;
	public Proceso () {
		cabeza = new Cabeza [100];
		integrantes = new Integrantes[20];
		productos = new Mercados [20];
		ids = new int [20][100];
		edades = new int [20][100];
		nombres = new String [20][100];
		parentescos = new String [20][100];
	}
	public void registrarCabeza() {
		int res, id, salario, estrato, edad;
		String nom;
		res = ob.pedirEntero("Si va a registrar una persona escriba 1");
		while (res == 1) {
			ob.mostrarDatos("Ingrese los datos unicamente un adulto por familia");
			nom = ob.pedirString("Ingrese el nombre");
			do {
			id = ob.pedirEntero("Ingrese la cedula");
			} while (id < 99999 || !verificar_id(id));
			ids [0][c] = id;
			do {
			salario = ob.pedirEntero("Ingrese el salario");
			} while (!validarSalario(salario));
			do {
			estrato = ob.pedirEntero("Ingrese el estrato, tenga en cuenta que si su estrato es mayor a 3 ya no aplica para ninguna ayuda");
			}while(estrato <0 || estrato >3);
			do {
			edad = ob.pedirEntero("Ingrese la edad");
			}while(edad>120 || edad<18);
			do {
				cantidad = ob.pedirEntero("Ingrese la cantidad de integrantes del hogar");
			} while (!validarEntero (cantidad));
			parientes ();
			Cabeza persona = new Cabeza (nom, id, salario, estrato, edad);
			persona.setCant(cantidad);
			cabeza [c] = persona;
			monstrar_datos();
			opcion();
			res = ob.pedirEntero("Si va a registrar otra persona escriba 1");
			c++;
		}
	}
	
	public void parientes () {
		String nombre,m;
		int id1, edad1, opc;
		ob.mostrarDatos("Ingrese datos de los parientes: ");
		for (int o = 0; o < cantidad; o++) {
			ob.mostrarDatos("Pariente "+(o+1));
			nombre = ob.pedirString("Ingrese el nombre");
			nombres[o][c] = nombre; 
			//
			do {
			m = "Ingrese el parentesco \n";
			m += "1. Esposo(a) \n";
			m += "2. Hijo(a) \n";
			m += "3. Papa \n";
			m += "4. Mama \n";
			m += "5. Hermano(a) \n";
			m += "6. Tio(a) \n";
			opc = ob.pedirEntero(m);
			} while (opc >=7 || opc <= 0);
			menu (opc);
			parentescos[o][c] = parentesco;
			//
			do {
			id1 = ob.pedirEntero("Ingrese la cedula");
			} while (id1 < 10000 || !verificar_id(id1));
			ids [o+1][c] = id1;
			
			do {
			edad1 = ob.pedirEntero("Ingrese la edad");
			}while(edad1>120 || edad1<0);
			edades [o][c] = edad1;
			Integrantes personas = new Integrantes (nombre, id1, parentesco, edad1);
			integrantes[o] = personas;
		}
	
	}
	
	public boolean validarEntero(int d) { 	return d>0; }
	public boolean validarSalario(int d) { 
		boolean a=false;
		if( d >= 50 && d <= 2200000) {
			a = true;
		}
		return a; }
	public void monstrar_datos () {
		String md;
		md="Estos son los datos registrados: \n\n";
			md += "El nombre de la cabeza de familia es: "+cabeza[c].getNombre()+"\n";
			md += "Es estrato: "+cabeza[c].getEstrato()+"\n";
			md += "Tiene cedula: "+cabeza[c].getId()+"\n\n";
			
			md += "Los parientes son: \n\n";
				for (int k = 0; k < cantidad; k++) {
					md += "Nombre: "+nombres[k][c]+"\n";
					md += "Parentesco: "+parentescos[k][c] +"\n";
					md += "Edad: "+edades[k][c]+"\n";
					md += "Id: "+ids[k+1][c] +"\n\n";
					
				}
				ob.mostrarDatos(md);
	}
	public boolean verificar_id (int a) {
		boolean validacion=true;
		if(c==0) {
			for(int w=0;w<20;w++) {
				if(ids[w][0]==a) {
					validacion = false;
				}
			}
		}else {
		for(int q=0;q<=c;q++) {
			for(int w=0;w<20;w++) {
				if(ids[w][q]==a) {
					validacion = false;
				}
			}
		}
		}
		return validacion;
	}
	
	public void mercados() {
		String nombre_prod;
		int precio_prod;
		ob.mostrarDatos("MERCADOS");
		cant_dispo_merc = ob.pedirEntero("Digite el numero de mercados disponibles");
		aux = cant_dispo_merc;
		cantidad_merc = ob.pedirEntero("Ingrese la cantidad de productos diferentes que hay en una sola canasta");
		for (int w = 0; w < cantidad_merc ; w++) {
		ob.mostrarDatos("Producto " + (w+1));
		nombre_prod = ob.pedirString("Ingrese el nombre del producto");
		do {
		cantidad_prod = ob.pedirEntero("Ingrese la cantidad del producto");
		}while(cantidad_prod <= 0 || cantidad_prod >= 6);
		do{
		precio_prod = ob.pedirEntero("Ingrese el valor del producto por unidad");
		}while(!validarSalario(precio_prod));
		
		precio_merc = precio_merc + (cantidad_prod * precio_prod);
		Mercados canasta = new Mercados (nombre_prod, cantidad_prod);
		productos[w] = canasta;
		}
			cant_dispo_adi = ob.pedirEntero("Digite el numero de adicionales disponibles");
			aux2 = cant_dispo_adi;
			do {
			cant_col = ob.pedirEntero("Ingrese la cantidad de coladas");
			}while(cant_col <= 0 || cant_col >= 6);
			do{
			precio_col = ob.pedirEntero("Ingrese el valor del producto por unidad");
			}while(!validarSalario(precio_col));
			do {
				cant_vit = ob.pedirEntero("Ingrese la cantidad de vitaminas");
				}while(cant_vit <= 0 || cant_vit >= 6);
				do{
				precio_vit= ob.pedirEntero("Ingrese el valor del producto");
				}while(!validarSalario(precio_vit));
				do {
					cant_tar = ob.pedirEntero("Ingrese la cantidad de unidades de tarrito rojo");
					}while(cant_tar <= 0 || cant_tar >= 6);
					do{
					precio_tar = ob.pedirEntero("Ingrese el valor del producto por unidad");
					}while(!validarSalario(precio_tar));
					precio_adi = (precio_col*cant_col) + (precio_tar* cant_tar) + (precio_vit*cant_vit);
		mostrar_mercados();
		ob.mostrarDatos("El precio del mercado es: " + precio_merc + "\n El precio por adicionales es: "+precio_adi);
		}
	
	public void mostrar_mercados(){
		String m;
		m = "Esta es la lista de productos para los mercados \n";
		for(int i=0 ; i<cantidad_merc ; i++) {
			m += "Producto " + (i+1) + ":          "+ productos[i].getNombre_prod() + " , con " +productos[i].getCant()+ " unidades. \n";
		}
		ob.mostrarDatos(m);
	}
	public void mostrar_mercadosadicional(){
		String m;
		m = "Esta es la lista de productos para los mercados \n";
		for(int i=0 ; i<cantidad_merc ; i++) {
			m += "Producto " + (i+1) + ":          "+ productos[i].getNombre_prod() + " , con " +productos[i].getCant()+ " unidades. \n";
		}
		m += "ADICIONAL: \n\n";
		m += cant_vit +" unidades de vitaminas\n";
		m += cant_col + " unidades de coladas \n";
		m += cant_tar + " unidades de tarrito rojo \n";
		ob.mostrarDatos(m);
	}
	public void adicional () {
		String m;
		m = "ADICIONAL: \n\n";
		m += cant_vit +" unidades de vitaminas\n";
		m += cant_col + " unidades de coladas \n";
		m += cant_tar + " unidades de tarrito rojo \n";
		ob.mostrarDatos(m);
	}
	public String menu (int opc) {
	switch (opc) {
		case 1: parentesco = "Esposo(a)";
				break;
		case 2: parentesco = "Hijo(a)";
				break;
		case 3: parentesco = "Papa";
				break;
		case 4: parentesco = "Mama";
				break;
		case 5: parentesco = "Hermano(a)";
				break;
		case 6: parentesco = "Tio(a)";
				break;
	}
	return parentesco;
}
	public void opcion () {
		double bono;
		String mt;
		int menores = 0;
		if(cabeza[c].getEstrato() == 1 || cabeza[c].getEstrato() == 2) {
			mt ="Estos son los beneficios que reciben usted y su familia \n\n";
			bono = cabeza[c].getSalario() / 2;
			bonos = bonos + bono;
			mt += "Recibe un bono por el valor de "+bono+" pesos, ademas el siguiente mercado";
			ob.mostrarDatos(mt);
			for (int t = 0; t < 20; t++) {
				if (edades[t][c] < 18 && edades[t][c] > 0) {
					menores++;
				}
			}
			if (menores > 2 && cabeza[c].getCant() > 4 && cant_dispo_adi>0 && cant_dispo_merc > 0) {
				mostrar_mercadosadicional();
				cant_dispo_merc --;
				cant_dispo_adi --;
			}else {
				if (cant_dispo_merc <= 0 || cant_dispo_adi <= 0) {
					ob.mostrarDatos("No hay mercados disponibles o no hay adicionales disponibles");
					cabeza[c].setEstado(false);
				}
				if (cant_dispo_merc > 0) {
					cant_dispo_merc --;
					mostrar_mercados();
				}

			}
		} else {
			if (cabeza[c].getEstrato() == 3) {
				mt ="Estos son los beneficios que reciben usted y su familia \n\n";
				bono = cabeza[c].getSalario() * 0.3;
				mt += "Recibe un bono por el valor de "+bono+" pesos";
				bonos = bonos + bono;
				ob.mostrarDatos(mt);
				for (int t = 0; t < 20; t++) {
					if (edades[t][c] < 18 && edades[t][c] > 0) {
						menores++;
					}
				}
				if (menores > 2 && cabeza[c].getCant() > 4 && cant_dispo_adi>0) {
					adicional();
					cant_dispo_adi --;
				}else {
					if (cant_dispo_merc <= 0 || cant_dispo_adi <= 0) {
						ob.mostrarDatos("No hay mercados disponibles o no hay adicionales disponibles");
					}
				}
			}
		}
	}
	
	public void resumen () {
		int merc_dados,adi_dados , gasto_merc;
		merc_dados = precio_merc *(aux - cant_dispo_merc);
		adi_dados =precio_adi*( aux2 - cant_dispo_adi);
		gasto_merc = merc_dados + adi_dados;
		dados_merc = aux - cant_dispo_merc;
		dados_adi = aux2 - cant_dispo_adi;
		
		String m;
		m = "Este es el resumen de lo que se gasto en las ayudas \n\n" ;
		m += "Lo invertido en mercados fueron: "+ gasto_merc +" pesos \n";
		m += "Lo invertido en bonos fueron: "+bonos+" pesos \n\n";
		if(cant_dispo_merc>0) {
			m+= "Sobraron "+ cant_dispo_merc +" mercados \n";
		} else {
			m += "No sobraron mercados \n";
		}
		if(cant_dispo_adi>0) {
			m+= "Sobraron "+ cant_dispo_adi +" adicioanles \n";
		} else {
			m += "No sobraron adicionales \n";
		}
		m += "Se dieron "+dados_merc+" mercados \n";
		m += "Se dieron "+dados_adi+" adicionales \n\n";		
		m += "En total se invirtieron: " + (gasto_merc + bonos) + " pesos \n";
		ob.mostrarDatos(m);
	}
	
	public void consulta () {
		int cedula;
		boolean w = false;
		do {
		do {
			cedula = ob.pedirEntero("Digite la cedula que desea consultar");
		}while(cedula < 99999);
		for(int i=0;i<c;i++) {
			if(cabeza[i].getId()==cedula) {
				String md;
				w = true;
				md="Estos son los datos registrados: \n\n";
					md += "El nombre de la cabeza de familia es: "+cabeza[i].getNombre()+"\n";
					md += "Es estrato: "+cabeza[i].getEstrato()+"\n";
					md += "Tiene cedula: "+cabeza[i].getId()+"\n\n";
					
					md += "Los parientes son: \n\n";
						for (int k = 0; k < cantidad; k++) {
							md += "Nombre: "+nombres[k][i]+"\n";
							md += "Parentesco: "+parentescos[k][i] +"\n";
							md += "Edad: "+edades[k][i]+"\n";
							md += "Id: "+ids[k+1][i] +"\n\n";
							
						}
						ob.mostrarDatos(md);
			//
						double bono;
						String mt;
						int menores = 0;
						if(cabeza[i].getEstrato() == 1 || cabeza[i].getEstrato() == 2) {
							mt ="Estos son los beneficios que reciben usted y su familia \n\n";
							bono = cabeza[i].getSalario() / 2;
							bonos = bonos + bono;
							mt += "Recibe un bono por el valor de "+bono+" pesos, ademas el siguiente mercado";
							ob.mostrarDatos(mt);
							for (int t = 0; t < 20; t++) {
								if (edades[t][i] < 18 && edades[t][i] > 0) {
									menores++;
								}
							}
							if (menores > 2 && cabeza[i].getCant() > 4) {
								mostrar_mercadosadicional();
							}else {	
								if (!cabeza[i].isEstado()) {
									ob.mostrarDatos("Usted y su familia aplicaban para un mercado, pero en el momento no tenemos existensias");
								} else {
									mostrar_mercados();
								}

							}
						} else {
							if (cabeza[i].getEstrato() == 3) {
								mt ="Estos son los beneficios que reciben usted y su familia \n\n";
								bono = cabeza[i].getSalario() * 0.3;
								mt += "Recibe un bono por el valor de "+bono+" pesos";
								bonos = bonos + bono;
								ob.mostrarDatos(mt);
								for (int t = 0; t < 20; t++) {
									if (edades[t][i] < 18 && edades[t][i] > 0) {
										menores++;
									}
								}
								if (menores > 2 && cabeza[i].getCant() > 4) {
									adicional();
								} else {
									if (!cabeza[i].isEstado()) {
										ob.mostrarDatos("Usted y su familia aplicaban para un mercado, pero en el momento no tenemos existensias");
									}
								}
							}
						}
		
			//
		} 
		}
		if (w = false) {
			ob.mostrarDatos("La cedula que ingreso no esta registrada");
		}
		re = ob.pedirEntero("Si desea consultar otra persona escriba 1");
		} while (re == 1);
	}
}
