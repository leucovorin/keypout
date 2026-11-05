package keypout;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
		
		contenedor = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridx = 0;
		gbc.weightx = 0.20;
		contenedor.add(izquierda, gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 0.80;
		contenedor.add(derecha, gbc);
	
		contenedor.setVisible(true);
		add(contenedor);
		
	}

	private JPanel panelBienvenida() {
		
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
    		"<html><div>"
    		+ "Tu seguridad,<br><span style=\"font-size: 30px; font-weight: normal;\">en buenas manos"
    		+ "</div></html>",
			SwingConstants.CENTER
		);

		texto.setFont(new Font("Monospaced", Font.BOLD, 85));
		bienvenida.add(texto);
		
		// AÑADIMOS ELEMENTOS AL PANEL Y DEVOLVEMOS panelBienvenida.
		jp.add(logoYTexto);
		jp.add(Box.createVerticalStrut(200));
		jp.add(bienvenida);
		jp.setVisible(true);
		return jp;
		
	}
	
	private JPanel panelInicio() {

	    JPanel jp = new JPanel();
	    jp.setBackground(new Color(255,255,255));
	    jp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

	    JLabel titulo = new JLabel("Inicia sesión");
	    titulo.setFont(new Font("Monospaced", Font.BOLD, 32));
	    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

	    // CREAMOS EL CAMPO DE TEXTO PARA EL NOMBRE DE USUARIO
	    
	    JTextField username = new JTextField();
	    username.setMaximumSize(new Dimension(300, 40));
	    username.setFont(new Font("Monospaced", Font.PLAIN, 16));
	    username.setText("Nombre de usuario");
	    
	    username.addFocusListener(new FocusAdapter() {
	    	@Override
	    	public void focusGained(FocusEvent e) {
	    		if(username.getBackground().equals(Color.red)) {
	    			username.setBackground(Color.white);
	    			username.setText("");
	    		}
	    		if(username.getText().equals("Nombre de usuario")) {
	    			username.setText("");
	    		}
	    	}
	    	
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    		if(username.getText().isEmpty()) {
	    			username.setText("Nombre de usuario");
	    		}
	    	}
	    });
	    
	    // CREAMOS EL CAMPO DE TEXTO PARA LA CONTRASEÑA
	    
	    JTextField password = new JTextField();
	    password.setMaximumSize(new Dimension(300, 40));
	    password.setFont(new Font("Monospaced", Font.PLAIN, 16));
	    password.setText("Contraseña");
	    
	    password.addFocusListener(new FocusAdapter() {
	    	@Override 
	    	public void focusGained(FocusEvent e) {
	    		if(password.getBackground().equals(Color.red)) {
	    			password.setBackground(Color.white);
	    			password.setText("");
	    		}
	    		
	    		if(password.getText().equals("Contraseña")) {
	    			password.setText("");
	    		}
	    	}
	    	
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    		if(password.getText().equals("")) {
	    			password.setText("Contraseña");
	    		}
	    	}
	    });
	    
	    // CREAMOS LOS BOTONES
	    
	    JButton login = new JButton("Iniciar sesión");
	    login.setMaximumSize(new Dimension(300, 40));
	    login.setFont(new Font("Monospaced", Font.PLAIN, 16));
	    login.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    login.addActionListener(e -> {
	    	if(username.getText().equals("1") && password.getText().equals("1")) {
	    		
	    		VentanaPoli poli = new VentanaPoli();
	    		
	    		contenedor.removeAll();
	    		contenedor.setLayout(new BorderLayout());
	    		contenedor.add(poli.getContenedor(), BorderLayout.CENTER);
	    		
	    		contenedor.revalidate();
	    		contenedor.repaint();
	    		
	    	} else {
	    		username.setBackground(Color.red);
	    		password.setBackground(Color.red);
	    	}
	    });
	    
	    JLabel t = new JLabel("O también puedes");
	    t.setFont(new Font("Monospaced", Font.BOLD, 12));
	    t.setAlignmentX(CENTER_ALIGNMENT);
	    
	    JButton signup = new JButton("Crear nuevo perfil");
	    signup.setMaximumSize(new Dimension(300, 40));
	    signup.setFont(new Font("Monospaced", Font.PLAIN, 16));
	    signup.setAlignmentX(Component.CENTER_ALIGNMENT);

	    jp.add(Box.createVerticalGlue());
	    jp.add(titulo);
	    jp.add(Box.createVerticalStrut(25));
	    jp.add(username);
	    jp.add(Box.createVerticalStrut(15));
	    jp.add(password);
	    jp.add(Box.createVerticalStrut(15));
	    jp.add(login);
	    jp.add(Box.createVerticalStrut(15));
	    jp.add(t);
	    jp.add(Box.createVerticalStrut(15));
	    jp.add(signup);
	    jp.add(Box.createVerticalGlue());
	    
	   

	    jp.setVisible(true);
		
	    jp.setFocusable(true);
	    SwingUtilities.invokeLater(() -> jp.requestFocusInWindow());
	    
		return jp;
	}
	
	
}

