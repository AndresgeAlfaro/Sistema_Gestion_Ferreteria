package cr.una.Presentation.View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

import cr.una.Logic.Articulo;
import cr.una.Logic.Presentacion;
import cr.una.Logic.Subcategoria;
import cr.una.Presentation.Controller.Controller;
import cr.una.Logic.Categoria;


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
    private JTextField InputCatViewArt;
    private JTextField InputSubViewArt;
    private JTextField InputNameViewArt;
    private JTextField InputCodeViewArt;
    private JTextArea InputDescriptionArt;
    private JButton BtnSaveArt;
    private JTextField InputNameSearchArt;
    private JTextField InputIdSearchArt;
    private JButton BtnSearchArt;
    private JPanel PanelCategoria;
    private JButton ListSelect1Cat;
    private JButton ListSelect2Cat;
    private JButton ListSelect3Cat;
    private JButton ListSelect4Cat;
    private JButton ListSelect5Cat;
    private JButton ListBackCat;
    private JButton ListContinueCat;
    private JTextField ListID1Cat;
    private JTextField ListName1Cat;
    private JTextField ListDescription1Cat;
    private JTextField ListID2Cat;
    private JTextField ListName2Cat;
    private JTextField ListDescription2Cat;
    private JTextField ListID3Cat;
    private JTextField ListName3Cat;
    private JTextField ListDescription3Cat;
    private JTextField ListID4Cat;
    private JTextField ListName4Cat;
    private JTextField ListDescription4Cat;
    private JTextField ListID5Cat;
    private JTextField ListName5Cat;
    private JTextField ListDescription5Cat;
    private JButton BtnDeleteCat;
    private JButton BtnClearCat;
    private JButton BtnDeleteSub;
    private JButton BtnClearSub;
    private JTextField ListID1Sub;
    private JTextField ListName1Sub;
    private JTextField ListDescription1Sub;
    private JTextField ListID2Sub;
    private JTextField ListName2Sub;
    private JTextField ListDescription2Sub;
    private JTextField ListID3Sub;
    private JTextField ListName3Sub;
    private JTextField ListDescription3Sub;
    private JTextField ListID4Sub;
    private JTextField ListName4Sub;
    private JTextField ListDescription4Sub;
    private JTextField ListID5Sub;
    private JTextField ListName5Sub;
    private JTextField ListDescription5Sub;
    private JButton ListBackSub;
    private JButton ListContinueSub;
    private JButton BtnDeleteArt;
    private JButton BtnClearArt;
    private JTextField ListID1Art;
    private JTextField ListName1Art;
    private JTextField ListDescription1Art;
    private JTextField ListID2Art;
    private JTextField ListName2Art;
    private JTextField ListDescription2Art;
    private JTextField ListID3Art;
    private JTextField ListName3Art;
    private JTextField ListDescription3Art;
    private JTextField ListID4Art;
    private JTextField ListName4Art;
    private JTextField ListDescription4Art;
    private JTextField ListID5Art;
    private JTextField ListName5Art;
    private JTextField ListDescription5Art;
    private JButton ListBackArt;
    private JButton ListContinueArt;
    private JTextField InputUnit;
    private JTextField InputCapacity;
    private JButton BtnSavePre;
    private JButton BtnDeletePre;
    private JTextField InputListUnit1;
    private JTextField InputListCapacity1;
    private JButton BtnDeletePre1;
    private JTextField InputListUnit2;
    private JTextField InputListCapacity2;
    private JButton BtnDeletePre2;
    private JTextField InputListUnit3;
    private JTextField InputListCapacity3;
    private JButton BtnDeletePre3;
    private JTextField InputListUnit4;
    private JTextField InputListCapacity4;
    private JButton BtnDeletePre4;
    private JTextField InputListUnit5;
    private JTextField InputListCapacity5;
    private JButton BtnDeletePre5;
    private JButton BtnBackPre;
    private JButton BtnContinuePre;
    private JButton BtnClearPre;
    int indexList = 0;
    int indexListPresentation = 0;
    boolean[] editar = {false,false,false,false};
    private Controller controller;
    JButton[] saveButtons = {BtnSaveCat,BtnSaveSub,BtnSaveArt,BtnSavePre};
    JButton[] backButtons = {ListBackCat,ListBackSub,ListBackArt,BtnBackPre};
    JButton[] continueButtons = {ListContinueCat,ListContinueSub,ListContinueArt,BtnContinuePre};
    JButton[] searchButtons = {BtnSearchCat,BtnSearchSub,BtnSearchArt};
    JButton[] clearButtons = {BtnClearCat,BtnClearSub,BtnClearArt};
    JButton[] deleteButtons = {BtnDeleteCat,BtnDeleteSub,BtnDeleteArt};
    JButton[] selectButtons = {BtnDeletePre1, BtnDeletePre2, BtnDeletePre3, BtnDeletePre4, BtnDeletePre5};
    JTextField[] codeViewFilds = {InputCodeViewCat,InputCodeViewSub,InputCodeViewArt};
    JTextField[] nameFilds = {InputNameViewCat,InputNameViewSub,InputNameViewArt};
    JTextArea[] descriptionFilds = {InputDescriptionCat,InputDescriptionSub,InputDescriptionArt};
    JTextField[] idSearchField = {InputIdSearchCat,InputIdSearchSub,InputIdSearchArt};
    JTextField[] ListUnitFilds = {InputListUnit1,InputListUnit2,InputListUnit3,InputListUnit4,InputListUnit5};
    JTextField[] ListCapacityFilds = {InputListCapacity1,InputListCapacity2,InputListCapacity3,InputListCapacity4,InputListCapacity5};
    JTextField[][] idListFilds = {{ListID1Cat,ListID2Cat,ListID3Cat,ListID4Cat,ListID5Cat},
            {ListID1Sub,ListID2Sub,ListID3Sub,ListID4Sub,ListID5Sub},
            {ListID1Art,ListID2Art,ListID3Art,ListID4Art,ListID5Art}};
    JTextField[][] nameListFilds = {{ListName1Cat,ListName2Cat,ListName3Cat,ListName4Cat,ListName5Cat},
            {ListName1Sub,ListName2Sub,ListName3Sub,ListName4Sub,ListName5Sub},
            {ListName1Art,ListName2Art,ListName3Art,ListName4Art,ListName5Art}};
    JTextField[][] descriptionListFilds = {{ListDescription1Cat,ListDescription2Cat,ListDescription3Cat,ListDescription4Cat,ListDescription5Cat},
            {ListDescription1Sub,ListDescription2Sub,ListDescription3Sub,ListDescription4Sub,ListDescription5Sub},
            {ListDescription1Art,ListDescription2Art,ListDescription3Art,ListDescription4Art,ListDescription5Art}};

    public mainView() {
        PanelOpciones.setEnabledAt(1,false);
        PanelOpciones.setEnabledAt(2,false);
        InputCodeViewCat.setBorder(null);
        InputNameViewCat.setBorder(null);
        InputIdSearchCat.setBorder(null);
        InputCatViewSub.setBorder(null);
        InputCodeViewSub.setBorder(null);
        InputNameViewSub.setBorder(null);
        InputIdSearchSub.setBorder(null);
        InputCatViewArt.setBorder(null);
        InputSubViewArt.setBorder(null);
        InputCodeViewArt.setBorder(null);
        InputNameViewArt.setBorder(null);
        InputIdSearchArt.setBorder(null);
        InputCapacity.setBorder(null);
        InputUnit.setBorder(null);
        InputCodeViewCat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(0);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(0);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(0);
            }
        });
        InputNameViewCat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(0);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(0);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(0);
            }
        });
        InputDescriptionCat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(0);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(0);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(0);
            }
        });
        InputCodeViewArt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(2);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(2);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(2);
            }
        });
        InputNameViewArt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(2);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(2);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(2);
            }
        });
        InputIdSearchCat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SearchBtn(0);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SearchBtn(0);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SearchBtn(0);
            }
        });
        InputDescriptionArt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SearchBtn(0);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SearchBtn(0);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SearchBtn(0);
            }
        });
        InputIdSearchSub.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SearchBtn(1);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SearchBtn(1);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SearchBtn(1);
            }
        });
        InputIdSearchArt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SearchBtn(2);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SearchBtn(2);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SearchBtn(2);
            }
        });
        BtnSaveCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Categoria data = new Categoria(InputCodeViewCat.getText().toUpperCase(),InputNameViewCat.getText(),InputDescriptionCat.getText());
                    if (editar[0]) {
                        controller.editarCategoria(data);
                        JOptionPane.showMessageDialog(panel1, "Modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        controller.guardarCategoria(data);
                        JOptionPane.showMessageDialog(panel1, "Agregado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiar(0);
                    }
                    actualizarListaCategoria();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        BtnSearchCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.editCategoria(InputIdSearchCat.getText().toUpperCase());
                    editar[0] = true;
                    InputCodeViewCat.setEnabled(false);
                    InputIdSearchCat.setEnabled(false);
                    BtnSearchCat.setEnabled(false);
                    BtnClearCat.setEnabled(true);
                    BtnSearchCat.setBackground(new Color(51, 55, 66));
                    BtnClearCat.setBackground(new Color(29,95,254));
                    update();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        BtnSearchSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.editSubCategoria(InputIdSearchSub.getText().toUpperCase());
                    editar[1] = true;
                    InputCodeViewSub.setEnabled(false);
                    InputIdSearchSub.setEnabled(false);
                    BtnSearchSub.setEnabled(false);
                    BtnClearSub.setEnabled(true);
                    BtnSearchSub.setBackground(new Color(51, 55, 66));
                    BtnClearSub.setBackground(new Color(29,95,254));
                    update();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        BtnDeleteCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.getCurrentCategoria().getSubcategorias().isEmpty()){
                    try{
                        controller.deleteCategoria();
                        editar[0] = false;
                        limpiar(0);
                        JOptionPane.showMessageDialog(panel1, "Eliminado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if((indexList*5)>=controller.getCategoriasSize()){
                        indexList--;
                    }
                    actualizarListaCategoria();
                }

            }
        });
        BtnClearCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.resetCurrentCategoria();
                controller.resetCurrentSubCategoria();
                controller.resetCurrentArticulo();
                limpiar(0);
            }
        });
        ListContinueCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexList++;
                actualizarListaCategoria();
            }
        });
        ListBackCat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexList--;
                actualizarListaCategoria();
            }
        });
        PanelOpciones.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                indexList=0;
                actualizarListaCategoria();
                if(controller.getCurrentCategoria()!=null){
                    actualizarListaSubCategoria();
                }
                if(controller.getCurrentSubcategoria()!=null){
                    actualizarListaArticulo();
                }
                if(controller.getCurrentArticulo()==null){
                    actualizarListaPresentacion(1);
                    presentationWindow(1);
                }
            }
        });
        InputCodeViewSub.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(1);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(1);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(1);
            }
        });
        InputNameViewSub.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(1);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(1);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(1);
            }
        });
        InputDescriptionArt.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(2);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(2);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(2);
            }
        });
        InputDescriptionSub.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtn(1);
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtn(1);
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtn(1);
            }
        });
        BtnSaveSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Subcategoria data = new Subcategoria(InputCodeViewSub.getText().toUpperCase(),InputNameViewSub.getText(),InputDescriptionSub.getText());
                    if (editar[1]) {
                        controller.editarSubCategoria(data);
                        JOptionPane.showMessageDialog(panel1, "Modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        controller.guardarSubCategoria(data);
                        JOptionPane.showMessageDialog(panel1, "Agregado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiar(1);
                    }
                    update();
                    actualizarListaSubCategoria();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        BtnDeleteSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.getCurrentSubcategoria().getArticulos().isEmpty()){
                    try{
                        controller.deleteSubCategoria();
                        editar[1] = false;
                        limpiar(1);
                        JOptionPane.showMessageDialog(panel1, "Eliminado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                update();
                if((indexList*5)>=controller.getSubCategoriasSize()){
                    indexList--;
                }
                actualizarListaSubCategoria();
            }
        });
        BtnClearSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.resetCurrentSubCategoria();
                controller.resetCurrentArticulo();
                limpiar(1);
            }
        });
        BtnSaveArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Articulo data = new Articulo(InputCodeViewArt.getText().toUpperCase(),InputNameViewArt.getText(),InputDescriptionArt.getText());
                    if (editar[2]) {
                        controller.editarArticulo(data);
                        JOptionPane.showMessageDialog(panel1, "Modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        controller.guardarArticulo(data);
                        JOptionPane.showMessageDialog(panel1, "Agregado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiar(2);
                    }
                    update();
                    actualizarListaArticulo();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        ListBackSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexList--;
                actualizarListaSubCategoria();
            }
        });
        ListContinueSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexList++;
                actualizarListaSubCategoria();
            }
        });
        BtnSearchArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.editArticulo(InputIdSearchArt.getText().toUpperCase());
                    editar[2] = true;
                    InputCodeViewArt.setEnabled(false);
                    InputIdSearchArt.setEnabled(false);
                    BtnSearchArt.setEnabled(false);
                    BtnClearArt.setEnabled(true);
                    BtnSearchArt.setBackground(new Color(51, 55, 66));
                    BtnClearArt.setBackground(new Color(29,95,254));
                    update();
                    presentationWindow(0);
                    actualizarListaPresentacion(0);
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        BtnDeleteArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.getCurrentArticulo().getPresentaciones().isEmpty()){
                    try{
                        controller.deleteArticulo();
                        editar[2] = false;
                        limpiar(2);
                        JOptionPane.showMessageDialog(panel1, "Eliminado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                update();
                if((indexList*5)>=controller.getArticulosSize()){
                    indexList--;
                }
                actualizarListaArticulo();
            }
        });
        BtnClearArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.resetCurrentArticulo();
                limpiar(2);
                actualizarListaPresentacion(1);
                presentationWindow(1);
            }
        });
        InputUnit.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtnPre();
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtnPre();
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtnPre();
            }
        });
        InputCapacity.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SaveBtnPre();
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                SaveBtnPre();
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                SaveBtnPre();
            }
        });
        BtnSavePre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Presentacion data = new Presentacion(InputUnit.getText().toUpperCase(),InputCapacity.getText().toUpperCase());
                    if (editar[3]) {
                        controller.editarPresentacion(data);
                        JOptionPane.showMessageDialog(panel1, "Modificado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        controller.guardarPresentacion(data);
                        JOptionPane.showMessageDialog(panel1, "Agregado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        limpiarPre();
                    }
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                actualizarListaPresentacion(0);
            }
        });
        BtnBackPre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexListPresentation--;
                actualizarListaPresentacion(0);
            }
        });
        ListBackArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexList--;
                actualizarListaArticulo();
            }
        });
        ListContinueArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexList++;
                actualizarListaArticulo();
            }
        });
        BtnContinuePre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexListPresentation++;
                actualizarListaPresentacion(0);
            }
        });
        BtnDeletePre1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePresentation(0);
            }
        });
        BtnDeletePre2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePresentation(1);
            }
        });
        BtnDeletePre3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePresentation(2);
            }
        });
        BtnDeletePre4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePresentation(3);
            }
        });
        BtnDeletePre5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePresentation(4);
            }
        });
    }
    public void SearchBtn(int index) {

        if(!idSearchField[index].getText().isEmpty()) {
            searchButtons[index].setEnabled(true);
            searchButtons[index].setBackground(new Color(29,95,254));
        }else{
            searchButtons[index].setEnabled(false);
            searchButtons[index].setBackground(new Color(51,55,66));
        }
    }
    public void SaveBtn(int index) {
        if(!codeViewFilds[index].getText().isEmpty()&&!nameFilds[index].getText().isEmpty()&&!descriptionFilds[index].getText().isEmpty()) {
            saveButtons[index].setEnabled(true);
            saveButtons[index].setBackground(new Color(29,95,254));
        }else{
            saveButtons[index].setEnabled(false);
            saveButtons[index].setBackground(new Color(51,55,66));
        }
    }
    public void SaveBtnPre(){
        if(!InputCapacity.getText().isEmpty()&&!InputUnit.getText().isEmpty()) {
            saveButtons[3].setEnabled(true);
            saveButtons[3].setBackground(new Color(29,95,254));
        }else{
            saveButtons[3].setEnabled(false);
            saveButtons[3].setBackground(new Color(51,55,66));
        }
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public JPanel getPanel(){
        return panel1;
    }
    public Controller getController() {return controller;}
    public void update() {
        Categoria i = controller.getCurrentCategoria();
        if(i!=null){
            InputCodeViewCat.setText(i.getID());
            InputNameViewCat.setText(i.getNombre());
            InputDescriptionCat.setText(i.getDescripcion());
            PanelOpciones.setEnabledAt(1,true);
            InputCatViewSub.setText(i.getID());
            if(i.getSubcategorias().isEmpty()){
                BtnDeleteCat.setEnabled(true);
                BtnDeleteCat.setBackground(new Color(29,95,254));
            }else{
                BtnDeleteCat.setEnabled(false);
                BtnDeleteCat.setBackground(new Color(51,55,66));
            }
        }
        Subcategoria e = controller.getCurrentSubcategoria();
        if(e!=null){
            InputCodeViewSub.setText(e.getID());
            InputNameViewSub.setText(e.getNombre());
            InputDescriptionSub.setText(e.getDescripcion());
            PanelOpciones.setEnabledAt(2,true);
            InputCatViewArt.setText(i.getID());
            InputSubViewArt.setText(e.getID());
            if(e.getArticulos().isEmpty()){
                BtnDeleteSub.setEnabled(true);
                BtnDeleteSub.setBackground(new Color(29,95,254));
            }else{
                BtnDeleteSub.setEnabled(false);
                BtnDeleteSub.setBackground(new Color(51,55,66));
            }
        }
        Articulo a = controller.getCurrentArticulo();
        if(a!=null){
            InputCodeViewArt.setText(a.getID());
            InputNameViewArt.setText(a.getNombre());
            InputDescriptionArt.setText(a.getDescripcion());
            if(a.getPresentaciones().isEmpty()){
                BtnDeleteArt.setEnabled(true);
                BtnDeleteArt.setBackground(new Color(29,95,254));
            }else{
                BtnDeleteArt.setEnabled(false);
                BtnDeleteArt.setBackground(new Color(51,55,66));
            }
        }
        panel1.revalidate();
    }
    public void limpiar(int index) {

        codeViewFilds[index].setText("");
        nameFilds[index].setText("");
        descriptionFilds[index].setText("");
        idSearchField[index].setText("");
        editar[index] = false;
        searchButtons[index].setEnabled(false);
        searchButtons[index].setBackground(new Color(51,55,66));
        clearButtons[index].setEnabled(false);
        clearButtons[index].setBackground(new Color(51,55,66));
        codeViewFilds[index].setEnabled(true);
        saveButtons[index].setEnabled(false);
        saveButtons[index].setBackground(new Color(51,55,66));
        deleteButtons[index].setEnabled(false);
        deleteButtons[index].setBackground(new Color(51,55,66));
        if(index<2){
            PanelOpciones.setEnabledAt(index+1,false);
            limpiar(index+1);
        }
        idSearchField[index].setEnabled(true);

    }
    public void limpiarPre() {
        InputCodeViewSub.setText("");
    }
    public void actualizarListaCategoria(){

        for(int i=0;i<5;i++){
            idListFilds[0][i].setText("");
            nameListFilds[0][i].setText("");
            descriptionListFilds[0][i].setText("");
        }
        for(int i=0;i<5&&i!=(getSizeList(0)-(indexList*5));i++){
            Categoria user=controller.getCategoria(i+(indexList*5));
            if(user!=null){
                idListFilds[0][i].setText(user.getID());
                nameListFilds[0][i].setText(user.getNombre());
                descriptionListFilds[0][i].setText(user.getDescripcion());
            }
        }
        if(getSizeList(0)>(indexList+1)*5){
            continueButtons[0].setEnabled(true);
            continueButtons[0].setBackground(new Color(29,95,254));
        }else{
            continueButtons[0].setEnabled(false);
            continueButtons[0].setBackground(new Color(51,55,66));
        }
        if(indexList!=0){
            backButtons[0].setEnabled(true);
            backButtons[0].setBackground(new Color(29,95,254));
        }else{
            backButtons[0].setEnabled(false);
            backButtons[0].setBackground(new Color(51,55,66));
        }

    }
    public void actualizarListaSubCategoria(){

        for(int i=0;i<5;i++){
            idListFilds[1][i].setText("");
            nameListFilds[1][i].setText("");
            descriptionListFilds[1][i].setText("");
        }
        for(int i=0;i<5&&i!=(getSizeList(1)-(indexList*5));i++){
            Subcategoria user=controller.getSubCategoria(i+(indexList*5));
            if(user!=null){
                idListFilds[1][i].setText(user.getID());
                nameListFilds[1][i].setText(user.getNombre());
                descriptionListFilds[1][i].setText(user.getDescripcion());
            }
        }
        if(getSizeList(1)>(indexList+1)*5){
            continueButtons[1].setEnabled(true);
            continueButtons[1].setBackground(new Color(29,95,254));
        }else{
            continueButtons[1].setEnabled(false);
            continueButtons[1].setBackground(new Color(51,55,66));
        }
        if(indexList!=0){
            backButtons[1].setEnabled(true);
            backButtons[1].setBackground(new Color(29,95,254));
        }else{
            backButtons[1].setEnabled(false);
            backButtons[1].setBackground(new Color(51,55,66));
        }

    }
    public void actualizarListaArticulo(){

        for(int i=0;i<5;i++){
            idListFilds[2][i].setText("");
            nameListFilds[2][i].setText("");
            descriptionListFilds[2][i].setText("");
        }
        for(int i=0;i<5&&i!=(getSizeList(2)-(indexList*5));i++){
            Articulo user=controller.getArticulos(i+(indexList*5));
            if(user!=null){
                idListFilds[2][i].setText(user.getID());
                nameListFilds[2][i].setText(user.getNombre());
                descriptionListFilds[2][i].setText(user.getDescripcion());
            }
        }
        if(getSizeList(2)>(indexList+1)*5){
            continueButtons[2].setEnabled(true);
            continueButtons[2].setBackground(new Color(29,95,254));
        }else{
            continueButtons[2].setEnabled(false);
            continueButtons[2].setBackground(new Color(51,55,66));
        }
        if(indexList!=0){
            backButtons[2].setEnabled(true);
            backButtons[2].setBackground(new Color(29,95,254));
        }else{
            backButtons[2].setEnabled(false);
            backButtons[2].setBackground(new Color(51,55,66));
        }

    }
    public void actualizarListaPresentacion(int option){
        if(option==1){
            for(int i=0;i<5;i++){
                ListUnitFilds[i].setText("");
                ListCapacityFilds[i].setText("");
                selectButtons[i].setEnabled(false);
                selectButtons[i].setBackground(new Color(51,55,66));
            }
            continueButtons[3].setEnabled(false);
            continueButtons[3].setBackground(new Color(51,55,66));
            backButtons[3].setEnabled(false);
            backButtons[3].setBackground(new Color(51,55,66));
            indexListPresentation=0;
        }else{
            for(int i=0;i<5;i++){
                ListUnitFilds[i].setText("");
                ListCapacityFilds[i].setText("");
                selectButtons[i].setEnabled(false);
                selectButtons[i].setBackground(new Color(51,55,66));
            }
            for(int i=0;i<5&&i!=(getSizeList(3)-(indexListPresentation*5));i++){
                Presentacion user=controller.getPresentaciones(i+(indexListPresentation*5));
                if(user!=null){
                    ListUnitFilds[i].setText(user.getUnidad());
                    ListCapacityFilds[i].setText(user.getCantidad());
                    selectButtons[i].setEnabled(true);
                    selectButtons[i].setBackground(new Color(29,95,254));
                }
            }
            if(getSizeList(3)>(indexListPresentation+1)*5){
                continueButtons[3].setEnabled(true);
                continueButtons[3].setBackground(new Color(29,95,254));
            }else{
                continueButtons[3].setEnabled(false);
                continueButtons[3].setBackground(new Color(51,55,66));
            }
            if(indexListPresentation!=0){
                backButtons[3].setEnabled(true);
                backButtons[3].setBackground(new Color(29,95,254));
            }else{
                backButtons[3].setEnabled(false);
                backButtons[3].setBackground(new Color(51,55,66));
            }
        }
    }
    public int getSizeList(int index){
        switch(index){
            case 0:
                return controller.getCategoriasSize();
            case 1:
                return controller.getSubCategoriasSize();
            case 2:
                return controller.getArticulosSize();
                case 3:
                    return controller.getPresentacionSize();
        }
        return 0;
    }
    public void presentationWindow(int option){
        InputUnit.setText("");
        InputCapacity.setText("");
        if(option==0){
            InputUnit.setEditable(true);
            InputCapacity.setEditable(true);
        }else{
            InputUnit.setEditable(false);
            InputCapacity.setEditable(false);
            BtnSavePre.setEnabled(false);
        }
    }
    public void deletePresentation(int index){
        try{
            controller.deletePresentation(index+(indexListPresentation*5));
            JOptionPane.showMessageDialog(panel1, "Eliminado con exito", "Información", JOptionPane.INFORMATION_MESSAGE);

        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        if((indexListPresentation*5)>=controller.getPresentacionSize()){
            indexListPresentation--;
        }
        actualizarListaPresentacion(0);
    }
}
