package cr.una.Data;

import cr.una.Logic.Categoria;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Categoria> Categorias;

    public Data() //Constructor
    {
        Categorias=new ArrayList<>();
    }

    public List<Categoria> getCategorias() {
        return Categorias;
    }

    public void setCategorias(List<Categoria> Categorias) {
        this.Categorias = Categorias;
    }

}
