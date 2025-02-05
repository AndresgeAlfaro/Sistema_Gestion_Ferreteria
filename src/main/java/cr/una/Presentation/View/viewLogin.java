package cr.una.Presentation.View;

import cr.una.Logic.Service;
import cr.una.Presentation.Controller.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class viewLogin {
    static private JFrame frame;
    private JTextField usernameInput;
    private JPanel mainPanel;
    private JPasswordField passwordInput;
    private JButton loginButton;
    private JCheckBox passwordCheck;
    private JButton registerButton;
    private JLabel Title;
    private JLabel usernameTitle;

    private Controller controller;


    public viewLogin() {
        frame  = new JFrame();
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try{
                    Service.instance().guardarXML();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setTitle("Login");
        frame.setVisible(true);

        usernameInput.setBorder(null);
        passwordInput.setBorder(null);
        passwordCheck.setBorder(null);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(controller.checkLogin(usernameInput.getText(), new String(passwordInput.getPassword()))){
                        frame.dispose();
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        usernameInput.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                change();
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                change();
            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                change();
            }
            public void change() {
                if(!usernameInput.getText().isEmpty()&&!passwordInput.getText().isEmpty()) {
                    loginButton.setEnabled(true);
                    loginButton.setBackground(Color.getHSBColor(0.61f,0.89f,1f));
                }else{
                    loginButton.setEnabled(false);
                    loginButton.setBackground(Color.getHSBColor(0.62f,0.23f,0.26f));
                }
            }
        });
        passwordInput.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                change();
            }
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                change();

            }
            @Override
            public void removeUpdate(DocumentEvent e)
            {
                change();
            }
            public void change() {
                if(!usernameInput.getText().isEmpty()&&!passwordInput.getText().isEmpty()) {
                    loginButton.setEnabled(true);
                    loginButton.setBackground(Color.getHSBColor(0.61f,0.89f,1f));
                }else{
                    loginButton.setEnabled(false);
                    loginButton.setBackground(Color.getHSBColor(0.62f,0.23f,0.26f));
                }
            }
        });

        passwordCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(passwordCheck.isSelected()) {
                    passwordCheck.setIcon(controller.getIcon(1));
                    passwordInput.setEchoChar((char) 0);
                }else{
                    passwordCheck.setIcon(controller.getIcon(0));
                    passwordInput.setEchoChar('•');
                }
            }
        });
    }
    public void initIcon(){
        passwordCheck.setIcon(controller.getIcon(0));
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
