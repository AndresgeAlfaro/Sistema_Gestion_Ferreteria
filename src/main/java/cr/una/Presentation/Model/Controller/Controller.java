package cr.una.Presentation.Model.Controller;

import cr.una.Presentation.Model.View.mainView;
import cr.una.Presentation.Model.Model;
import cr.una.Proxy.Categoria;

public class Controller {
    private Model model;
    private mainView view;

    public Controller() {
        model = new Model();
        view = new mainView();
        view.setController(this);
    }

    public void init() {
        model.setCategorias(model.getCategorias());

        view.loadView();
    }

    public void AnadirCategoria(Categoria categoria) {
        model.getCategorias().getCategorias().add(categoria);
    }
}
