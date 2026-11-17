package ventanas;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VentanaPoli extends JFrame {
	
	Color rosita = new Color(248,204,202);

	Font fuente = new Font("Monospaced", Font.PLAIN, 16);
	
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
		gbc.weighty = 0.066;
		contenedor.add(arriba, gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 0.934;
		contenedor.add(abajo, gbc);
	
		contenedor.setVisible(true);
		add(contenedor);
		
	}
	
	private JPanel panelArriba() {

		JPanel jp = new JPanel(new GridBagLayout());
	    jp.setBorder(new LineBorder(Color.BLACK));
	    
	    URL ruta = getClass().getResource("/imagenes/casita.png");
	    ImageIcon icono = new ImageIcon(ruta);
	    Image imagen = icono.getImage().getScaledInstance(
	    	50, 50, Image.SCALE_SMOOTH
	    );

	    JButton home = new JButton(new ImageIcon(imagen));
	    
	    home.setPreferredSize(new Dimension(0, 20));
	    home.setMinimumSize(new Dimension(0, 20));
	    home.setMaximumSize(new Dimension(0, 20));
	    home.setContentAreaFilled(false);
	    home.setFocusPainted(false);
	    
	    
	    JButton usuarios = new JButton("Usuarios");
	    
	    usuarios.addActionListener(e -> {
	    	
	    	VentanaUsuarios vU = new VentanaUsuarios();
	    	
	    	VentanaPrincipal.contenedor.removeAll();
	    	VentanaPrincipal.contenedor.setLayout(new BorderLayout());
	    	VentanaPrincipal.contenedor.add(vU.getContenedor(), BorderLayout.CENTER);
	    	
	    	VentanaPrincipal.contenedor.revalidate();
	    	VentanaPrincipal.contenedor.repaint();
	    	
	    });
	    
	    
	    JButton zonas = new JButton("Zonas");
	    
	    zonas.addActionListener(e -> {
	    	
	    	VentanaZonas vZ = new VentanaZonas();
	    	
	    	VentanaPrincipal.contenedor.removeAll();
	    	VentanaPrincipal.contenedor.setLayout(new BorderLayout());
	    	VentanaPrincipal.contenedor.add(vZ.getContenedor(), BorderLayout.CENTER);
	    	
	    	VentanaPrincipal.contenedor.revalidate();
	    	VentanaPrincipal.contenedor.repaint();
	    	
	    });
	    
	    JButton notifs = new JButton("NOTIFICACIONES");
	    
	    
	    ruta = getClass().getResource("/imagenes/perfil.png");
	    icono = new ImageIcon(ruta);
	    imagen = icono.getImage().getScaledInstance(
	    	50, 50, Image.SCALE_SMOOTH
	    );
	    
	    JButton perfil = new JButton(new ImageIcon(imagen));
	    
	    perfil.setPreferredSize(new Dimension(0, 20));
	    perfil.setMinimumSize(new Dimension(0, 20));
	    perfil.setMaximumSize(new Dimension(0, 20));
	    perfil.setContentAreaFilled(false);
	    perfil.setFocusPainted(false);

	    

	    home.setFont(fuente);
	    usuarios.setFont(fuente);
	    zonas.setFont(fuente);
	    notifs.setFont(fuente);
	    perfil.setFont(fuente);

	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.weighty = 1.0;

	    gbc.gridx = 0;
	    gbc.weightx = 1.0;
	    jp.add(home, gbc);
	    gbc.gridx = 1;
	    jp.add(usuarios, gbc);
	    gbc.gridx = 2;
	    jp.add(zonas, gbc);
	    gbc.gridx = 3;
	    jp.add(notifs, gbc);
	    gbc.gridx = 4;
	    jp.add(perfil, gbc);

	    return jp;
		
	}
	
	private JPanel panelAbajo() {

		JPanel jp = new JPanel(new BorderLayout());

		jp.setBackground(rosita);
	    jp.setBorder(BorderFactory.createEmptyBorder(70, 30, 20, 30));

	    JLabel t = new JLabel("Acciones");
	    t.setFont(fuente);

	    // Panel interior con borde
	    JPanel interior = new JPanel(new BorderLayout());
	    interior.setBorder(new LineBorder(Color.BLACK));

	    // Panel que contendrá las filas
	    JPanel lista = new JPanel();
	    lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

	    lista.add(crearFila("Acción de prueba"));

	    // Scroll de la lista
	    JScrollPane scroll = new JScrollPane(lista);

	    scroll.setVerticalScrollBarPolicy(
	        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
	    );

	    scroll.setHorizontalScrollBarPolicy(
	        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	    );

	    interior.add(scroll, BorderLayout.CENTER);

	    jp.add(t, BorderLayout.NORTH);
	    jp.add(interior, BorderLayout.CENTER);

	    return jp;
		
	}
	
	private JPanel crearFila(String texto) {

	    JPanel fila = new JPanel(new BorderLayout());

	    fila.setBorder(new LineBorder(Color.BLACK));

	    JLabel etiqueta = new JLabel(texto);
	    etiqueta.setFont(fuente);

	    JButton boton = new JButton("Editar");
	    
	    boton.addActionListener(e -> {
	    	abrirPopup(etiqueta.getText());
	    });

	    fila.add(etiqueta, BorderLayout.CENTER);

	    fila.add(boton, BorderLayout.EAST);

	    fila.setPreferredSize(new Dimension(500, 50));
	    fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

	    return fila;
	}
	
	private void abrirPopup(String s) {

	    JDialog popup = new JDialog(this, "Detalles acción", true);

	    popup.setSize(1000, 600);
	    popup.setLocationRelativeTo(this);
	    popup.setResizable(false);
	    popup.setLayout(new BorderLayout());

	    JPanel contenido = new JPanel(new BorderLayout());
	    contenido.setBackground(rosita);
	    contenido.setBorder(
	        BorderFactory.createEmptyBorder(20, 30, 20, 30)
	    );

	    JPanel interior = new JPanel(new BorderLayout());
	    interior.setBorder(new LineBorder(Color.BLACK));

	    JLabel titulo = new JLabel("Acción: " + s);
	    titulo.setFont(fuente);

	    contenido.add(titulo, BorderLayout.NORTH);

	    contenido.add(interior, BorderLayout.CENTER);

	    popup.add(contenido, BorderLayout.CENTER);

	    popup.setVisible(true);
	}
	
	public JPanel getContenedor() {
	    return contenedor;
	}
	
}
