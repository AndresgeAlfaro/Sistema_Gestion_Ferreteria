package cr.una.Model;

import java.util.List;

public class Categoria {
    private String ID;
    private String Nombre;
    private String Descripcion;
    private List<Subcategoria> Subcategorias;

    Categoria(String ID, String Nombre, String Descripcion, List<Subcategoria> Subcategorias) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Subcategorias = Subcategorias;
    }

    public String getID() { return ID; }
    public String getNombre() { return Nombre; }
    public String getDescripcion() { return Descripcion; }
    public List<Subcategoria> getSubcategorias() { return Subcategorias; }

    public void setID(String ID) { this.ID = ID; }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }
    public void setDescripcion(String Descripcion) { this.Descripcion = Descripcion; }
    public void setSubcategorias(List<Subcategoria> Subcategorias) { this.Subcategorias = Subcategorias; }

}
