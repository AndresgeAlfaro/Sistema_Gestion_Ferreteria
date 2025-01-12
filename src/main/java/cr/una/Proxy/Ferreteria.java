package cr.una.Proxy;

import java.util.List;

public class Ferreteria {
    private String Nombre;
    private List<Categoria> Categorias;

    Ferreteria(String Nombre, List<Categoria> Categorias) {
        this.Nombre = Nombre;
        this.Categorias = Categorias;
    }

    public String getNombre() { return Nombre; }
    public List<Categoria> getCategorias() { return Categorias; }

    public void setNombre(String Nombre) { this.Nombre = Nombre; }
    public void setCategorias(List<Categoria> Categorias) { this.Categorias = Categorias; }
}
