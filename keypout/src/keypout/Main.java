package keypout;

import java.util.ArrayList;

import javax.swing.*;

public class Main {
	
	static public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static public ArrayList<Zona> zonas = new ArrayList<Zona>();

	public static void main(String[] args) {
		
		JFrame vP = new ventanas.VentanaPrincipal();
		vP.setVisible(true);
		vP.setResizable(false);
		
	}
	
}