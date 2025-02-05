package cr.una.BackEnd.Server;

import cr.una.BackEnd.Logic.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado en puerto " + PORT);
            Service service = Service.instance();
            service.cargarXML();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket, service).start();
            }
        } catch (Exception e) {
            System.err.println("Error en servidor: " + e.getMessage());
        }
    }
}