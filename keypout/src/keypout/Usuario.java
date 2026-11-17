package keypout;

import java.util.List;

public class Usuario {

	private static int ids = 1;
	
	private int id;
	private String nombre;
	private String email;
	private String contrasena;
	private List<Permiso> permisos;
	
	public Usuario(String nombre, String email, String contrasena) {
		this.id = ids;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
		ids++;
	}
	
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }
	
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setContrasena(String contrasena) {
    	this.contrasena = contrasena;
    }
}
