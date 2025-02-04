package cr.una.Logic;

import cr.una.Data.Data;
import cr.una.Data.XMLPersistent;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

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

    public List<Medida> getMedidas() {
        return data.getMedidas();
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
                .filter((i->i.getUnidad().equals(presentacion.getUnidad())&&i.getCantidad()==presentacion.getCantidad())).findFirst().orElse(null);
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
            int index = data.getCategorias().indexOf(a);
            data.getCategorias().remove(a);
            a.getSubcategorias().add(subCategoria);
            data.getCategorias().add(index,a);
        }
    }
    public void guardarArticulo(Categoria categoria,Subcategoria subCategoria,Articulo articulo) throws Exception {
        Categoria a = readCategoria(categoria);
        Subcategoria b = readSubCategoria(a,subCategoria);
        if(readArticulo(b,articulo)!= null){
            throw new Exception("Ya existe un articulo con ese código");
        }
        else{
            int index = data.getCategorias().indexOf(a);
            data.getCategorias().remove(a);
            int index2 = a.getSubcategorias().indexOf(b);
            a.getSubcategorias().remove(b);
            b.getArticulos().add(articulo);
            a.getSubcategorias().add(index2,b);
            data.getCategorias().add(index,a);
        }
    }
    public void guardarPresentacion(Categoria categoria,Subcategoria subCategoria,Articulo articulo, Presentacion presentacion) throws Exception {
        Categoria a = readCategoria(categoria);
        Subcategoria b = readSubCategoria(a,subCategoria);
        Articulo c = readArticulo(b,articulo);
        if(readPresentacion(c,presentacion)!= null){
            throw new Exception("Ya existe una presentacion con la misma unidad de medida");
        }
        else{
            int index = data.getCategorias().indexOf(a);
            data.getCategorias().remove(a);
            int index2 = a.getSubcategorias().indexOf(b);
            a.getSubcategorias().remove(b);
            int index3 = b.getArticulos().indexOf(c);
            b.getArticulos().remove(c);
            c.getPresentaciones().add(presentacion);
            b.getArticulos().add(index3,c);
            a.getSubcategorias().add(index2,b);
            data.getCategorias().add(index,a);
        }
    }
    public void editarCategoria(Categoria activo) throws Exception {
        Categoria a = readCategoria(activo);
        if(a == null) throw new Exception("No existe una categoria registrada con ese código");
        else{
            activo.setSubcategorias(a.getSubcategorias());
            int index=data.getCategorias().indexOf(a);
            data.getCategorias().set(index, activo);
        }
    }
    public void editarSubCategoria(Categoria cat,Subcategoria activo) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,activo);
        if(b == null) throw new Exception("No existe una subcategoria registrada con ese código");
        else{
            int index=data.getCategorias().indexOf(a);
            data.getCategorias().remove(a);
            activo.setArticulos(b.getArticulos());
            int index2 = a.getSubcategorias().indexOf(b);
            a.getSubcategorias().set(index2, activo);
            data.getCategorias().add(index,a);
        }
    }
    public void editarArticulo(Categoria cat, Subcategoria sub,Articulo activo) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        Articulo c = readArticulo(b,activo);
        if(a == null) throw new Exception("No existe un articulo registrado con ese código");
        else{
            int index=data.getCategorias().indexOf(a);
            data.getCategorias().remove(a);
            int index2 = a.getSubcategorias().indexOf(b);
            a.getSubcategorias().remove(b);
            activo.setPresentaciones(c.getPresentaciones());
            int index3 = b.getArticulos().indexOf(c);
            b.getArticulos().set(index3, activo);
            a.getSubcategorias().add(index2,b);
            data.getCategorias().add(index,a);
        }
    }
    public void editarPresentacion(Categoria cat, Subcategoria sub,Articulo art,Presentacion activo) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        Articulo c = readArticulo(b,art);
        Presentacion d = readPresentacion(c,activo);
        if(a == null) throw new Exception("No existe una presentacion registrada con esos datos");
        else{
            int index=data.getCategorias().indexOf(a);
            data.getCategorias().remove(a);
            int index2 = a.getSubcategorias().indexOf(b);
            a.getSubcategorias().remove(b);
            int index3 = b.getArticulos().indexOf(c);
            b.getArticulos().remove(c);
            int index4 = c.getPresentaciones().indexOf(d);
            c.getPresentaciones().set(index4, activo);
            b.getArticulos().add(index3,c);
            a.getSubcategorias().add(index2,b);
            data.getCategorias().add(index,a);
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
        int index=data.getCategorias().indexOf(a);
        data.getCategorias().remove(a);
        a.getSubcategorias().remove(b);
        data.getCategorias().add(index,a);
    }
    public void deleteArticulo(Categoria cat, Subcategoria sub, Articulo art) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        Articulo c = readArticulo(b,art);
        if(c == null) throw new Exception("No existe un articulo registrado con ese código");
        int index=data.getCategorias().indexOf(a);
        data.getCategorias().remove(a);
        int index2=a.getSubcategorias().indexOf(b);
        a.getSubcategorias().remove(b);
        b.getArticulos().remove(c);
        a.getSubcategorias().add(index2,b);
        data.getCategorias().add(index,a);
    }
    public void deletePresentation(Categoria cat, Subcategoria sub, Articulo art,Presentacion pre) throws Exception {
        Categoria a = readCategoria(cat);
        Subcategoria b = readSubCategoria(a,sub);
        Articulo c = readArticulo(b,art);
        if(c == null) throw new Exception("No existe una presentacion registrada con esos datos");
        int index=data.getCategorias().indexOf(a);
        data.getCategorias().remove(a);
        int index2=a.getSubcategorias().indexOf(b);
        a.getSubcategorias().remove(b);
        int index3=b.getArticulos().indexOf(c);
        b.getArticulos().remove(c);
        c.getPresentaciones().remove(pre);
        b.getArticulos().add(index3,c);
        a.getSubcategorias().add(index2,b);
        data.getCategorias().add(index,a);
    }
    public void reduceExistences(List<Factura> facturas) throws Exception {
        for (Factura f : facturas) {
            Categoria a = readCategoria(f.getCategoria());
            Subcategoria b = readSubCategoria(a,f.getSubcategoria());
            Articulo c = readArticulo(b,f.getArticulo());
            Presentacion d = readPresentacion(c,f.getPresentacion());
            f.getPresentacion().setExistencia(f.getPresentacion().getExistencia()-f.getCantidad());
            if (f.getPresentacion().getExistencia() < 0) {
                throw new Exception("No existe suficiente existencias");
            }
            if(a == null) throw new Exception("No existe una presentacion registrada con esos datos");
            else{
                int index=data.getCategorias().indexOf(a);
                data.getCategorias().remove(a);
                int index2 = a.getSubcategorias().indexOf(b);
                a.getSubcategorias().remove(b);
                int index3 = b.getArticulos().indexOf(c);
                b.getArticulos().remove(c);
                int index4 = c.getPresentaciones().indexOf(d);
                c.getPresentaciones().set(index4, f.getPresentacion());
                b.getArticulos().add(index3,c);
                a.getSubcategorias().add(index2,b);
                data.getCategorias().add(index,a);
            }
        }
    }
}
