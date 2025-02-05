package cr.una.FrontEnd.Presentation.Model;

import cr.una.BackEnd.Logic.*;
import javax.swing.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Model {
    private List<Categoria> categorias = new ArrayList<>();
    private List<Medida> medidas = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Categoria currentCategoria;
    private Subcategoria currentSubcategoria;
    private Articulo currentArticulo;
    private Presentacion currentPresentacion;
    private final ImageIcon[] myIcons = {
            new ImageIcon(Paths.get("icoCheck0.png").toString()),
            new ImageIcon(Paths.get("icoCheck1.png").toString())
    };
    private List<Factura> facturas = new ArrayList<>();

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias != null ? categorias : new ArrayList<>();
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas != null ? medidas : new ArrayList<>();
    }

    public void setUsers(List<User> users) {
        this.users = users != null ? users : new ArrayList<>();
    }

    public ImageIcon getIcon(int index) {
        return (index >= 0 && index < myIcons.length) ? myIcons[index] : null;
    }

    public List<Categoria> getCategorias() {
        return new ArrayList<>(categorias);
    }

    public List<Subcategoria> getSubcategorias(Categoria activo) {
        return activo != null ?
                new ArrayList<>(activo.getSubcategorias()) :
                new ArrayList<>();
    }

    public List<Articulo> getArticulos(Subcategoria activo) {
        return activo != null ?
                new ArrayList<>(activo.getArticulos()) :
                new ArrayList<>();
    }

    public List<Presentacion> getPresentaciones(Articulo activo) {
        return activo != null ?
                new ArrayList<>(activo.getPresentaciones()) :
                new ArrayList<>();
    }

    public List<Medida> getMedidas() {
        return new ArrayList<>(medidas);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    // Gestión de selecciones actuales
    public Categoria getCurrentCategoria() {
        return currentCategoria;
    }

    public void setCurrentCategoria(Categoria currentCategoria) {
        this.currentCategoria = currentCategoria;
    }

    public Subcategoria getCurrentSubcategoria() {
        return currentSubcategoria;
    }

    public void setCurrentSubcategoria(Subcategoria currentSubcategoria) {
        this.currentSubcategoria = currentSubcategoria;
    }

    public Articulo getCurrentArticulo() {
        return currentArticulo;
    }

    public void setCurrentArticulo(Articulo currentArticulo) {
        this.currentArticulo = currentArticulo;
    }

    public Presentacion getCurrentPresentacion() {
        return currentPresentacion;
    }

    public void setCurrentPresentacion(Presentacion currentPresentacion) {
        this.currentPresentacion = currentPresentacion;
    }

    // Gestión de facturas
    public void addItemFactura(Factura factura) throws Exception {
        boolean exists = facturas.stream().anyMatch(f ->
                f.getPresentacion().equals(factura.getPresentacion()));

        if (exists) {
            throw new Exception("El artículo ya existe en la factura");
        }
        facturas.add(factura);
    }

    public void clearFactura() {
        facturas.clear();
    }

    public List<Factura> getFacturas() {
        return new ArrayList<>(facturas);
    }

    public void deleteItemFactura(String id) {
        facturas.removeIf(f ->
                f.getPresentacion().getUnidad().equals(id.split("\\|")[0]) &&
                        f.getPresentacion().getCantidad() == Double.parseDouble(id.split("\\|")[1])
        );
    }

    // Búsquedas locales
    public Medida findMedida(String id) {
        return medidas.stream()
                .filter(m -> m.getID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Categoria findCategoria(String id) {
        return categorias.stream()
                .filter(c -> c.getID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Subcategoria findSubcategoria(String id) {
        return Optional.ofNullable(currentCategoria)
                .map(c -> c.getSubcategorias().stream()
                        .filter(s -> s.getID().equals(id))
                        .findFirst()
                        .orElse(null))
                .orElse(null);
    }

    public Articulo findArticulo(String id) {
        return Optional.ofNullable(currentSubcategoria)
                .map(s -> s.getArticulos().stream()
                        .filter(a -> a.getID().equals(id))
                        .findFirst()
                        .orElse(null))
                .orElse(null);
    }

    public Presentacion findPresentacion(String id) {
        String[] parts = id.split("\\|");
        return Optional.ofNullable(currentArticulo)
                .map(a -> a.getPresentaciones().stream()
                        .filter(p -> p.getUnidad().equals(parts[0]) &&
                                p.getCantidad() == Double.parseDouble(parts[1]))
                        .findFirst()
                        .orElse(null))
                .orElse(null);
    }
}