package keypout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VentanaPoli extends JFrame {

final private JPanel contenedor;
	
	public VentanaPoli() {
		
		setTitle("KeyPout");
		setSize(1400, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel arriba = panelArriba();
		JPanel abajo = panelAbajo();

		contenedor = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridy = 0;
		gbc.weighty = 0.10;
		contenedor.add(arriba, gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 0.90;
		contenedor.add(abajo, gbc);
	
		contenedor.setVisible(true);
		add(contenedor);
		
	}
	
	private JPanel panelArriba() {
		JPanel jp = new JPanel();
		jp.setBorder(new LineBorder(Color.black));
		jp.setVisible(true);
		return jp;
	}
	
	private JPanel panelAbajo() {
		JPanel jp = new JPanel();
		jp.setBorder(new LineBorder(Color.black));
		jp.setVisible(true);
		return jp;
	}
	
	public JPanel getContenedor() {
	    return contenedor;
	}
	
}
