package cr.una.Presentation.Controller;

import cr.una.Logic.*;
import cr.una.Presentation.Model.Model;
import cr.una.Presentation.View.View;
import cr.una.Presentation.View.viewLogin;

import javax.swing.*;
import java.util.List;


public class Controller {
    private Model model;
    private View view;

    public Controller() {
        try{
            Service.instance().cargarXML();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        model = new Model();
        model.init(Service.instance().getCategorias(), Service.instance().getMedidas(), Service.instance().getUsers());
    }

    public void starLogin(){

        viewLogin view = new viewLogin();
        view.setController(this);
        view.initIcon();
    }
    public boolean checkLogin(String username, String password ) throws Exception{
        try {
            User user = model.checkLogin(username, password);
            boolean login=false;
            if(user.getState().equals("Activo")){
                if(user.getPassword().equals(password)){
                    login=true;
                }else{
                    if(model.addTrie(username)==3){
                        updateUsers(model.getUsers());
                        throw new Exception("Limite de Intentos Excedido - Bloqueando Usuario");
                    }else{
                        throw new Exception("Credenciales Incorrectas - Intente Denuevo");
                    }
                }
            }else{
                throw new Exception("Este Usuario esta Bloqueado");
            }


            if(login){
                startAplication();
            }
            return login;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
    public void startAplication() {
        View view = new View();
        view.setController(this);
        view.updateList(0);
        view.activeBox(0);
    }
    public ImageIcon getIcon(int icoIndex){
        try{
            return model.getIcon(icoIndex);

        }catch (Exception er){
            return null;
        }
    }
    public void updateUsers(List<User> users) throws Exception {
        Service.instance().setUsers(users);
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
    public void editPresentacion(String cod) throws Exception {
        Presentacion a = model.readPresentaciones(cod);
        if(a== null){
            throw new Exception("No hay Presentaciones registradas con ese código");
        }
        model.setCurrentPresentacion(a);
    }
    public List<Medida> getMedidas() {
        return model.getMedidas();
    }
    public Medida readMedida(String cod) {
        return  model.readMedida(cod);
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
        model.setCurrentPresentacion(model.readPresentaciones(activo.getUnidad()+'|'+activo.getCantidad()));
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
    public void deletePresentation() throws Exception {
        Service.instance().deletePresentation(model.getCurrentCategoria(),model.getCurrentSubCategoria(),model.getCurrentArticulo(),model.getCurrentPresentacion());
        model.setCategorias(Service.instance().getCategorias());
    }
    public List<Categoria> getCategorias() {
        return model.getCategorias();
    }
    public List<Subcategoria> getSubcategorias(Categoria activo) {
        return model.getSubcategorias(activo);
    }
    public List<Articulo> getArticulos(Subcategoria activo) {
        return model.getArticulos(activo);
    }
    public List<Presentacion> getPresentaciones(Articulo activo) {
        return model.getPresentaciones(activo);
    }
    public void addItemFact(Factura fact) throws Exception {
        model.addItemFactura(fact);
    }
    public void clearFactura(){
        model.clearFactura();
    }
    public List<Factura> getFacturas() {
        return model.getFacturas();
    }
    public void deleteItemFactura(String id){
        model.deleteItemFactura(id);
    }
    public void billing() throws Exception {
        Service.instance().reduceExistences(model.getFacturas());
        model.clearFactura();
        model.setCategorias(Service.instance().getCategorias());
    }
}
