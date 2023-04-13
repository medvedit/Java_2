package ru.medwedSa.Lessen_5_Thread.Thread;

/**
 * Простой пример создания, старта и реализации потоков.
 */
public class ThreadMain_1 {

    static class MyThread extends Thread { // Класс наследник от Thread, который и создает многопоточность. А именно,
        // Thread реализует функциональный интерфейс Runnable(), который реализует в себе метод run().

        public MyThread(String name) { // Конструктор класса.
            super(name);
        }

        @Override // Переопределённый метод реализации интерфейса Runnable().
        public void run() { // В реализации: Вывод в консоль 5 раз Hello + имя потока с задержкой в 1 секунду.
            boolean flag = true;
            while (flag) { // Вместо созданной переменной flag в цикле while можно использовать методы
                           // interrupted() или isInterrupt() или !interrupt() или !isInterrupt().
                           // А для отключения запущенного потока прописывается: <имя потока>.interrupt()
                for (int i = 0; i < 5; i++) {
                    try {
                        sleep(1000); // установка задержки в мили сек.
                    } catch (InterruptedException e) { // обязательная реализация для метода sleep(),
                                                       // на случай исключения.
                        throw new RuntimeException(e);
                    }
                    System.out.println("Hello " + Thread.currentThread().getName());
                }
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello " + Thread.currentThread().getName()); // currentThread() - текущий тред()
                                                                         // Выводит Hello + имя класса в котором
                                                                         // происходит выполнение потока.
        MyThread myThread = new MyThread("Hello_1"); // Создал новый поток и присвоил ссылку на него к идентификатору
        // myThread. Эта переменная создана от родительского класса MyThread. И т.к. у этого потока нет собственной
        // реализации run, то реализовываться он будет через метод run переопределенный в классе MyThread.
//        myThread.setName("YYY"); // Возможность менять имя потока.
        myThread.start(); // Запустил поток myThread
//        myThread.interrupt();

        new MyThread("Hello_2").start(); // Создание нового потока без присвоения к идентификатору и сразу запустил
        // этот поток. У этого потока, как и в примере выше нет собственной реализации, по-этому он так же будет
        // исполняться в методе run родительского класса.

        new Thread(new Runnable() { // В этом примере поток создан с собственной реализацией и его реализация
            // не будет зависеть от реализации run в методе MyThread.
            @Override
            public void run() {
                System.out.println("Hello " + Thread.currentThread().getName());
            }
        }, "Hello_3").start(); // Сразу после реализации потока он запущен ( .start() ).
    }
}
