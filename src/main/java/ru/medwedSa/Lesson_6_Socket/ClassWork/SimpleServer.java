package ru.medwedSa.Lesson_6_Socket.ClassWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189);
            Socket client = server.accept()) { // Создали try с ресурсами с новым сервером. И при условии, что мы
                                               // ожидаем только одного соединения, то можно в try сразу создать client.
                                               // При этом закрытие соединения командой .close() не требуется.

//            Socket client = server.accept(); // Под каждого клиента создается который будет возвратятся .accept()(м)
                                             // каждого сервера.
            System.out.println("Клиент подключен...");
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true) {
                String msg = in.readUTF(); // ожидаем информацию от in
                out.writeUTF("echo: " + msg); // отдали полученную информацию.
            }
//            client.close(); // закрыли соединение.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
