package cr.una.Model;

import java.util.List;

public class Articulo {
    private String ID;
    private String Nombre;
    private String Descripcion;
    private List<Presentacion> Presentaciones;

    Articulo(String ID, String Nombre, String Descripcion, List<Presentacion> Presentaciones) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Presentaciones = Presentaciones;
    }

    public String getID() { return ID; }
    public String getNombre() { return Nombre; }
    public String getDescripcion() { return Descripcion; }
    public List<Presentacion> getPresentaciones() { return Presentaciones; }

    public void setID(String ID) { this.ID = ID; }
    public void setNombre(String Nombre) { this.Nombre = Nombre; }
    public void setDescripcion(String Descripcion) { this.Descripcion = Descripcion; }
    public void setPresentaciones(List<Presentacion> Presentaciones) { this.Presentaciones = Presentaciones; }

}