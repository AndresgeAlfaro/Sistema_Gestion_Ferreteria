package cr.una.Presentation.Model.View;
import cr.una.Presentation.Model.Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class mainView {
    private Controller mainController;

    private JPanel panel1;
    private JTabbedPane PanelOpciones;
    private JTextField InputCodeViewCat;
    private JTextField InputNameViewCat;
    private JTextArea InputDescriptionCat;
    private JButton BtnSaveCat;
    private JTextField InputNameSearchCat;
    private JTextField InputIdSearchCat;
    private JButton BtnSearchCat;
    private JTable ListCat;
    private JTextField InputCatViewSub;
    private JTextField InputSubViewSub;
    private JTextField InputCodeViewSub;
    private JTextField InputNameViewSub;
    private JTextArea InputDescriptionSub;
    private JButton BtnSaveSub;
    private JTextField InputNameSearchSub;
    private JTextField InputIdSearchSub;
    private JButton BtnSearchSub;
    private JTable ListSub;
    private JTextField InputCatViewArt;
    private JTextField InputSubViewArt;
    private JTextField InputNameViewArt;
    private JTextField InputCodeViewArt;
    private JTextArea InputDescriptionArt;
    private JButton BtnSaveArt;
    private JTextField InputNameSearchArt;
    private JTextField InputIdSearchArt;
    private JButton BtnSearchArt;
    private JTable ListArt;
    private JTable ListPresentation;
    private JButton BtnSaveArtPresentation;
    private JPanel PanelCategoria;
    private JScrollPane ScrollListCat;
    private JScrollPane ScrollListSub;
    private JScrollPane ScrollListArt;
    private JScrollPane ScrollListArtPresentation;

    public mainView() {
        mainController = new Controller();
        //PanelOpciones.setEnabledAt(1,false);
        //PanelOpciones.setEnabledAt(2,false);
        InputCodeViewCat.setBorder(null);
        InputNameViewCat.setBorder(null);
        InputNameSearchCat.setBorder(null);
        InputIdSearchCat.setBorder(null);
        InputCatViewSub.setBorder(null);
        InputSubViewSub.setBorder(null);
        InputCodeViewSub.setBorder(null);
        InputNameViewSub.setBorder(null);
        InputNameSearchSub.setBorder(null);
        InputIdSearchSub.setBorder(null);
        InputCatViewArt.setBorder(null);
        InputSubViewArt.setBorder(null);
        InputCodeViewArt.setBorder(null);
        InputNameViewArt.setBorder(null);
        InputNameSearchArt.setBorder(null);
        InputIdSearchArt.setBorder(null);
        Object[] TABLE_HEADER = { "ID", "Nombre",
                "Descripcion"};
        DefaultTableModel model = new DefaultTableModel(null, TABLE_HEADER) {};
        Object[] TABLE_HEADER2 = { "Unidad", "Cantidad/Capacidad"};
        DefaultTableModel model2 = new DefaultTableModel(null, TABLE_HEADER2) {};
        ListCat.setModel(model);
        ListSub.setModel(model);
        ListArt.setModel(model);
        ListPresentation.setModel(model2);
    }
    public void setController(Controller controller){
        mainController = controller;
    }
    public void loadView()
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de gestión de inventario para ferretería");
            frame.setContentPane(panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });


    }
}
