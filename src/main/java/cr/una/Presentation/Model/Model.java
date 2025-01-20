package cr.una.Presentation.Model;

import cr.una.Logic.Articulo;
import cr.una.Logic.Categoria;
import cr.una.Logic.Presentacion;
import cr.una.Logic.Subcategoria;

import java.util.List;

public class Model {
    private List<Categoria> categorias;
    private Categoria currentCategoria;
    private Subcategoria currentSubcategoria;
    private Articulo currentArticulo;
    private Presentacion currentPresentacion;

    public void init(List<Categoria> c){
        setCategorias(c);
        currentCategoria = new Categoria();
    }


    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
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
    public Presentacion readPResentaciones(String cod, String cod2){
        Presentacion result = currentArticulo.getPresentaciones().stream()
                .filter(i->i.getUnidad().equals(cod)&&i.getCantidad().equals(cod2)).findFirst().orElse(null);
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

}