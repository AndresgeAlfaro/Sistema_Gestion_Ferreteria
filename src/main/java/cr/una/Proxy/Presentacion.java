package cr.una.Proxy;

public class Presentacion {
    private int Unidad;      //Cantidad de unidad de medida
    private String Medida;   //En caso de que sean galones/cajas/envases
    private String Cantidad;

    Presentacion(int Unidad, String Medida, String Cantidad) {
        this.Unidad = Unidad;
        this.Medida = Medida;
        this.Cantidad = Cantidad;
    }

    public int getUnidad() { return Unidad; }
    public String getMedida() { return Medida; }
    public String getCantidad() { return Cantidad; }

    public void setUnidad(int Unidad) { this.Unidad = Unidad; }
    public void setMedida(String Medida) { this.Medida = Medida; }
    public void setCantidad(String Cantidad) { this.Cantidad = Cantidad; }

}

