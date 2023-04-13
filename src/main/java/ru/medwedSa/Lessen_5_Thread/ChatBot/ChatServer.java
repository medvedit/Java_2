package ru.medwedSa.Lessen_5_Thread.ChatBot;

import java.util.Date;

public class ChatServer { //
    ServerSocketThread server; // создали server от класса ServerSocketThread
    public void start(int port) { // метод запуска чат_сервера
        if (server != null && server.isAlive()) { // если сервер существует (активен) И уже живой (работает),
            System.out.println("Сервер уже работает!"); // просто выводим лог в консоль
        } else { // иначе запускаем сервер
            server = new ServerSocketThread("Чат_приложение.", port); // говорим, что server это новый ServerSocketThread
            System.out.println("Сервер запустился через порт " + port + "     " +
                    "DateTime: " + new Date().toString()); // логируем запуск сервера
        }
    }
    public void stop() { // метод остановки чат_сервера
        if (server == null || !server.isAlive()) { // если сервер не существует (не активен) ИЛИ сервер не живой, то
            System.out.println("Сервер уже остановлен или еще не запускался..."); // выводим лог в консоль
        } else { // иначе останавливаем сервер
            server.interrupt(); // отправили команду прерывания работы сервера в ServerSocketThread, в метод run
            System.out.println("Сервер остановлен " + "     DateTime: " + new Date().toString()); // логируем остановку сервера
        }
    }
}

