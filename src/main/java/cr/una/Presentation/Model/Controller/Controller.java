package cr.una.Presentation.Model.Controller;

import cr.una.Presentation.Model.View.mainView;
import cr.una.Presentation.Model.Model;

public class Controller {
    private Model model;
    private mainView view;

    public Controller() {
        model = new Model();
        view = new mainView();
    }

    public void init() {
        model.setCategorias(model.getCategorias());

        view.loadView();
    }
}
