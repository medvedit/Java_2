package ru.medwedSa.Lessen_5_Thread.ChatBot;

public class ServerSocketThread extends Thread{ // Создали многопоточный  класс ServerSocketThread,
                                                // который будет вызываться в ChatServer.
    private int port;

    ServerSocketThread(String log, int port) { // Конструктор метода принимающий имя и порт.
        super(log);
        this.port = port;
        start(); // Запустили сервер.
    }

    @Override // Переопределенный метод run
    public void run() { // Который будет работать пока в метод не прилетит interrupt();
        System.out.println("Сервер подключен!"); // Лог в консоль при запуске.
        while (!isInterrupted()) { // Пока не прерван цикл бесконечен...
            try {
                sleep(3000); // Сон 3 секунды.
                System.out.println(getName() + " Сервер работает..."); // Лог в консоль.
            } catch (InterruptedException e) {
                interrupt(); // Прерывание потока. Прилетает из ChatServer.
            }
        }
        System.out.println("Сервер отключен!"); // Лог в консоль при остановке.
    }
}
