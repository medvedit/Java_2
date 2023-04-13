package ru.medwedSa.Lessen_4_OnlineChat_Start.ClassWork;

import java.util.Date;

public class ChatServer { //
    public void start(int port) { // метод запуска чат_сервера
        System.out.println("Сервер запустился через порт " + port + "     " +
                           "DateTime: " + new Date().toString()); // логируем запуск сервера
    }
    public void stop() { // метод остановки чат_сервера
        System.out.println("Сервер остановлен " + "     DateTime: " + new Date().toString()); // логируем остановку сервера
    }
}

