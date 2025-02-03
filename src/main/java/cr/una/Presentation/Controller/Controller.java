package cr.una.Presentation.Controller;

import cr.una.Logic.*;
import cr.una.Presentation.Model.Model;
import cr.una.Presentation.View.View;

import java.util.List;


public class Controller {
    private Model model;
    private View view;

    public void startAplication(View view) {
        try{
            Service.instance().cargarXML();
        }catch (Exception ex){
        System.out.println(ex.getMessage());
        }
        model = new Model();
        this.view = view;
        view.setController(this);
        model.init(Service.instance().getCategorias());
        this.view.updateList(0);
    }
    public void guardarCategoria(Categoria categoria) throws Exception {
        Service.instance().guardarCategoria(categoria);
        model.setCategorias(Service.instance().getCategorias());
    }
    public void guardarSubCategoria(Subcategoria subCategoria) throws Exception {
        Service.instance().guardarSubCategoria(model.getCurrentCategoria(), subCategoria);
        model.setCategorias(Service.instance().getCategorias());
    }
    public void guardarArticulo(Articulo articulo) throws Exception {
        Service.instance().guardarArticulo(model.getCurrentCategoria(),getCurrentSubcategoria(), articulo);
        model.setCategorias(Service.instance().getCategorias());
    }
    public void guardarPresentacion(Presentacion presentacion) throws Exception {
        Service.instance().guardarPresentacion(model.getCurrentCategoria(),getCurrentSubcategoria(), getCurrentArticulo(),presentacion);
        model.setCategorias(Service.instance().getCategorias());
    }
    public void editCategoria(String cod) throws Exception {
        Categoria a = model.readCategorias(cod);
        if(a== null){
            throw new Exception("No hay categorias registradas con ese código");
        }
        model.setCurrentCategoria(a);
    }
    public void editSubCategoria(String cod) throws Exception {
        Subcategoria a = model.readSubCategorias(cod);
        if(a== null){
            throw new Exception("No hay subCategorias registradas con ese código");
        }
        model.setCurrentSubCategoria(a);
    }
    public void editArticulo(String cod) throws Exception {
        Articulo a = model.readArticulos(cod);
        if(a== null){
            throw new Exception("No hay articulos registradas con ese código");
        }
        model.setCurrentArticulo(a);
    }
    public Categoria getCurrentCategoria() {
        return model.getCurrentCategoria();
    }

    public Subcategoria getCurrentSubcategoria() {
        return model.getCurrentSubCategoria();
    }
    public Articulo getCurrentArticulo() {
        return model.getCurrentArticulo();
    }
    public Presentacion getCurrentPresentacion() {
        return model.getCurrentPresentacion();
    }
    public void editarCategoria(Categoria activo) throws Exception {
        Service.instance().editarCategoria(activo);
        model.setCategorias(Service.instance().getCategorias());
        model.setCurrentCategoria(model.readCategorias(activo.getID()));
    }
    public void editarSubCategoria(Subcategoria activo) throws Exception {
        Service.instance().editarSubCategoria(model.getCurrentCategoria(), activo);
        model.setCategorias(Service.instance().getCategorias());
        model.setCurrentCategoria(model.readCategorias(model.getCurrentCategoria().getID()));
        model.setCurrentSubCategoria(model.readSubCategorias(activo.getID()));
    }
    public void editarArticulo(Articulo activo) throws Exception {
        Service.instance().editarArticulo(model.getCurrentCategoria(),model.getCurrentSubCategoria(), activo);
        model.setCategorias(Service.instance().getCategorias());
        model.setCurrentCategoria(model.readCategorias(model.getCurrentCategoria().getID()));
        model.setCurrentSubCategoria(model.readSubCategorias(model.getCurrentSubCategoria().getID()));
        model.setCurrentArticulo(model.readArticulos(activo.getID()));
    }
    public void editarPresentacion(Presentacion activo) throws Exception {
        Service.instance().editarPresentacion(model.getCurrentCategoria(),model.getCurrentSubCategoria(),model.getCurrentArticulo(), activo);
        model.setCategorias(Service.instance().getCategorias());
        model.setCurrentCategoria(model.readCategorias(model.getCurrentCategoria().getID()));
        model.setCurrentSubCategoria(model.readSubCategorias(model.getCurrentSubCategoria().getID()));
        model.setCurrentArticulo(model.readArticulos(model.getCurrentArticulo().getID()));
        model.setCurrentPresentacion(model.readPResentaciones(activo.getUnidad(), activo.getCantidad()));
    }
    public void deleteCategoria() throws Exception {
        Service.instance().deleteCategoria(model.getCurrentCategoria());
        model.setCategorias(Service.instance().getCategorias());
        model.setCurrentCategoria(null);
    }
    public void deleteSubCategoria() throws Exception {
        Service.instance().deleteSubCategoria(model.getCurrentCategoria(),model.getCurrentSubCategoria());
        model.setCategorias(Service.instance().getCategorias());
        model.setCurrentSubCategoria(null);
    }
    public void deleteArticulo() throws Exception {
        Service.instance().deleteArticulo(model.getCurrentCategoria(),model.getCurrentSubCategoria(),model.getCurrentArticulo());
        model.setCategorias(Service.instance().getCategorias());
        model.setCurrentArticulo(null);
    }
    public void deletePresentation(int index) throws Exception {
        Service.instance().deletePresentation(model.getCurrentCategoria(),model.getCurrentSubCategoria(),model.getCurrentArticulo(),index);
        model.setCategorias(Service.instance().getCategorias());
    }
    public List<Categoria> getCategorias() {
        return model.getCategorias();
    }
    public Categoria getCategoria(int index){
        return model.getCategorias().get(index);
    }
    public Subcategoria getSubCategoria(int index){
        Categoria c = getCurrentCategoria();
        return c.getSubcategorias().get(index);
    }
    public Articulo getArticulos(int index){
        Subcategoria c = getCurrentSubcategoria();
        return c.getArticulos().get(index);
    }
    public Presentacion getPresentaciones(int index){
        Articulo c = getCurrentArticulo();
        return c.getPresentaciones().get(index);
    }
    public int getCategoriasSize(){
        return model.getCategorias().size();
    }
    public int getSubCategoriasSize(){
        Categoria c = getCurrentCategoria();
        return c.getSubcategorias().size();
    }
    public int getArticulosSize(){
        Subcategoria c = getCurrentSubcategoria();
        return c.getArticulos().size();
    }
    public int getPresentacionSize(){
        Articulo c = getCurrentArticulo();
        return c.getPresentaciones().size();
    }
    public void resetCurrentCategoria(){
        model.setCurrentCategoria(null);
    }
    public void resetCurrentSubCategoria(){
        model.setCurrentSubCategoria(null);
    }
    public void resetCurrentArticulo(){
        model.setCurrentArticulo(null);
    }
    public void resetCurrentPresentacion(){
        model.setCurrentArticulo(null);
    }
}
