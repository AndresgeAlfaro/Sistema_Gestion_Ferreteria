package cr.una.Logic;

import cr.una.Data.Data;
import cr.una.Proxy.Categoria;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.List;

public class Logic {

    public List<Categoria> getCategorias() throws ParserConfigurationException, TransformerException {
        Data data = new Data();
        data.LoadXML();
        return data.getCategorias();
    }

    public void SaveCategorias(List<Categoria> categorias){
        Data data = new Data();
        try {
            data.setCategorias(categorias);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

}
