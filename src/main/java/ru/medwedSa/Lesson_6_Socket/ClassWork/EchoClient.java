package ru.medwedSa.Lesson_6_Socket.ClassWork;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 8189)){
            System.out.println("Установленно соединение с сервером...");
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                String msg = sc.nextLine();
                out.writeUTF(msg);
                System.out.println(in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
