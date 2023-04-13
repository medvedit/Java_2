package ru.medwedSa.Lessen_5_Thread.HomeWork;

import java.util.Arrays;

/**
 * Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 * static final int SIZE = 10_000_000;
 * static final int HALF = size / 2;
 * float[] arr = new float[size];
 * 2) Заполняют этот массив единицами.
 * 3) Засекают время выполнения: long a = System.currentTimeMillis().
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
 * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis().
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).
 * Отличие первого метода от второго:
 * ● Первый просто бежит по массиву и вычисляет значения (это видно из кода выше).
 * ● Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и
 * потом склеивает эти массивы обратно в один.
 * Пример деления одного массива на два:
 * ● System.arraycopy(arr, 0, a1, 0, h);
 * ● System.arraycopy(arr, h, a2, 0, h).
 * Пример обратной склейки:
 * ● System.arraycopy(a1, 0, arr, 0, h);
 * ● System.arraycopy(a2, 0, arr, h, h).
 * Примечание:
 * System.arraycopy() — копирует данные из одного массива в другой:
 * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника,
 * массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 * for (int i = 0; i < size; i++) {
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * }
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */
public class HomeTask {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;
    private static final float[] arrayOneThread = new float[SIZE];
    private static final float[] arrayTwoThread = new float[SIZE];


    public float[] TimeOneThread(float[] array) {
        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] *
                    Math.sin(0.2f + (double) i / 5) *
                    Math.cos(0.2f + (double) i / 5) *
                    Math.cos(0.4f + (double) i / 2));
        }
        long finalTime = System.currentTimeMillis() - startTime;
        System.out.println("Время выполнения в один поток = " + finalTime);
        return array;
    }

    public float[] TimeTwoThreads(float[] array) {
        Arrays.fill(array, 1);

        float[] firstArray = new float[HALF];
        float[] secondArray = new float[HALF];

        long startTime = System.currentTimeMillis();

        System.arraycopy(array, 0, firstArray, 0, HALF);
        System.arraycopy(array, HALF, secondArray, 0, HALF);

        MyThread tr1 = new MyThread(firstArray, 0);
        MyThread tr2 = new MyThread(secondArray, HALF);

        try {
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        firstArray = tr1.getArr();
        secondArray = tr2.getArr();

        System.arraycopy(firstArray, 0, array, 0, firstArray.length);
        System.arraycopy(secondArray, 0, array, HALF, secondArray.length);

        long finalTime = System.currentTimeMillis() - startTime;

        System.out.println("Время выполнения в двумя потоками = " + finalTime);
        return array;
    }


    public static class MyThread extends Thread {
        private final float[] arr;
        private final int offSet;

        MyThread(float[] arr, int offSet) {
            this.arr = arr;
            this.offSet = offSet;
            start();
        }

        @Override
        public void run() {
//            System.out.println(getName() + " Начал работу...");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] *
                        Math.sin(0.2f + (double) (i + offSet) / 5) *
                        Math.cos(0.2f + (double) (i + offSet) / 5) *
                        Math.cos(0.4f + (double) (i + offSet) / 2));
            }
//            System.out.println(getName() + " Закончил работу.");
        }

        public float[] getArr() {
            return arr;
        }
    }


    public static void main(String[] args) {
        System.out.println("Длина массива для подсчета = " + SIZE + " элементов");
        HomeTask o = new HomeTask();
        float[] first = o.TimeOneThread(arrayOneThread);
        float[] second = o.TimeTwoThreads(arrayTwoThread);

        System.out.println(Arrays.equals(first, second));
    }
}
