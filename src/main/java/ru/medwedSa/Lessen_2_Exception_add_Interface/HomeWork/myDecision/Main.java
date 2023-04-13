package ru.medwedSa.Lessen_2_Exception_add_Interface.HomeWork.myDecision;

import java.util.Arrays;

/**
 * 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого размера
 * необходимо бросить исключение myArraySizeException.
 * <p>
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то
 * элементе массива преобразование не удалось (Например: в ячейке лежит символ или текст вместо числа), должно быть брошено
 * исключение myArrayDataException, с детализацией в какой именно ячейке лежат не верные данные.
 * <p>
 * 3. В методе main() вызвать полученный метод. Обработать возможные исключения myArraySizeException и myArrayDataException и
 * вывести результат расчета.
 */

public class Main {


    private static int arrayCountCheck(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length < 4) {
            throw new MyArraySizeException("Строк меньше, чем 4!");
        }
        if (arr.length > 4) {
            throw new MyArraySizeException("Строк больше, чем 4!");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length < 4) {
                throw new MyArraySizeException("Столбцов меньше, чем 4!");
            }
            if (arr[i].length > 4) {
                throw new MyArraySizeException("Столбцов больше, чем 4!");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[][] arr = new String[][]{ // Массив согласно условию.
                {"1", "2", "7", "4"},
                {"2", "2", "8", "3"},
                {"1", "2", "2", "2"},
                {"2", "2", "2", "3"}};
//        String[][] arr = new String[][]{ // Массив с НЕ ЦИФРОЙ!
//                {"1", "2", "7", "4"},
//                {"2", "2", "8", "3"},
//                {"1", "2", "2", "2"},
//                {"2", "2", "2", "f"}};
//        String[][] arr = new String[][]{ // Массив с исключением в столбце!
//                {"1", "2", "7", "4"},
//                {"2", "2", "8", "3"},
//                {"1", "2", "2"},
//                {"2", "2", "2", "4"}};
//        String[][] arr = new String[][]{ // Массив с исключением в строке!
//                {"1", "2", "7", "4"},
//                {"2", "2", "8", "3", "4"},
//                {"1", "2", "2", "2"},
//                {"2", "2", "2", "f"}};
        try {
            try {
                int result = arrayCountCheck(arr);
                System.out.println(Arrays.deepToString(arr));
                System.out.printf("Сумма всех чисел двумерного массива = %s", result);
            } catch (MyArraySizeException e) {
                System.out.println(Arrays.deepToString(arr));
                System.out.println(e);
            }
        } catch (MyArrayDataException e) {
            System.out.println(Arrays.deepToString(arr));
            System.out.println("Не все значения в массиве являются цифрами!");
            System.out.println("Ошибка в ячейке: " + e.i + " строка; " + e.j + " столбец");
        }
    }
}


