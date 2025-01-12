package cr.una.Proxy;

import java.util.List;

public class Articulo {
    private int ID;
    private String nombre;
    private String descripcion;
    //private List<Presentacion> Presentaciones;

    public Articulo(int ID, String nombre, String descripcion) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        //this.Presentaciones = Presentaciones;
    }

    public int getID() { return ID; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    //public List<Presentacion> getPresentaciones() { return Presentaciones; }

    public void setID(int ID) { this.ID = ID; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    //public void setPresentaciones(List<Presentacion> Presentaciones) { this.Presentaciones = Presentaciones; }

}