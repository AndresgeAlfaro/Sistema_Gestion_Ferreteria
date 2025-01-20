package cr.una.Logic;

import java.util.ArrayList;
import java.util.List;

public class Subcategoria {
    private String nombre, descripcion;
    private List<Articulo> articulos;
    String ID;


    public Subcategoria(String ID, String nombre, String descripcion){
        articulos = new ArrayList<Articulo>();
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Subcategoria(String ID, String nombre, String descripcion, List<Articulo> articulos){
        this.articulos = articulos;
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

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public String getID() {
        return ID;
    }
}
