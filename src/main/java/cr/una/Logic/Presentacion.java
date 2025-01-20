package cr.una.Logic;

import java.util.ArrayList;
import java.util.List;

public class Presentacion {
    private String unidad, cantidad;

    public Presentacion(String unidad, String cantidad){
        this.unidad = unidad;
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getCantidad() {
        return cantidad;
    }
}
