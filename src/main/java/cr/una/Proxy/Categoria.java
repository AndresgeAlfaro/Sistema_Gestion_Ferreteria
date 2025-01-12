package cr.una.Proxy;

import java.util.*;

public class Categoria {
    private int ID;
    private String nombre;
    private String descripcion;
    private List<Subcategoria> Subcategorias;

    public Categoria(int ID, String nombre, String descripcion){
        Subcategorias = new ArrayList<Subcategoria>();
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

   public Categoria(int ID, String nombre, String descripcion, List<Subcategoria> Subcategorias) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.Subcategorias = Subcategorias;
    }

    public int getID() { return ID; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public List<Subcategoria> getSubcategorias() { return Subcategorias; }

    public void setID(int ID) { this.ID = ID; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setSubcategorias(List<Subcategoria> Subcategorias) { this.Subcategorias = Subcategorias; }

}
