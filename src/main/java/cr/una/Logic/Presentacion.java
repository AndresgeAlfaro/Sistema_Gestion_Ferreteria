package cr.una.Logic;

import java.util.ArrayList;
import java.util.List;

public class Presentacion {
    private String unidad;
    private int existencia;
    private double compra,venta, cantidad;


    public Presentacion(String unidad, double cantidad, double compra, double venta, int existencia) {
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.compra = compra;
        this.venta = venta;
        this.existencia = existencia;
    }

    @Override
    public String toString() {return cantidad+" "+ getUnit() +" - Precio : "+venta+'$';}

    public String getUnidad() {
        return unidad;
    }

    public String getUnit(){
        return switch (Integer.parseInt(unidad)) {
            case 0 -> "L";
            case 1 -> "ml";
            case 2 -> "m";
            case 3 -> "cm";
            case 4 -> "kg";
            case 5 -> "g";
            case 6 -> "Pie";
            case 7 -> "Pulgada";
            default -> "";
        };
    }
    public double getCantidad() {
        return cantidad;
    }

    public double getCompra() {
        return compra;
    }
    public double getVenta() {
        return venta;
    }
    public int getExistencia() {
        return existencia;
    }
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
}
