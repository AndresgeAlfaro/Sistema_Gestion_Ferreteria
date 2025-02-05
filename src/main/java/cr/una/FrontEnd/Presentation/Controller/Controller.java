package cr.una.FrontEnd.Presentation.Controller;

import cr.una.BackEnd.Logic.*;
import cr.una.FrontEnd.Presentation.Model.Model;
import cr.una.FrontEnd.Presentation.View.View;
import cr.una.FrontEnd.Presentation.View.viewLogin;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class Controller {
    private Model model;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public Controller() {
        model = new Model();
        initializeConnection();
    }

    private void initializeConnection() {
        try {
            socket = new Socket("localhost", 12345);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            showError("Error de conexión", "No se pudo conectar al servidor");
        }
    }

    private void showError(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public void startLogin() {
        viewLogin view = new viewLogin();
        view.setController(this);
        view.initIcon();
    }

    public boolean checkLogin(String username, String password) throws Exception {
        try {
            output.writeObject("LOGIN");
            output.writeObject(username);
            output.writeObject(password);

            String response = (String) input.readObject();
            if (response.startsWith("ERROR")) {
                throw new Exception(response.substring(6));
            }

            loadInitialData();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("Error de comunicación: " + e.getMessage());
        }
    }

    private void loadInitialData() throws Exception {
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
        model.setMedidas(executeCommand("GET_MEDIDAS", List.class));
        model.setUsers(executeCommand("GET_USUARIOS", List.class));
    }

    private <T> T executeCommand(String command, Class<T> type) throws Exception {
        try {
            output.writeObject(command);
            return type.cast(input.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("Error al obtener datos: " + e.getMessage());
        }
    }

    public void startApplication() {
        View view = new View();
        view.setController(this);
        view.updateList(0);
        view.activeBox(0);
    }

    // Operaciones CRUD Categorías
    public void guardarCategoria(Categoria categoria) throws Exception {
        executeUpdate("GUARDAR_CATEGORIA", categoria);
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    public void editarCategoria(Categoria activo) throws Exception {
        executeUpdate("EDITAR_CATEGORIA", activo);
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    public void deleteCategoria() throws Exception {
        executeUpdate("ELIMINAR_CATEGORIA", model.getCurrentCategoria());
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    // Operaciones CRUD Subcategorías
    public void guardarSubCategoria(Subcategoria subCategoria) throws Exception {
        executeUpdate("GUARDAR_SUBCATEGORIA", new Object[]{model.getCurrentCategoria(), subCategoria});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    public void editarSubCategoria(Subcategoria activo) throws Exception {
        executeUpdate("EDITAR_SUBCATEGORIA", new Object[]{model.getCurrentCategoria(), activo});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    public void deleteSubCategoria() throws Exception {
        executeUpdate("ELIMINAR_SUBCATEGORIA", new Object[]{model.getCurrentCategoria(), model.getCurrentSubcategoria()});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    // Operaciones CRUD Artículos
    public void guardarArticulo(Articulo articulo) throws Exception {
        executeUpdate("GUARDAR_ARTICULO", new Object[]{model.getCurrentCategoria(), model.getCurrentSubcategoria(), articulo});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    public void editarArticulo(Articulo activo) throws Exception {
        executeUpdate("EDITAR_ARTICULO", new Object[]{model.getCurrentCategoria(), model.getCurrentSubcategoria(), activo});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    public void deleteArticulo() throws Exception {
        executeUpdate("ELIMINAR_ARTICULO", new Object[]{model.getCurrentCategoria(), model.getCurrentSubcategoria(), model.getCurrentArticulo()});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    // Operaciones CRUD Presentaciones
    public void guardarPresentacion(Presentacion presentacion) throws Exception {
        executeUpdate("GUARDAR_PRESENTACION", new Object[]{model.getCurrentCategoria(), model.getCurrentSubcategoria(), model.getCurrentArticulo(), presentacion});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    public void editarPresentacion(Presentacion activo) throws Exception {
        executeUpdate("EDITAR_PRESENTACION", new Object[]{model.getCurrentCategoria(), model.getCurrentSubcategoria(), model.getCurrentArticulo(), activo});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    public void deletePresentation() throws Exception {
        executeUpdate("ELIMINAR_PRESENTACION", new Object[]{model.getCurrentCategoria(), model.getCurrentSubcategoria(), model.getCurrentArticulo(), model.getCurrentPresentacion()});
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    private void executeUpdate(String command, Object data) throws Exception {
        try {
            output.writeObject(command);
            output.writeObject(data);
            String response = (String) input.readObject();
            if (response.startsWith("ERROR")) {
                throw new Exception(response.substring(6));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception("Error de comunicación: " + e.getMessage());
        }
    }

    // Getters del modelo
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

    public List<Medida> getMedidas() {
        return model.getMedidas();
    }

    // Gestión de selecciones actuales
    public void setCurrentCategoria(Categoria categoria) {
        model.setCurrentCategoria(categoria);
    }

    public void setCurrentSubcategoria(Subcategoria subcategoria) {
        model.setCurrentSubcategoria(subcategoria);
    }

    public void setCurrentArticulo(Articulo articulo) {
        model.setCurrentArticulo(articulo);
    }

    public void setCurrentPresentacion(Presentacion presentacion) {
        model.setCurrentPresentacion(presentacion);
    }

    // Facturación
    public void addItemFact(Factura fact) throws Exception {
        model.addItemFactura(fact);
    }

    public void clearFactura() {
        model.clearFactura();
    }

    public List<Factura> getFacturas() {
        return model.getFacturas();
    }

    public void deleteItemFactura(String id) {
        model.deleteItemFactura(id);
    }

    public void billing() throws Exception {
        executeUpdate("REALIZAR_VENTA", model.getFacturas());
        model.clearFactura();
        model.setCategorias(executeCommand("GET_CATEGORIAS", List.class));
    }

    // Métodos auxiliares
    public ImageIcon getIcon(int icoIndex) {
        return model.getIcon(icoIndex);
    }

    // En el Controller
    public Categoria getCurrentCategoria() {
        return model.getCurrentCategoria();
    }

    public Subcategoria getCurrentSubcategoria() {
        return model.getCurrentSubcategoria();
    }

    public Articulo getCurrentArticulo() {
        return model.getCurrentArticulo();
    }

    public Presentacion getCurrentPresentacion() {
        return model.getCurrentPresentacion();
    }

    public Medida findMedida(String id) {
        return model.findMedida(id);
    }
}
