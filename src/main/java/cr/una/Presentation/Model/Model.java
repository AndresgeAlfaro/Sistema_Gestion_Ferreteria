package cr.una.Presentation.Model;

import cr.una.Logic.*;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Categoria> categorias;
    private List<Medida> medidas;
    private Categoria currentCategoria;
    private Subcategoria currentSubcategoria;
    private Articulo currentArticulo;
    private Presentacion currentPresentacion;

    private List<Factura> facturas;

    public void init(List<Categoria> c, List<Medida> a){
        facturas = new ArrayList<Factura>();
        setCategorias(c);
        currentCategoria = new Categoria();
        setMedidas(a);
    }


    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Subcategoria> getSubcategorias(Categoria activo) {
        return activo.getSubcategorias();
    }

    public List<Articulo> getArticulos(Subcategoria activo) {
        return activo.getArticulos();
    }
    public List<Presentacion> getPresentaciones(Articulo activo) {
        return activo.getPresentaciones();
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Medida> getMedidas() {
        return medidas;
    }
    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }
    public Medida readMedida(String id){
        Medida result = getMedidas().stream()
                .filter(i->i.getID().equals(id)).findFirst().orElse(null);
        return result;
    }
    public Categoria readCategorias(String cod){
        Categoria result = getCategorias().stream()
                .filter(i->i.getID().equals(cod)).findFirst().orElse(null);
        return result;
    }
    public Subcategoria readSubCategorias(String cod){
        Subcategoria result = currentCategoria.getSubcategorias().stream()
                .filter(i->i.getID().equals(cod)).findFirst().orElse(null);
        return result;
    }
    public Articulo readArticulos(String cod){
        Articulo result = currentSubcategoria.getArticulos().stream()
                .filter(i->i.getID().equals(cod)).findFirst().orElse(null);
        return result;
    }
    public Presentacion readPresentaciones(String cod){
        int split = cod.indexOf('|');
        String cat = cod.substring(0, split);
        String cant = cod.substring(split + 1);
        System.out.println(cat);
        System.out.println(cant);
        Presentacion result = currentArticulo.getPresentaciones().stream()
                .filter(i->i.getUnidad().equals(cat)&&i.getCantidad()==(Double.parseDouble(cant))).findFirst().orElse(null);
        return result;
    }
    public Categoria getCurrentCategoria() {
        return currentCategoria;
    }

    public void setCurrentCategoria(Categoria current) {
        this.currentCategoria = current;
    }

    public Subcategoria getCurrentSubCategoria() {
        return currentSubcategoria;
    }

    public void setCurrentSubCategoria(Subcategoria current) {
        this.currentSubcategoria = current;
    }

    public Articulo getCurrentArticulo() {
        return currentArticulo;
    }

    public void setCurrentArticulo(Articulo current) {
        this.currentArticulo = current;
    }
    public void setCurrentPresentacion(Presentacion current) {
        this.currentPresentacion = current;
    }
    public Presentacion getCurrentPresentacion() {
        return currentPresentacion;
    }

    public void addItemFactura(Factura f) throws Exception{
        Factura factura = searchFact(f);
        if(factura!=null){
            throw new Exception("No se puede agregar el articulo, porque ya se encuntra en la factura.");
        }else{
            facturas.add(f);
        }
    }
    public void clearFactura(){
        facturas.removeAll(facturas);
    }
    public List<Factura> getFacturas() {
        return facturas;
    }
    public Factura searchFact(Factura factura){
        for(Factura f : facturas){
            if(f.getPresentacion().getUnidad().equals(factura.getPresentacion().getUnidad())&&
            f.getPresentacion().getCantidad()==factura.getPresentacion().getCantidad()){
                return f;
            }
        }
        return null;
    }
    public void deleteItemFactura(String id){
        int split = id.indexOf('|');
        String cat = id.substring(0, split);
        String cant = id.substring(split + 1);
        Factura e=null;
        for(Factura f : facturas){
            if(f.getPresentacion().getUnidad().equals(cat)&&f.getPresentacion().getCantidad()==(Double.parseDouble(cant))){
                e=f;
            }
        }
        if(e!=null){
            facturas.remove(e);
        }
    }
}