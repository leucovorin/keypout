package ventanas;


import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.LineBorder;
import keypout.Main;
import keypout.Usuario;


public class VentanaUsuarios extends JFrame {

    Color rosita = new Color(248,204,202);

    Font fuente = new Font("Monospaced", Font.PLAIN, 16);

    final private JPanel contenedor;

    public VentanaUsuarios() {

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

        JLabel t = new JLabel("Usuarios");
        t.setFont(fuente);

        JPanel interior = new JPanel(new BorderLayout());
        interior.setBorder(new LineBorder(Color.BLACK));

        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.Y_AXIS));

        // Mostrar todos los usuarios existentes
        for (Usuario usuario : Main.usuarios) {
            lista.add(crearFila(usuario));
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

        JButton anadirUsuarios = new JButton("Añadir usuario");

        anadirUsuarios.addActionListener(e -> {

            Usuario nuevo = abrirPopupForm();

            if (nuevo != null) {
                lista.add(crearFila(nuevo));
                lista.revalidate();
                lista.repaint();
            }

        });

        panelBoton.add(anadirUsuarios, BorderLayout.WEST);

        jp.add(panelBoton, BorderLayout.SOUTH);

        return jp;
    }

    private JPanel crearFila(Usuario usuario) {

        JPanel fila = new JPanel(new BorderLayout());

        fila.setBorder(new LineBorder(Color.BLACK));

        JLabel etiqueta = new JLabel(usuario.getNombre());
        etiqueta.setFont(fuente);

        JButton boton = new JButton("Editar");

        boton.addActionListener(e -> {
            abrirPopup(usuario, etiqueta);
        });

        fila.add(etiqueta, BorderLayout.CENTER);
        fila.add(boton, BorderLayout.EAST);

        fila.setPreferredSize(new Dimension(500, 50));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        return fila;
    }

    private void abrirPopup(Usuario usuario, JLabel etiqueta) {

        JDialog popup = new JDialog(this, "Editar usuario", true);

        popup.setSize(600, 450);
        popup.setLocationRelativeTo(this);
        popup.setResizable(false);
        popup.setLayout(new BorderLayout());

        JPanel contenido = new JPanel(new BorderLayout());
        contenido.setBackground(rosita);
        contenido.setBorder(
            BorderFactory.createEmptyBorder(20, 30, 20, 30)
        );

        JPanel interior = new JPanel(new GridLayout(7, 1, 10, 10));
        interior.setBackground(rosita);
        interior.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(usuario.getNombre());

        // Email
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(usuario.getEmail());

        // Contraseña
        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField txtPassword =
            new JPasswordField(usuario.getContrasena());
        
        JCheckBox mostrar = new JCheckBox("Mostrar contraseña");

        mostrar.setBackground(rosita);

        mostrar.addActionListener(e -> {
            if (mostrar.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('•');
            }
        });

        JButton btnGuardar = new JButton("Guardar cambios");

        btnGuardar.addActionListener(e -> {

            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            String password = new String(txtPassword.getPassword());

            if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                    popup,
                    "Rellena todos los campos"
                );
                return;
            }

            // Actualizar el usuario original
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setContrasena(password);

            // Actualizar el nombre de la fila
            etiqueta.setText(nombre);

            JOptionPane.showMessageDialog(
                popup,
                "Usuario actualizado correctamente"
            );

            popup.dispose();
        });

        interior.add(lblNombre);
        interior.add(txtNombre);
        interior.add(lblEmail);
        interior.add(txtEmail);
        interior.add(lblPassword);
        interior.add(txtPassword);
        interior.add(mostrar);

        contenido.add(interior, BorderLayout.CENTER);
        contenido.add(btnGuardar, BorderLayout.SOUTH);

        popup.add(contenido, BorderLayout.CENTER);

        popup.setVisible(true);
    }
    
    
    // Devuelve el nombre del nuevo usuario
    private Usuario abrirPopupForm() {

        JDialog popup = new JDialog(this, "Nuevo usuario", true);

        popup.setSize(500, 450);
        popup.setLocationRelativeTo(this);
        popup.setResizable(false);
        popup.setLayout(new BorderLayout());

        JPanel contenido = new JPanel(new BorderLayout());
        contenido.setBackground(rosita);
        contenido.setBorder(
            BorderFactory.createEmptyBorder(20, 30, 20, 30)
        );

        JPanel interior = new JPanel(new GridLayout(8, 1, 10, 10));
        interior.setBackground(rosita);
        interior.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField txtPassword = new JPasswordField();
        
        JCheckBox mostrar = new JCheckBox("Mostrar contraseña");

        mostrar.setBackground(rosita);

        mostrar.addActionListener(e -> {
            if (mostrar.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('•');
            }
        });

        JButton btnGuardar = new JButton("Guardar");

        Usuario[] nuevoUsuario = {null};

        btnGuardar.addActionListener(e -> {

            String nombre = txtNombre.getText().trim();
            String email = txtEmail.getText().trim();
            String password = new String(txtPassword.getPassword());

            if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                    popup,
                    "Rellena todos los campos"
                );
                return;
            }

            Usuario nuevo = new Usuario(nombre, email, password);

            Main.usuarios.add(nuevo);

            nuevoUsuario[0] = nuevo;

            JOptionPane.showMessageDialog(
                popup,
                "Usuario creado correctamente"
            );

            popup.dispose();
        });

        interior.add(lblNombre);
        interior.add(txtNombre);
        interior.add(lblEmail);
        interior.add(txtEmail);
        interior.add(lblPassword);
        interior.add(txtPassword);
        interior.add(mostrar);
        interior.add(btnGuardar);
        

        contenido.add(interior, BorderLayout.CENTER);
        popup.add(contenido, BorderLayout.CENTER);

        popup.setVisible(true);

        return nuevoUsuario[0];
    }

    public JPanel getContenedor() {
        return contenedor;
    }

}
