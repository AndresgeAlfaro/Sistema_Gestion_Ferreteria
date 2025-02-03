package cr.una.Presentation.View;

import cr.una.Logic.Articulo;
import cr.una.Logic.Categoria;
import cr.una.Logic.Subcategoria;
import cr.una.Presentation.Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class View {
    private JTabbedPane TabPanel;
    private JPanel mainPanel;
    private JTextField CodCat;
    private JTextField NameCat;
    private JTextArea DesCat;
    private JButton SaveCat;
    private JButton DelCat;
    private JTextField IDCat;
    private JButton SearchCat;
    private JScrollPane ScrollCat;
    private JPanel ListCat;
    private JButton ClearCat;
    private JTextField CatSub;
    private JTextField CodSub;
    private JTextField NameSub;
    private JTextArea DesSub;
    private JButton SaveSub;
    private JButton DelSub;
    private JButton ClearSub;
    private JTextField IDSub;
    private JButton SearchSub;
    private JScrollPane ScrollSub;
    private JPanel ListSub;
    private JTextField CatArt;
    private JTextField SubArt;
    private JTextField CodArt;
    private JTextField NameArt;
    private JTextArea DesArt;
    private JButton SaveArt;
    private JButton DelArt;
    private JButton ClearArt;
    private JComboBox ComboPre;
    private JTextField CantPre;
    private JButton SavePre;
    private JButton DelPre;
    private JButton ClearPre;
    private JTextField IDArt;
    private JButton SearchArt;
    private JScrollPane ScrollArt;
    private JPanel ListArt;
    private JScrollPane ScrollPre;
    private JPanel ListPre;
    private JTextField textField1;
    private JTextField textField2;

    private boolean[] editar = {false,false,false,false};

    private JTextField[][] inputs = {{CodCat,NameCat, IDCat},{CodSub,NameSub,IDSub},{CodArt,NameArt,IDArt}};

    private JButton[][] buttons = {{SaveCat,DelCat,SearchCat,ClearCat},{SaveSub,DelSub,SearchSub,ClearSub},{SaveArt,DelArt,SearchArt,ClearArt}};

    private JPanel[] lists = {ListCat,ListSub,ListArt};

    private JScrollPane[] ListScroll = {ScrollCat,ScrollSub,ScrollArt};

    private JTextArea[] inputDes = {DesCat,DesSub,DesArt};

    private Controller controller;

    public View() {
        UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(1, 0,
                0, 0));
        UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(
                new Color(29,95,254)));
        UIManager.put("TabbedPane.focus", new ColorUIResource(new Color(29,95,254)));
        UIManager.put("TabbedPane.selected", new ColorUIResource(new Color(29,95,254)));
        UIManager
                .put("TabbedPane.darkShadow", new ColorUIResource(Color.DARK_GRAY));
        UIManager.put("TabbedPane.borderHightlightColor", new ColorUIResource(
                Color.LIGHT_GRAY));
        UIManager.put("TabbedPane.light", new ColorUIResource(Color.WHITE));
        UIManager.put("TabbedPane.tabAreaBackground", new ColorUIResource(
                Color.CYAN));
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.border", new BorderUIResource(new LineBorder(
                Color.BLACK)));
        TabPanel.updateUI();
        TabPanel.setEnabledAt(1,false);
        TabPanel.setEnabledAt(2,false);
        CatSub.setBorder(null);
        CatArt.setBorder(null);
        SubArt.setBorder(null);
        CodCat.setBorder(null);
        CodCat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(0);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(0);
            }
        });
        CodSub.setBorder(null);
        CodSub.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(1);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(1);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(1);
            }
        });
        CodArt.setBorder(null);
        CodArt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(2);
            }
        });
        NameCat.setBorder(null);
        NameCat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(0);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(0);
            }
        });
        NameSub.setBorder(null);
        NameSub.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(1);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(1);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(1);
            }
        });
        NameArt.setBorder(null);
        NameArt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(2);
            }
        });
        DesCat.setBorder(null);
        DesCat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(0);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(0);
            }
        });
        DesSub.setBorder(null);
        DesSub.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(1);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(1);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(1);
            }
        });
        DesArt.setBorder(null);
        DesArt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAdd(2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setAdd(2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setAdd(2);
            }
        });
        IDCat.setBorder(null);
        IDCat.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchButton(0);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchButton(0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchButton(0);
            }
        });
        IDSub.setBorder(null);
        IDSub.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchButton(1);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchButton(1);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchButton(1);
            }
        });
        IDArt.setBorder(null);
        IDArt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchButton(2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchButton(2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchButton(2);
            }
        });
        SaveCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(0);
            }
        });
        SaveSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(1);
            }
        });
        SaveArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(2);
            }
        });
        SearchCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectCategoria(IDCat.getText());
                IDCat.setText("");
            }
        });
        SearchSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSubCategoria(IDSub.getText());
                IDSub.setText("");
            }
        });
        SearchArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectArticulo(IDArt.getText());
                IDArt.setText("");
            }
        });
        DelCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(0);
            }
        });
        DelSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(1);
            }
        });
        DelArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(2);
            }
        });
        ClearCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar(0);
            }
        });
        ClearSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar(1);
            }
        });
        ClearArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar(2);
            }
        });
    }
    public void delete(int option) {
        try{
            switch (option) {
                case 0:{
                    controller.deleteCategoria();
                    break;
                }
                case 1:{
                    controller.deleteSubCategoria();
                    setDelete(0);
                    break;
                }
                case 2:{
                    controller.deleteArticulo();
                    setDelete(1);
                    break;
                }
            }
            limpiar(option);
            JOptionPane.showMessageDialog(mainPanel, "Eliminado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
            updateList(option);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void searchButton(int option){
        if(!inputs[option][2].getText().isEmpty()){
            buttons[option][2].setEnabled(true);
            buttons[option][2].setBackground(new Color(29,95,254));
        }else{
            buttons[option][2].setEnabled(false);
            buttons[option][2].setBackground(new Color(51,55,66));
        }

    }
    public class selectButton extends JButton {
        private String id;
        private int option;
        public selectButton(String id, int option) {
            this.id = id;
            this.option = option;
            this.setBackground(new Color(29,95,254));
            this.setText("Seleccionar");
            this.setForeground(Color.WHITE);
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch(option){
                        case 0: {
                            selectCategoria(id);
                            break;
                        }
                        case 1: {
                            selectSubCategoria(id);
                            break;
                        }
                        case 2:{
                            selectArticulo(id);
                            break;
                        }
                    }
                }
            });
        }
    }
    public void selectCategoria(String id) {
        try{
            controller.editCategoria(id);
            Categoria actual = controller.getCurrentCategoria();
            editar[0] = true;
            inputs[0][0].setEnabled(false);
            inputs[0][0].setText(actual.getID());
            inputs[0][1].setText(actual.getNombre());
            inputDes[0].setText(actual.getDescripcion());
            buttons[0][3].setEnabled(true);
            buttons[0][3].setBackground(new Color(29,95,254));
            updateList(0);
            setDelete(0);
            CatSub.setText(actual.getID());
            CatArt .setText(actual.getID());
            TabPanel.setEnabledAt(1, true);
            updateList(1);
            limpiar(1);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void selectSubCategoria(String id) {
        try{
            controller.editSubCategoria(id);
            Subcategoria actual = controller.getCurrentSubcategoria();
            editar[1] = true;
            inputs[1][0].setEnabled(false);
            inputs[1][0].setText(actual.getID());
            inputs[1][1].setText(actual.getNombre());
            inputDes[1].setText(actual.getDescripcion());
            buttons[1][3].setEnabled(true);
            buttons[1][3].setBackground(new Color(29,95,254));
            updateList(1);
            setDelete(1);
            SubArt.setText(actual.getID());
            TabPanel.setEnabledAt(2, true);
            updateList(2);
            limpiar(2);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void selectArticulo(String id) {
        try{
            controller.editArticulo(id);
            Articulo actual = controller.getCurrentArticulo();
            editar[2] = true;
            inputs[2][0].setEnabled(false);
            inputs[2][0].setText(actual.getID());
            inputs[2][1].setText(actual.getNombre());
            inputDes[2].setText(actual.getDescripcion());
            buttons[2][3].setEnabled(true);
            buttons[2][3].setBackground(new Color(29,95,254));
            updateList(2);
            setDelete(2);
            //CatSub.setText(actual.getID());
            //TabPanel.setEnabledAt(1, true);
            //updateList(2);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void setDelete(int option) {
        switch(option){
            case 0: {
                if(controller.getCurrentCategoria().getSubcategorias().isEmpty()){
                    buttons[option][1].setEnabled(true);
                    buttons[option][1].setBackground(new Color(29,95,254));
                }else{
                    buttons[option][1].setEnabled(false);
                    buttons[option][1].setBackground(new Color(51,55,66));
                }
                break;
            }
            case 1:{
                if(controller.getCurrentSubcategoria().getArticulos().isEmpty()){
                    buttons[option][1].setEnabled(true);
                    buttons[option][1].setBackground(new Color(29,95,254));
                }else{
                    buttons[option][1].setEnabled(false);
                    buttons[option][1].setBackground(new Color(51,55,66));
                }
                break;
            }
            case 2:{
                if(controller.getCurrentArticulo().getPresentaciones().isEmpty()){
                    buttons[option][1].setEnabled(true);
                    buttons[option][1].setBackground(new Color(29,95,254));
                }else{
                    buttons[option][1].setEnabled(false);
                    buttons[option][1].setBackground(new Color(51,55,66));
                }
                break;
            }
        }
    }
    public void updateList(int option){
        try {
            lists[option].removeAll();
            int minimum=0;
            switch(option){
                case 0:{
                    List<Categoria> lista = controller.getCategorias();
                    if(lista.size()<5){
                        minimum = 5-lista.size();
                    }
                    lists[option].setLayout(new GridLayout(lista.size() + minimum + 1, 4, 5, 5));

                    setTextList(option,"ID");
                    setTextList(option,"Nombre");
                    setTextList(option,"Descripcion");
                    setTextList(option,"");
                    for(Categoria categoria : lista){
                        setTextInput(option,categoria.getID());
                        setTextInput(option,categoria.getNombre());
                        setTextInput(option,categoria.getDescripcion());
                        setButtonList(option, categoria.getID(), true);
                    }
                    setOptionsPref(option,minimum);
                    break;
                } case 1:{
                    List<Subcategoria> lista = controller.getCurrentCategoria().getSubcategorias();
                    if(lista.size()<5){
                        minimum = 5-lista.size();
                    }
                    lists[option].setLayout(new GridLayout(lista.size() + minimum + 1, 4, 5, 5));

                    setTextList(option,"ID");
                    setTextList(option,"Nombre");
                    setTextList(option,"Descripcion");
                    setTextList(option,"");
                    for(Subcategoria subcategoria : lista){
                        setTextInput(option,subcategoria.getID());
                        setTextInput(option,subcategoria.getNombre());
                        setTextInput(option,subcategoria.getDescripcion());
                        setButtonList(option, subcategoria.getID(), true);
                    }
                    setOptionsPref(option,minimum);
                    break;
                }
                case 2:{
                    List<Articulo> lista = controller.getCurrentSubcategoria().getArticulos();
                    if(lista.size()<5){
                        minimum = 5-lista.size();
                    }
                    lists[option].setLayout(new GridLayout(lista.size() + minimum + 1, 4, 5, 5));

                    setTextList(option,"ID");
                    setTextList(option,"Nombre");
                    setTextList(option,"Descripcion");
                    setTextList(option,"");
                    for(Articulo articulo : lista){
                        setTextInput(option,articulo.getID());
                        setTextInput(option,articulo.getNombre());
                        setTextInput(option,articulo.getDescripcion());
                        setButtonList(option, articulo.getID(), true);
                    }
                    setOptionsPref(option,minimum);
                    break;
                }
            }
            ListScroll[option].repaint();
            ListScroll[option].validate();
        } catch (Exception er) {
            JOptionPane.showMessageDialog(mainPanel, er.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void setOptionsPref(int option, int minimum){
        for (int i = 0; i < minimum; i++) {
            setTextInput(option,"");
            setTextInput(option,"");
            setTextInput(option,"");
            setButtonList(option,"",false);
        }
    }
    public void setTextList(int option,String text){
        JLabel textLabel = new JLabel(text);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setForeground(Color.WHITE);
        lists[option].add(textLabel);
    }
    public void setTextInput(int option,String text){
        JTextField data = new JTextField(text);
        setConfigTextField(data);
        lists[option].add(data);
    }
    public void setButtonList(int option,String id,boolean enabled){
        if(enabled){
            selectButton button = new selectButton(id,option);
            lists[option].add(button);
        }else{
            JButton button = new JButton("Seleccionar");
            button.setEnabled(false);
            button.setBackground(new Color(36, 39, 44));
            lists[option].add(button);
        }
    }
    public void setConfigTextField(JTextField change){
        change.setMinimumSize(new Dimension(100,20));
        change.setPreferredSize(new Dimension(100,20));
        change.setMaximumSize(new Dimension(100,20));
        change.setEditable(false);
        change.setBackground(new Color(36, 39, 44));
        change.setForeground(Color.WHITE);
        change.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public void saveData(int option){
        try{
            switch (option){
                case 0:{
                    Categoria data = new Categoria(inputs[option][0].getText(),inputs[option][1].getText(),inputDes[option].getText());
                    if (editar[0]) {
                        controller.editarCategoria(data);
                        JOptionPane.showMessageDialog(mainPanel, "Modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        controller.guardarCategoria(data);
                        JOptionPane.showMessageDialog(mainPanel, "Agregado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiar(0);
                    }
                    break;
                }
                case 1:{
                    Subcategoria data = new Subcategoria(inputs[option][0].getText(),inputs[option][1].getText(),inputDes[option].getText());
                    if (editar[1]) {
                        controller.editarSubCategoria(data);
                        JOptionPane.showMessageDialog(mainPanel, "Modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        controller.guardarSubCategoria(data);
                        JOptionPane.showMessageDialog(mainPanel, "Agregado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiar(1);
                        setDelete(0);
                    }
                    break;
                }
                case 2:{
                    Articulo data = new Articulo(inputs[option][0].getText(),inputs[option][1].getText(),inputDes[option].getText());
                    if (editar[2]) {
                        controller.editarArticulo(data);
                        JOptionPane.showMessageDialog(mainPanel, "Modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        controller.guardarArticulo(data);
                        JOptionPane.showMessageDialog(mainPanel, "Agregado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiar(2);
                        setDelete(1);
                    }
                    break;
                }
                default:{
                    throw new Exception("Opcion no valida");
                }
            }
            updateList(option);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void limpiar(int option){
        inputs[option][0].setText("");
        inputs[option][1].setText("");
        inputDes[option].setText("");
        buttons[option][3].setEnabled(false);
        buttons[option][3].setBackground(new Color(51, 55, 66));
        inputs[option][0].setEnabled(true);
        editar[option] = false;
        buttons[option][1].setEnabled(false);
        buttons[option][1].setBackground(new Color(51, 55, 66));
        TabPanel.setEnabledAt(0,false);
        TabPanel.setEnabledAt(1,false);
        TabPanel.setEnabledAt(2,false);
        for (int i=0; i<=option; i++){
            TabPanel.setEnabledAt(i,true);
        }
    }
    public void setAdd(int option){
        if(!inputDes[option].getText().isEmpty()&&!inputs[option][0].getText().isEmpty()&&!inputs[option][1].getText().isEmpty()) {
            buttons[option][0].setEnabled(true);
            buttons[option][0].setBackground(new Color(29,95,254));
        }else{
            buttons[option][0].setEnabled(false);
            buttons[option][0].setBackground(new Color(51,55,66));
        }
    }
    public JPanel getmainPanel() {
        return mainPanel;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private void createUIComponents() {
        ListCat = new JPanel();
        ListCat.setBackground(new Color(51,55,66));
        ListSub = new JPanel();
        ListSub.setBackground(new Color(51,55,66));
        ListArt = new JPanel();
        ListArt.setBackground(new Color(51,55,66));
        ListPre = new JPanel();
        ListPre.setBackground(new Color(51,55,66));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        ScrollCat = new JScrollPane(ListCat);
        ScrollCat.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
        ScrollSub = new JScrollPane(ListSub);
        ScrollSub.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
        ScrollArt = new JScrollPane(ListArt);
        ScrollArt.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
        ScrollPre = new JScrollPane(ListPre);
        ScrollPre.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));

    }
}
