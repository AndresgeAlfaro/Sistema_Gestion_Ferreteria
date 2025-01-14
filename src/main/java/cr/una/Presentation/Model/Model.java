package cr.una.Presentation.Model;

import cr.una.Data.Data;
import cr.una.Proxy.Categoria;

import java.util.List;

public class Model {
    private Data Categorias;

    public Model() {
        Categorias = new Data();
        Categorias.LoadXML();
    }

    public Data getCategorias() { return Categorias; }

    public void setCategorias(Data Categorias) { this.Categorias = Categorias; }

}