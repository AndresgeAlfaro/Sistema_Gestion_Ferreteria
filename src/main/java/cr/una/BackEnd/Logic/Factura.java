package cr.una.BackEnd.Logic;

import java.io.Serializable;

public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    private Categoria categoria;
    private Subcategoria subcategoria;
    private Articulo articulo;
    private Presentacion presentacion;
    private int cantidad;
    public Factura(Categoria categoria, Subcategoria subcategoria, Articulo articulo, Presentacion presentacion, int cantidad) {
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.articulo = articulo;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public Subcategoria getSubcategoria() {
        return subcategoria;
    }
    public Articulo getArticulo() {
        return articulo;
    }
    public Presentacion getPresentacion() {
        return presentacion;
    }
    public int getCantidad() {
        return cantidad;
    }
}
