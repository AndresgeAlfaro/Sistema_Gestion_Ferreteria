package cr.una.Presentation.View;

import cr.una.Logic.*;
import cr.una.Presentation.Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    private JTextField CantVenta;
    private JButton SavePre;
    private JButton DelPre;
    private JButton ClearPre;
    private JTextField IDArt;
    private JButton SearchArt;
    private JScrollPane ScrollArt;
    private JPanel ListArt;
    private JScrollPane ScrollPre;
    private JPanel ListPre;
    private JTextField PrecioCompra;
    private JTextField PrecioVenta;
    private JButton Bill;
    private JComboBox CatPed;
    private JComboBox SubPed;
    private JComboBox ArtPed;
    private JComboBox PrePed;
    private JTextField CantBuy;
    private JTextField CantSell;
    private JButton AddPed;
    private JScrollPane ScrollPed;
    private JPanel ListPed;
    private JTextField CantUnidad;

    private boolean[] editar = {false,false,false,false};

    private JTextField[][] inputs = {{CodCat,NameCat, IDCat},{CodSub,NameSub,IDSub},{CodArt,NameArt,IDArt}};

    private JButton[][] buttons = {{SaveCat,DelCat,SearchCat,ClearCat},{SaveSub,DelSub,SearchSub,ClearSub},{SaveArt,DelArt,SearchArt,ClearArt}};

    private JPanel[] lists = {ListCat,ListSub,ListArt,ListPre, ListPed};

    private JScrollPane[] ListScroll = {ScrollCat,ScrollSub,ScrollArt,ScrollPre,ScrollPed};

    private JTextArea[] inputDes = {DesCat,DesSub,DesArt};

    private JComboBox[] selections = {CatPed,SubPed,ArtPed,PrePed};

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
        TabPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(TabPanel.getSelectedIndex()==3){
                    activeBox(0);
                    controller.clearFactura();
                    updateFactura();
                }
            }
        });
        CantVenta.setBorder(null);
        CantBuy.setBorder(null);
        CantSell.setBorder(null);
        CantVenta.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAddPre();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                setAddPre();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                setAddPre();
            }
        });
        PrecioCompra.setBorder(null);
        PrecioCompra.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAddPre();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                setAddPre();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                setAddPre();
            }
        });
        PrecioVenta.setBorder(null);
        PrecioVenta.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAddPre();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                setAddPre();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                setAddPre();
            }
        });
        CantUnidad.setBorder(null);
        CantUnidad.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAddPre();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                setAddPre();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                setAddPre();
            }
        });
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
        SavePre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(3);
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
        DelPre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(3);
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
        ClearPre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarPre();
            }
        });
        CatPed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeBox(1);
                activeBox(2);
                activeBox(3);
            }
        });
        SubPed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeBox(2);
                activeBox(3);
            }
        });
        ArtPed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ArtPed.getItemCount()!=0){
                    activeBox(3);
                }
            }
        });
        PrePed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCant();
            }
        });
        CantSell.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setAddFact();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                setAddFact();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                setAddFact();
            }
        });
        AddPed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categoria categoria=(Categoria) CatPed.getSelectedItem();
                Subcategoria subcategoria = (Subcategoria) SubPed.getSelectedItem();
                Articulo articulo = (Articulo) ArtPed.getSelectedItem();
                Presentacion presentacion = (Presentacion) PrePed.getSelectedItem();
                try {
                    controller.addItemFact(new Factura(categoria,subcategoria,articulo,presentacion,Integer.parseInt(CantSell.getText())));
                    CatPed.setSelectedIndex(0);
                    updateFactura();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        Bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.billing();
                    JOptionPane.showMessageDialog(mainPanel, "Facturado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    CatPed.setSelectedIndex(0);
                    updateFactura();
                    limpiar(0);
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void updateFactura(){
        try {
            lists[4].removeAll();
            int minimum=0;
            List<Factura> lista = controller.getFacturas();
            if(lista.size()<8){
                minimum = 8-lista.size();
            }
            lists[4].setLayout(new GridLayout(lista.size() + minimum + 2, 5, 5, 5));

            double precioTotal=0;
            int cantArticulos=0;

            setTextList(4,"Articulo");
            setTextList(4,"Cantidad");
            setTextList(4,"Precio");
            setTextList(4,"Total");
            setTextList(4,"");
            for(Factura factura : lista){
                cantArticulos++;
                setTextInput(4,factura.getArticulo().getNombre() + " : " + factura.getPresentacion().getCantidad()+' '+factura.getPresentacion().getUnit());
                int cant = factura.getCantidad();
                setTextInput(4,String.valueOf(cant));
                double precio = factura.getPresentacion().getVenta();
                setTextInput(4,String.valueOf(precio)+'$');
                precio = precio * factura.getCantidad();
                if(cant>10){
                    precio=precio - (precio*0.10);
                }
                precioTotal+=precio;
                setTextInput(4,String.valueOf(precio)+'$');
                setButtonList(4, factura.getPresentacion() .getUnidad()+'|'+factura.getPresentacion().getCantidad(), true,"Borrar");
            }
            setOptionsPref(4,minimum, 4,"Borrar");
            setTextList(4,"");
            setTextList(4,"Precio");
            setTextList(4,"Total");
            double descuento = 0;
            if(cantArticulos>10){
                descuento = descuento+0.005;
            }
            if(precioTotal>5000){
                descuento=descuento+0.075;
            }
            setTextInput(4,String.valueOf(precioTotal+(precioTotal*descuento))+'$');
            setTextList(4,"");
            if(cantArticulos>0){
                Bill.setEnabled(true);
                Bill.setBackground(new Color(29,95,254));
            }else{
                Bill.setEnabled(false);
                Bill.setBackground(new Color(51,55,66));
            }
            ListScroll[4].repaint();
            ListScroll[4].validate();
        } catch (Exception er) {
            JOptionPane.showMessageDialog(mainPanel, er.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void setAddFact(){
        try{
            if(Integer.parseInt(CantBuy.getText())>=Integer.parseInt(CantSell.getText())){
                AddPed.setEnabled(true);
                AddPed.setBackground(new Color(29,95,254));

            }else{
                throw new Exception("No suficiente existencias");
            }
        }catch (Exception e){
            AddPed.setEnabled(false);
            AddPed.setBackground(new Color(51,55,66));
        }
    }
    public void setCant(){
        if(PrePed.getItemCount()!=0&&PrePed.getSelectedIndex()!=0){
            Presentacion actual = (Presentacion)PrePed.getSelectedItem();
            CantBuy.setText(String.valueOf(actual.getExistencia()));
            CantSell.setEnabled(true);
        }else{
            CantBuy.setText("");
            CantSell.setText("");
            CantSell.setEnabled(false);
        }
    }
    public void delete(int option) {
        try{
            switch (option) {
                case 0:{
                    controller.deleteCategoria();
                    limpiar(option);
                    break;
                }
                case 1:{
                    controller.deleteSubCategoria();
                    setDelete(0);
                    limpiar(option);
                    break;
                }
                case 2:{
                    controller.deleteArticulo();
                    setDelete(1);
                    limpiar(option);
                    break;
                }
                case 3:{
                    controller.deletePresentation();
                    setDelete(2);
                    limpiarPre();
                    break;
                }
            }
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
        public selectButton(String id, int option, String text) {
            this.id = id;
            this.option = option;
            this.setBackground(new Color(29,95,254));
            this.setText(text);
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
                        case 3:{
                            selectPresentacion(id);
                            break;
                        }
                        case 4:{
                            deleteItemFactura(id);
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
            setPresentation(true);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void selectPresentacion(String id) {
        try{
            controller.editPresentacion(id);
            Presentacion presentacion = controller.getCurrentPresentacion();
            editar[3] = true;
            ComboPre.setEnabled(false);
            ComboPre.setSelectedIndex(Integer.parseInt(presentacion.getUnidad()));
            CantUnidad.setEditable(false);
            CantUnidad.setText(String.valueOf(presentacion.getCantidad()));
            PrecioCompra.setText(String.valueOf(presentacion.getCompra()));
            PrecioVenta.setText(String.valueOf(presentacion.getVenta()));
            CantVenta.setText(String.valueOf(presentacion.getExistencia()));
            ClearPre.setEnabled(true);
            ClearPre.setBackground(new Color(29,95,254));
            updateList(3);
            DelPre.setEnabled(true);
            DelPre.setBackground(new Color(29,95,254));
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void setPresentation(boolean mode){
        limpiarPre();
        ComboPre.setEnabled(mode);
        CantVenta.setEnabled(mode);
        CantUnidad.setEnabled(mode);
        PrecioCompra.setEnabled(mode);
        PrecioVenta.setEnabled(mode);
        CantBuy.setEnabled(mode);
        if(mode){
            List<Medida> medidas = controller.getMedidas();
            for(Medida c : medidas){
                ComboPre.addItem(c);
            }
            mainPanel.revalidate();
            updateList(3);
        }else{
            ComboPre.removeAllItems();
            lists[3].removeAll();
            ListScroll[3].repaint();
            ListScroll[3].validate();
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
                        setButtonList(option, categoria.getID(), true,"Seleccionar");
                    }
                    setOptionsPref(option,minimum,3,"Seleccionar");
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
                        setButtonList(option, subcategoria.getID(), true,"Seleccionar");
                    }
                    setOptionsPref(option,minimum,3,"Seleccionar");
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
                        setButtonList(option, articulo.getID(), true,"Seleccionar");
                    }
                    setOptionsPref(option,minimum,3,"Seleccionar");
                    break;
                }
                case 3:{
                    List<Presentacion> lista = controller.getCurrentArticulo().getPresentaciones();
                    if(lista.size()<9){
                        minimum = 9-lista.size();
                    }
                    lists[option].setLayout(new GridLayout(lista.size() + minimum + 1, 6, 5, 5));

                    setTextList(option,"Unidad");
                    setTextList(option,"Cantidad");
                    setTextList(option,"Precio Compra");
                    setTextList(option,"Precio Venta");
                    setTextList(option,"Existencias");
                    setTextList(option,"");
                    for(Presentacion presentacion : lista){
                        setTextInput(option,controller.readMedida(presentacion.getUnidad()).getName());
                        setTextInput(option,String.valueOf(presentacion.getCantidad()));
                        setTextInput(option,String.valueOf(presentacion.getCompra())+'$');
                        setTextInput(option,String.valueOf(presentacion.getVenta())+'$');
                        setTextInput(option,String.valueOf(presentacion.getExistencia()));
                        setButtonList(option, presentacion.getUnidad()+'|'+presentacion.getCantidad(), true,"Seleccionar");
                    }
                    setOptionsPref(option,minimum, 5, "Seleccionar");
                    break;
                }
            }
            ListScroll[option].repaint();
            ListScroll[option].validate();
        } catch (Exception er) {
            JOptionPane.showMessageDialog(mainPanel, er.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void setOptionsPref(int option, int minimum, int cant, String text) {
        for (int i = 0; i < minimum; i++) {
            for (int j = 0; j < cant; j++) {
                setTextInput(option,"");
            }
            setButtonList(option,"",false,text);
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
    public void setButtonList(int option,String id,boolean enabled, String text){
        if(enabled){
            selectButton button = new selectButton(id,option,text);
            lists[option].add(button);
        }else{
            JButton button = new JButton(text);
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
                case 3:{
                    Medida medida = (Medida) ComboPre.getSelectedItem();
                    Presentacion data = new Presentacion(medida.getID(),Double.parseDouble (CantUnidad.getText()) ,Double.parseDouble(PrecioCompra.getText()),Double.parseDouble(PrecioVenta.getText()),Integer.parseInt (CantVenta.getText()));
                    if (editar[3]) {
                        controller.editarPresentacion(data);
                        JOptionPane.showMessageDialog(mainPanel, "Modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        controller.guardarPresentacion(data);
                        JOptionPane.showMessageDialog(mainPanel, "Agregado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiarPre();
                        setDelete(2);
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
        setPresentation(false);
    }
    public void limpiarPre(){
        ComboPre.setEnabled(true);
        if(ComboPre.getItemCount()!=0){
            ComboPre.setSelectedIndex(0);
        }
        CantUnidad.setText("");
        CantUnidad.setEditable(true);
        PrecioCompra.setText("");
        PrecioVenta.setText("");
        CantVenta.setText("");
        DelPre.setEnabled(false);
        editar[3] = false;
        DelPre.setBackground(new Color(36,39,44));
        ClearPre.setEnabled(false);
        ClearPre.setBackground(new Color(36,39,44));
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
    public void setAddPre(){
        if(!CantUnidad.getText().isEmpty()&&!PrecioVenta.getText().isEmpty()&&!PrecioCompra.getText().isEmpty()&&!CantVenta.getText().isEmpty()) {
            SavePre.setEnabled(true);
            SavePre.setBackground(new Color(29,95,254));
        }else{
            SavePre.setEnabled(false);
            SavePre.setBackground(new Color(36,39,44));
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
        ListPed = new JPanel();
        ListPed.setBackground(new Color(51,55,66));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        ScrollCat = new JScrollPane(ListCat);
        ScrollCat.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
        ScrollSub = new JScrollPane(ListSub);
        ScrollSub.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
        ScrollArt = new JScrollPane(ListArt);
        ScrollArt.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
        ScrollPre = new JScrollPane(ListPre);
        ScrollPre.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
        ScrollPed = new JScrollPane(ListPed);
        ScrollPed.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
    }
    public void activeBox(int option){
        try{
            switch(option){
                case 0:{
                    selections[option].removeAllItems();
                    selections[option].addItem("[ Seleccione una Opcion ]");
                    for(Categoria a : controller.getCategorias()){
                        selections[option].addItem(a);
                    }
                    break;
                }
                case 1:{
                    selections[option].removeAllItems();
                    if(selections[option-1].getSelectedIndex()!=0){
                        selections[option].setEnabled(true);
                        selections[option].addItem("[ Seleccione una Opcion ]");
                        for(Subcategoria a : controller.getSubcategorias((Categoria) selections[option-1].getSelectedItem())){
                            selections[option].addItem(a);
                        }
                    }else{
                        throw new Exception("No se puede seleccionar una opcion");
                    }
                    break;
                }
                case 2:{
                    selections[option].removeAllItems();
                    if(selections[option-1].getSelectedIndex()!=0){
                        selections[option].setEnabled(true);
                        selections[option].addItem("[ Seleccione una Opcion ]");
                        for(Articulo a : controller.getArticulos((Subcategoria) selections[option-1].getSelectedItem())){
                            selections[option].addItem(a);
                        }
                    }else{
                        throw new Exception("No se puede seleccionar una opcion");
                    }
                    break;
                }
                case 3:{
                    selections[option].removeAllItems();
                    if(selections[option-1].getSelectedIndex()!=0){
                        selections[option].setEnabled(true);
                        selections[option].addItem("[ Seleccione una Opcion ]");
                        for(Presentacion a : controller.getPresentaciones((Articulo) selections[option-1].getSelectedItem())){
                            selections[option].addItem(a);
                        }
                    }else{
                        throw new Exception("No se puede seleccionar una opcion");
                    }
                    break;
                }
            }
        }catch (Exception ex){
            selections[option].removeAllItems();
            selections[option].setEnabled(false);
        }

    }
    public void deleteItemFactura(String id){
        controller.deleteItemFactura(id);
        updateFactura();
    }
}
