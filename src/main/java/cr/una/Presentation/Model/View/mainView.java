package cr.una.Presentation.Model.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cr.una.Presentation.Model.Controller.Controller;
import cr.una.Proxy.Categoria;
import cr.una.Proxy.Subcategoria;
import cr.una.Proxy.Articulo;
import cr.una.Proxy.Presentacion;


public class mainView {
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

    Controller controller;

    public mainView() {
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

        BtnSaveCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(InputCodeViewCat.getText().isEmpty() || InputNameViewCat.getText().isEmpty() || InputDescriptionCat.getText().isEmpty()) {
                        String CamposVacios = "Campos vacios: ";
                        if (InputCodeViewCat.getText().isEmpty()) {
                            CamposVacios += "Codigo ";
                        }
                        if (InputNameViewCat.getText().isEmpty()){
                            CamposVacios += "Nombre ";
                        }
                        if (InputDescriptionCat.getText().isEmpty()){
                            CamposVacios += "Descripcion";
                        }
                        throw new Exception(CamposVacios);
                    }
                    try{
                        Categoria categoria = new Categoria(Integer.parseInt(InputCodeViewCat.getText()), InputNameViewCat.getText(), InputDescriptionCat.getText());
                        controller.AnadirCategoria(categoria);
                    }catch (Exception ex){
                        throw new Exception("El codigo debe ser un valor numerico");
                    }
                    JOptionPane.showMessageDialog(panel1, "Categoria añadida", "Información", JOptionPane.INFORMATION_MESSAGE);
                    InputCodeViewCat.setText("");
                    InputNameViewCat.setText("");
                    InputDescriptionCat.setText("");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
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

    public void setController(Controller controller) {
        this.controller = controller;
    }
    public Controller getController() {return controller;}
}
