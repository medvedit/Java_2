package ru.medwedSa.Lessen_5_Thread.Thread;

import static java.lang.Thread.sleep;

/**
 *  Не понимаю что написать в описании решения этой задачи...
 *  Если не понятно или забыл))), то включай семинар 5 с 2:35 по 2:50 и читай методичку.
 *  Суть в решении применения монитора.
 *  Если есть желание потыкаться в код, то стоит начать с того, что бы закомментировать весь метод incAll2(),
 *  далее удалить запись synchronized в методе incAll() и запустить код... Затем верни обратно synchronized в
 *  методе incAll() и снова запусти. И читай все о synchronized.
 *  Начни тут: <a href="https://metanit.com/java/tutorial/8.3.php">...</a>
 */
public class ThreadMain_3 {

    private static long a;
    private static long b;
    private static long c;

    private static long x;
    private static long y;
    private static long z;

    private static final Object mon = new Object();

    private synchronized static void incAll() { // В этом случае объектом монитора выступать будет сам класс ThreadMain_3
        for (int i = 0; i < 10_000_000; i++) {
            a += 1;
            b += 1;
            c += 1;
        }
        String value = String.format("a = %d  d = %d  c = %d", a, b, c);
        System.out.println(value);
    }

    private static void incAll2() {
        synchronized (mon) { // в этом случае объектом монитора выступает метод incAll2()
            for (int i = 0; i < 10_000_000; i++) {
                x += 1;
                y += 1;
                z += 1;
            }
            String value = String.format("x = %d  y = %d  z = %d", x, y, z);
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello " + Thread.currentThread().getName());

//        Runnable r0 = ThreadMain_3::incAll; // этот код и код со строки 44 по 49 - одинаковый.
                                              // Разный только по написанию.
        Runnable r0 = new Runnable() {
            @Override
            public void run() {
                incAll();
                incAll2();
            }
        };

        new Thread(r0, "Поток_1").start();
        new Thread(r0, "Поток_2").start();
        new Thread(r0, "Поток_3").start();

        System.out.println("Goodbye " + Thread.currentThread().getName());
    }
}
