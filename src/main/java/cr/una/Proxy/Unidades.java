package cr.una.Proxy;

public class Unidades {
    private String unidad, cantidad;

    public Unidades(String unidad, String cantidad){
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
