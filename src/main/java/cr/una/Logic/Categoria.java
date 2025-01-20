package cr.una.Logic;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre, descripcion;
    private List<Subcategoria> subcategorias;
    String ID;


    public Categoria(String ID, String nombre, String descripcion){
        subcategorias = new ArrayList<Subcategoria>();
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria(String ID, String nombre, String descripcion, List<Subcategoria> subcategorias){
        this.subcategorias = subcategorias;
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Categoria(){
        this("","","");
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }

    public String getID() {
        return ID;
    }
}
