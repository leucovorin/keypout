package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import keypout.Main;
import keypout.Zona;

public class VentanaZonas extends JFrame {

	Color rosita = new Color(248,204,202);

	Font fuente = new Font("Monospaced", Font.PLAIN, 16);
	
final private JPanel contenedor;
	
	public VentanaZonas() {
		
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
		gbc.weighty = 0.07;
		contenedor.add(arriba, gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 0.93;
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
	    
	    home.addActionListener(e -> {
	    	
	    	VentanaPoli poli = new VentanaPoli();
    		
    		contenedor.removeAll();
    		contenedor.setLayout(new BorderLayout());
    		contenedor.add(poli.getContenedor(), BorderLayout.CENTER);
    		
    		contenedor.revalidate();
    		contenedor.repaint();
    		
	    });
	    
	    
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

	    JLabel t = new JLabel("Zonas");
	    t.setFont(fuente);

	    JPanel interior = new JPanel(new BorderLayout());
	    interior.setBorder(new LineBorder(Color.BLACK));

	    JPanel lista = new JPanel();
	    lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

	    // Mostrar todas las zonas existentes
	    for (Zona zona : Main.zonas) {
	        lista.add(crearFila(zona));
	    }

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

	    JPanel panelBoton = new JPanel(new BorderLayout());
	    panelBoton.setOpaque(false);
	    panelBoton.setBorder(
	        BorderFactory.createEmptyBorder(15, 0, 0, 0)
	    );

	    JButton anadirZona = new JButton("Añadir zona");

	    anadirZona.addActionListener(e -> {

	        Zona z = abrirPopupForm();

	        if (z != null) {
	            lista.add(crearFila(z));
	            lista.revalidate();
	            lista.repaint();
	        }

	    });

	    panelBoton.add(anadirZona, BorderLayout.WEST);

	    jp.add(panelBoton, BorderLayout.SOUTH);

	    return jp;
	}
	
	private JPanel crearFila(Zona zona) {

	    JPanel fila = new JPanel(new BorderLayout());
	    fila.setBorder(new LineBorder(Color.BLACK));

	    JLabel etiqueta = new JLabel(zona.getNombre());
	    etiqueta.setFont(fuente);

	    JButton boton = new JButton("Editar");

	    boton.addActionListener(e -> {
	        abrirPopup(zona, etiqueta);
	    });

	    fila.add(etiqueta, BorderLayout.CENTER);
	    fila.add(boton, BorderLayout.EAST);

	    fila.setPreferredSize(new Dimension(500, 50));
	    fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

	    return fila;
	}
	
	private void abrirPopup(Zona zona, JLabel etiqueta) {

	    JDialog popup = new JDialog(this, "Editar zona", true);

	    popup.setSize(600, 400);
	    popup.setLocationRelativeTo(this);
	    popup.setResizable(false);
	    popup.setLayout(new BorderLayout());

	    JPanel contenido = new JPanel(new BorderLayout());
	    contenido.setBackground(rosita);
	    contenido.setBorder(
	        BorderFactory.createEmptyBorder(20, 30, 20, 30)
	    );

	    JPanel interior = new JPanel(new GridLayout(4, 1, 10, 10));
	    interior.setBackground(rosita);
	    interior.setBorder(
	        BorderFactory.createEmptyBorder(20, 20, 20, 20)
	    );

	    JLabel lblNombre = new JLabel("Nombre de la zona:");
	    JTextField txtNombre = new JTextField(zona.getNombre());

	    JLabel lblDescripcion = new JLabel("Descripción:");
	    JTextField txtDescripcion = new JTextField(zona.getDescripcion());

	    JButton btnGuardar = new JButton("Guardar cambios");

	    btnGuardar.addActionListener(e -> {

	        String nombre = txtNombre.getText().trim();
	        String descripcion = txtDescripcion.getText().trim();

	        if (nombre.isEmpty() || descripcion.isEmpty()) {
	            JOptionPane.showMessageDialog(
	                popup,
	                "Rellena todos los campos"
	            );
	            return;
	        }

	        // Actualizar el objeto original
	        zona.setNombre(nombre);
	        zona.setDescripcion(descripcion);

	        // Actualizar el texto de la fila
	        etiqueta.setText(nombre);

	        JOptionPane.showMessageDialog(
	            popup,
	            "Zona actualizada correctamente"
	        );

	        popup.dispose();
	    });

	    interior.add(lblNombre);
	    interior.add(txtNombre);
	    interior.add(lblDescripcion);
	    interior.add(txtDescripcion);

	    contenido.add(interior, BorderLayout.CENTER);
	    contenido.add(btnGuardar, BorderLayout.SOUTH);

	    popup.add(contenido, BorderLayout.CENTER);

	    popup.setVisible(true);
	}
	
	private Zona abrirPopupForm() {

	    JDialog popup = new JDialog(this, "Nueva zona", true);
	    popup.setSize(500, 350);
	    popup.setLocationRelativeTo(this);
	    popup.setResizable(false);
	    popup.setLayout(new BorderLayout());

	    JPanel contenido = new JPanel(new BorderLayout());
	    contenido.setBackground(rosita);
	    contenido.setBorder(
	        BorderFactory.createEmptyBorder(20, 30, 20, 30)
	    );

	    JPanel interior = new JPanel(new GridLayout(5, 1, 10, 10));
	    interior.setBackground(rosita);
	    interior.setBorder(
	        BorderFactory.createEmptyBorder(20, 20, 20, 20)
	    );

	    // Nombre
	    JLabel lblNombre = new JLabel("Nombre de la zona:");
	    JTextField txtNombre = new JTextField();

	    // Descripción
	    JLabel lblDescripcion = new JLabel("Descripción:");
	    JTextField txtDescripcion = new JTextField();

	    JButton btnGuardar = new JButton("Guardar");

	    Zona[] nuevaZona = {null};

	    btnGuardar.addActionListener(e -> {

	        String nombre = txtNombre.getText().trim();
	        String descripcion = txtDescripcion.getText().trim();

	        if (nombre.isEmpty() || descripcion.isEmpty()) {
	            JOptionPane.showMessageDialog(
	                popup,
	                "Introduce el nombre y la descripción"
	            );
	            return;
	        }

	        Zona nueva = new Zona(nombre, descripcion);

	        Main.zonas.add(nueva);

	        nuevaZona[0] = nueva;

	        JOptionPane.showMessageDialog(
	            popup,
	            "Zona creada correctamente"
	        );

	        popup.dispose();
	    });

	    interior.add(lblNombre);
	    interior.add(txtNombre);
	    interior.add(lblDescripcion);
	    interior.add(txtDescripcion);
	    interior.add(btnGuardar);

	    contenido.add(interior, BorderLayout.CENTER);
	    popup.add(contenido, BorderLayout.CENTER);

	    popup.setVisible(true);

	    return nuevaZona[0];
	}
	
	public JPanel getContenedor() {
	    return contenedor;
	}
	
}
