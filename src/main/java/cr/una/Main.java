package cr.una;

import cr.una.FrontEnd.Presentation.Controller.Controller;


public class Main {
    private static Controller main;

    public static void main(String[] args) {
        main = new Controller();
        main.starLogin();
    }
}