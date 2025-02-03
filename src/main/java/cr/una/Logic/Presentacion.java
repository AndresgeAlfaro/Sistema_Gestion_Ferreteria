package cr.una.Logic;

import java.util.ArrayList;
import java.util.List;

public class Presentacion {
    private String unidad, cantidad;
    private double compra,venta;

    public Presentacion(String unidad, String cantidad, double compra, double venta) {
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.compra = compra;
        this.venta = venta;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public double getCompra() {
        return compra;
    }
    public double getVenta() {
        return venta;
    }
}
