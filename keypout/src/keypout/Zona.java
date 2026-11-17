package keypout;

import java.util.List;

public class Zona {

	private static int ids = 1;
	
    private int id;
    private String nombre;
    private String descripcion;
    private List<Permiso> permisos;

    public Zona(String nombre, String descripcion) {
    	this.id = ids;
        this.nombre = nombre;
        this.descripcion = descripcion;
        ids++;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public void setDescripcion(String desc) {
    	this.descripcion = desc;
    }
}
