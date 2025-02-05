package cr.una.BackEnd.Server;

import cr.una.BackEnd.Logic.*;
import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private final Service service;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ClientHandler(Socket socket, Service service) {
        this.clientSocket = socket;
        this.service = service;
    }

    public void run() {
        try {
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());

            while (true) {
                String command = (String) input.readObject();
                switch (command) {
                    case "LOGIN":
                        handleLogin();
                        break;
                    case "GET_CATEGORIAS":
                        sendCategorias();
                        break;
                    case "GUARDAR_CATEGORIA":
                        guardarCategoria();
                        break;
                    case "GET_MEDIDAS":
                        sendMedidas();
                        break;
                    case "REALIZAR_VENTA":
                        realizarVenta();
                        break;
                    default:
                        sendError("Comando no reconocido");
                }
            }
        } catch (Exception e) {
            System.out.println("Cliente desconectado: " + e.getMessage());
        }
    }

    private void handleLogin() throws IOException, ClassNotFoundException {
        try {
            User user = (User) input.readObject();
            User storedUser = service.getUsers().stream()
                    .filter(u -> u.getUsername().equals(user.getUsername()))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));

            if (!storedUser.getPassword().equals(user.getPassword())) {
                sendError("Contraseña incorrecta");
                return;
            }
            if (storedUser.getState().equals("Bloqueado")) {
                sendError("Usuario bloqueado");
                return;
            }
            sendSuccess();
        } catch (Exception e) {
            sendError(e.getMessage());
        }
    }

    private void sendCategorias() throws IOException {
        try {
            List<Categoria> categorias = service.getCategorias();
            sendSuccess();
            output.writeObject(categorias);
        } catch (Exception e) {
            sendError(e.getMessage());
        }
    }

    private void guardarCategoria() throws IOException, ClassNotFoundException {
        try {
            Categoria categoria = (Categoria) input.readObject();
            service.guardarCategoria(categoria);
            sendSuccess();
        } catch (Exception e) {
            sendError(e.getMessage());
        }
    }

    private void realizarVenta() throws IOException, ClassNotFoundException {
        try {
            List<Factura> facturas = (List<Factura>) input.readObject();
            service.reduceExistences(facturas);
            sendSuccess();
        } catch (Exception e) {
            sendError(e.getMessage());
        }
    }

    private void sendMedidas() throws IOException {
        try {
            List<Medida> medidas = service.getMedidas();
            sendSuccess();
            output.writeObject(medidas);
        } catch (Exception e) {
            sendError(e.getMessage());
        }
    }

    private void sendSuccess() throws IOException {
        output.writeObject("SUCCESS");
    }

    private void sendError(String message) throws IOException {
        output.writeObject("ERROR:" + message);
    }
}