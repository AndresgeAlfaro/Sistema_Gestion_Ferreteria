package cr.una.Data;

import cr.una.Proxy.Categoria;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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

    public void setCategorias(List<Categoria> categorias) throws ParserConfigurationException, TransformerException {
        Categorias = categorias;

        XMLPersistent source = new XMLPersistent();
        try {
            source.guardarCategorias(Categorias);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public void LoadXML(){
        XMLPersistent source = new XMLPersistent();
        source.cargarCategorias();
        Categorias = source.getCategorias();
    }

}
