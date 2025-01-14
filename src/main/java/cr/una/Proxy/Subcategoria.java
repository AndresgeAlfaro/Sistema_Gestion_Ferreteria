package cr.una.Proxy;

import java.util.List;

public class Subcategoria {
    private int ID;
    private String nombre;
    private String descripcion;
    private List<Articulo> Articulos;

    public Subcategoria(int ID, String nombre, String descripcion){
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

   public Subcategoria(int ID, String nombre, String descripcion, List<Articulo> Articulos) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.Articulos = Articulos;
    }

    public int getID() { return ID; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public List<Articulo> getArticulos() { return Articulos; }

    public void setID(int ID) { this.ID = ID; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setArticulos(List<Articulo> Articulos) { this.Articulos = Articulos; }

    public void addArticulo(Articulo articulo) {
        Articulos.add(articulo);
    }
    public boolean isEmpty() {
        return Articulos.isEmpty();
    }

}
