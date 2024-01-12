package VISTA;

import javax.swing.JOptionPane;

//Pedir datos
public class InOut {
public String pedirString (String m) {
	 return JOptionPane.showInputDialog (m);
}

public int pedirEntero (String m) {
	 return Integer.parseInt (JOptionPane.showInputDialog (m));
} 
public float pedirFloat (String m) {
	 return Float.parseFloat (JOptionPane.showInputDialog (m));
} 
//Mostrar datos
public void mostrarDatos (String m) {
	 JOptionPane.showMessageDialog (null,m);
}

}
