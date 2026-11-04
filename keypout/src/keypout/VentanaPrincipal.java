package keypout;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	
	final private JPanel contenedor;
	
	public VentanaPrincipal() {
		
		setTitle("KeyPout");
		setSize(1400, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel izquierda = panelBienvenida();
		JPanel derecha = panelInicio();

		izquierda.setMinimumSize(new Dimension(0, 0));
		derecha.setMinimumSize(new Dimension(0, 0));
		
		contenedor = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = 0;
		gbc.weightx = 0.55;
		contenedor.add(izquierda, gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 0.45;
		contenedor.add(derecha, gbc);
	
		contenedor.setVisible(true);
		add(contenedor);
		
	}

	public JPanel panelBienvenida() {
		
		Color rosita = new Color(248,204,202);
		
		// CREAMOS panelBienvenida.
		
		JPanel jp = new JPanel();
		jp.setBackground(rosita);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.setBackground(rosita);
		jp.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// CREAMOS UN SUBPANEL PARA EL LOGO Y EL NOMBRE DEL PROGRAMA.
		
		JPanel logoYTexto = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		logoYTexto.setBackground(rosita);
		logoYTexto.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
		logoYTexto.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		URL ruta = getClass().getResource("/imagenes/logo.png");
		
		Image imagenEscalada = new ImageIcon(ruta)
				.getImage()
				.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		
		logoYTexto.add(new JLabel(new ImageIcon(imagenEscalada)));
		JSeparator separador = new JSeparator(SwingConstants.VERTICAL);
		separador.setPreferredSize(new Dimension(10, 90));
		logoYTexto.add(separador);
		logoYTexto.add(Box.createHorizontalStrut(20));
		JLabel titulo = new JLabel("KeyPout");
		titulo.setFont(new Font("Monospaced", Font.BOLD, 45));
		logoYTexto.add(titulo);
		
		// CREAMOS UN SUBPANEL PARA LOS TEXTOS DE BIENVENIDA.
		
		JPanel bienvenida = new JPanel();
		bienvenida.setBackground(rosita);
		
		JLabel texto = new JLabel(
    		"<html><div style='text-align:left;'>"
    		+ "Tu seguridad,<br><span style=\"font-size: 30px; font-weight: normal;\">en buenas manos"
    		+ "</div></html>",
			SwingConstants.CENTER
		);

		texto.setFont(new Font("Monospaced", Font.BOLD, 45));
		bienvenida.add(texto);

		bienvenida.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		// AÑADIMOS ELEMENTOS AL PANEL Y DEVOLVEMOS panelBienvenida.
		jp.add(logoYTexto);
		jp.add(Box.createVerticalStrut(220));
		jp.add(bienvenida);
		jp.setVisible(true);
		jp.setBorder(BorderFactory.createLineBorder(Color.RED));
		return jp;
		
	}
	
	public JPanel panelInicio() {
		JPanel jp = new JPanel();
		jp.setVisible(true);
		jp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return jp;
	}
	
	
}
