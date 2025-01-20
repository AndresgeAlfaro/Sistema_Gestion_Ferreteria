package cr.una.Logic;

import cr.una.Data.Data;
import cr.una.Data.XMLPersistent;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.List;

public class Service {
    private static Service theInstance;
    private XMLPersistent xml;
    private Data data;

    private Service() {
        data = new Data();
        xml = new XMLPersistent();
    }

    public static Service instance(){
        if (theInstance == null){ theInstance = new Service();}
        return theInstance;
    }

    public void cargarXML() throws Exception {
        try{
            data = xml.cargarXML();
        }
        catch(ParserConfigurationException | IOException | SAXException e){
            throw new Exception("Error al cargar los datos");
        }
        catch (Exception e){
            throw e;
        }
    }
    public void guardarXML() throws Exception {
        try{
            xml.guardarXML(data);
        }catch(TransformerConfigurationException | ParserConfigurationException e){
            throw new Exception("Error al guardar los datos");
        }
    }

    //Gets
    public List<Categoria> getCategorias() {
        return data.getCategorias();
    }

    public Categoria readCategoria(Categoria v){ //CAMBIAR A PROBLEMA DE EXAMEN
        Categoria result = data.getCategorias().stream()
                .filter(i->i.getID().equals(v.getID())).findFirst().orElse(null);
        return result;
    }
    public Subcategoria readSubCategoria(Categoria v, Subcategoria subCategoria){ //CAMBIAR A PROBLEMA DE EXAMEN
        Subcategoria result = v.getSubcategorias().stream()
                .filter(i->i.getID().equals(subCategoria.getID())).findFirst().orElse(null);
        return result;
    }
    public Articulo readArticulo(Subcategoria subCategoria, Articulo articulo){ //CAMBIAR A PROBLEMA DE EXAMEN
        Articulo result = subCategoria.getArticulos().stream()
                .filter(i->i.getID().equals(articulo.getID())).findFirst().orElse(null);
        return result;
    }
    public Presentacion readPresentacion(Articulo articulo, Presentacion presentacion){ //CAMBIAR A PROBLEMA DE EXAMEN
        Presentacion result = articulo.getPresentaciones().stream()
                .filter((i->i.getUnidad().equals(presentacion.getUnidad())&&i.getCantidad().equals(presentacion.getCantidad()))).findFirst().orElse(null);
        return result;
    }
    public void guardarCategoria(Categoria categoria) throws Exception {
        if(readCategoria(categoria)!= null){
            throw new Exception("Ya existe una categoria con ese código");
        }
        else data.getCategorias().add(categoria);
    }
    public void guardarSubCategoria(Categoria categoria,Subcategoria subCategoria) throws Exception {
        Categoria a = readCategoria(categoria);
        if(readSubCategoria(a,subCategoria)!= null){
            throw new Exception("Ya existe una subCategoria con ese código");
        }
        else{
            data.getCategorias().remove(a);
            a.getSubcategorias().add(subCategoria);
            data.getCategorias().add(a);
        }
    }
    public void guardarArticulo(Categoria categoria,Subcategoria subCategoria,Articulo articulo) throws Exception {
        Categoria a = readCategoria(categoria);
        Subcategoria b = readSubCategoria(a,subCategoria);
        if(readArticulo(b,articulo)!= null){
            throw new Exception("Ya existe un articulo con ese código");
        }
        else{
            data.getCategorias().remove(a);
            a.getSubcategorias().remove(b);
            b.getArticulos().add(articulo);
            a.getSubcategorias().add(b);
            data.getCategorias().add(a);
        }
    }
    public void guardarPresentacion(Categoria categoria,Subcategoria subCategoria,Articulo articulo, Presentacion presentacion) throws Exception {
        Categoria a = readCategoria(categoria);
        Subcategoria b = readSubCategoria(a,subCategoria);
        Articulo c = readArticulo(b,articulo);
        if(readPresentacion(c,presentacion)!= null){
            throw new Exception("Ya existe una presentacion con los mismos datos");
        }
        else{
            data.getCategorias().remove(a);
            a.getSubcategorias().remove(b);
            b.getArticulos().remove(c);
            c.getPresentaciones().add(presentacion);
            b.getArticulos().add(c);
            a.getSubcategorias().add(b);
            data.getCategorias().add(a);
        }
    }
    public void editarCategoria(Categoria activo) throws Exception {
        Categoria a = readCategoria(activo);
        if(a == null) throw new Exception("No existe una categoria registrada con ese código");
        else{
            data.getCategorias().remove(a);
            data.getCategorias().add(activo);
        }
    }
    public void editarSubCategoria(Categoria cat,Subcategoria activo) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,activo);
        if(b == null) throw new Exception("No existe una subcategoria registrada con ese código");
        else{
            data.getCategorias().remove(a);
            a.getSubcategorias().remove(b);
            a.getSubcategorias().add(activo);
            data.getCategorias().add(a);
        }
    }
    public void editarArticulo(Categoria cat, Subcategoria sub,Articulo activo) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        Articulo c = readArticulo(b,activo);
        if(a == null) throw new Exception("No existe un articulo registrado con ese código");
        else{
            data.getCategorias().remove(a);
            a.getSubcategorias().remove(b);
            b.getArticulos().remove(c);
            b.getArticulos().add(activo);
            a.getSubcategorias().add(b);
            data.getCategorias().add(a);
        }
    }
    public void editarPresentacion(Categoria cat, Subcategoria sub,Articulo art,Presentacion activo) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        Articulo c = readArticulo(b,art);
        Presentacion d = readPresentacion(c,activo);
        if(a == null) throw new Exception("No existe una presentacion registrada con esos datos");
        else{
            data.getCategorias().remove(a);
            a.getSubcategorias().remove(b);
            b.getArticulos().remove(c);
            c.getPresentaciones().remove(d);
            c.getPresentaciones().add(activo);
            b.getArticulos().add(c);
            a.getSubcategorias().add(b);
            data.getCategorias().add(a);
        }
    }
    public void deleteCategoria(Categoria cat) throws Exception {
        Categoria a = readCategoria(cat);
        if(a == null) throw new Exception("No existe una categoria registrada con ese código");
        data.getCategorias().remove(a);
    }
    public void deleteSubCategoria(Categoria cat, Subcategoria sub) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        if(b == null) throw new Exception("No existe una subCategoria registrada con ese código");
        data.getCategorias().remove(a);
        a.getSubcategorias().remove(b);
        data.getCategorias().add(a);
    }
    public void deleteArticulo(Categoria cat, Subcategoria sub, Articulo art) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        Articulo c = readArticulo(b,art);
        if(c == null) throw new Exception("No existe un articulo registrado con ese código");
        data.getCategorias().remove(a);
        a.getSubcategorias().remove(b);
        b.getArticulos().remove(c);
        a.getSubcategorias().add(b);
        data.getCategorias().add(a);
    }
    public void deletePresentation(Categoria cat, Subcategoria sub, Articulo art,int index) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        Articulo c = readArticulo(b,art);
        if(c == null) throw new Exception("No existe una presentacion registrada con esos datos");
        data.getCategorias().remove(a);
        a.getSubcategorias().remove(b);
        b.getArticulos().remove(c);
        c.getPresentaciones().remove(index);
        b.getArticulos().add(c);
        a.getSubcategorias().add(b);
        data.getCategorias().add(a);
    }
}
