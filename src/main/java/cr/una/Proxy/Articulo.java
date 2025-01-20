package cr.una.Proxy;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
    private String nombre, descripcion;
    private List<Unidades> presentaciones;
    String ID;


    public Articulo(String ID, String nombre, String descripcion){
        presentaciones = new ArrayList<Unidades>();
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Articulo(String ID, String nombre, String descripcion, List<Unidades> presentaciones){
        this.presentaciones = presentaciones;
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Unidades> getPresentaciones() {
        return presentaciones;
    }

    public String getID() {
        return ID;
    }
}
