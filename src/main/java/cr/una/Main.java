package cr.una;

import cr.una.Presentation.Controller.Controller;
import cr.una.Presentation.View.mainView;
import cr.una.Logic.Service;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//hola
public class Main {
    private static Controller main;
    private static JFrame window;

    public static void main(String[] args) {
        main = new Controller();
        mainView view = new mainView();
        main.startAplication(view);
        window = new JFrame();
        window.setContentPane(view.getPanel());
        window.setSize(1000, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try{
                    Service.instance().guardarXML();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        window.setTitle("Sistema de Gestion de Ferreteria");
        window.setVisible(true);
    }
}