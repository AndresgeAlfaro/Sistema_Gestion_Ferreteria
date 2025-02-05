package cr.una;

import cr.una.Presentation.Controller.Controller;
import cr.una.Presentation.View.View;
import cr.una.Logic.Service;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {
    private static Controller main;

    public static void main(String[] args) {
        main = new Controller();
        main.starLogin();
    }
}