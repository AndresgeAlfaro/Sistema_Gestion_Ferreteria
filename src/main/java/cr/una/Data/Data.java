package cr.una.Data;

import cr.una.Logic.Categoria;
import cr.una.Logic.Medida;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Medida> medidas;
    private List<Categoria> Categorias;

    public Data() //Constructor
    {
        Categorias=new ArrayList<>();
        medidas=new ArrayList<>();
    }

    public List<Categoria> getCategorias() {
        return Categorias;
    }

    public void setCategorias(List<Categoria> Categorias) {
        this.Categorias = Categorias;
    }

    public List<Medida> getMedidas() {return medidas;}

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }
}
