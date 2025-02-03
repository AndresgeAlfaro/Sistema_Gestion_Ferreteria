package cr.una.Presentation.Model;

import cr.una.Logic.*;

import java.util.List;

public class Model {
    private List<Categoria> categorias;
    private List<Medida> medidas;
    private Categoria currentCategoria;
    private Subcategoria currentSubcategoria;
    private Articulo currentArticulo;
    private Presentacion currentPresentacion;

    public void init(List<Categoria> c, List<Medida> a){
        setCategorias(c);
        currentCategoria = new Categoria();
        setMedidas(a);
    }


    public List<Categoria> getCategorias() {
        return categorias;
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
        Presentacion result = currentArticulo.getPresentaciones().stream()
                .filter(i->i.getUnidad().equals(cod)).findFirst().orElse(null);
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