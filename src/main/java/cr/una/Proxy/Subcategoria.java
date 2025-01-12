package cr.una.Proxy;

import java.util.List;

public class Subcategoria {
    private String ID;
    private String Nombre;
    private String Descripcion;
    private List<Articulo> Articulos;

    Subcategoria(String ID, String Nombre, String Descripcion, List<Articulo> Articulos) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Articulos = Articulos;
    }

    public String getID() { return ID; }
    public String getNombre() { return Nombre; }
    public String getDescripcion() { return Descripcion; }
    public List<Articulo> getArticulos() { return Articulos; }

    public void setID(String ID) { this.ID = ID; }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }
    public void setDescripcion(String Descripcion) { this.Descripcion = Descripcion; }
    public void setArticulos(List<Articulo> Articulos) { this.Articulos = Articulos; }

}
