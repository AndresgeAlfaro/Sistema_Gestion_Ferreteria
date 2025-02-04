package cr.una.Logic;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
    private String nombre, descripcion;
    private List<Presentacion> presentaciones;
    String ID;


    public Articulo(String ID, String nombre, String descripcion){
        presentaciones = new ArrayList<Presentacion>();
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Articulo(String ID, String nombre, String descripcion, List<Presentacion> presentaciones){
        this.presentaciones = presentaciones;
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {return nombre;}

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Presentacion> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(List<Presentacion> presentaciones) {
        this.presentaciones = presentaciones;
    }

    public String getID() {
        return ID;
    }
}
