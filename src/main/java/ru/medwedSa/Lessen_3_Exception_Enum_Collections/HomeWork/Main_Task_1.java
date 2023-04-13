package ru.medwedSa.Lessen_3_Exception_Enum_Collections.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Задача №1: Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 *            Найти и вывести список уникальных слов, из которых состоит массив, дубликаты не считаем.
 *            Посчитать сколько раз встречается каждое слово.
 */
public class Main_Task_1 {
    private static final String words =
            "Мне нравится, когда нравится мне танцевать, потому что танцевать " +
            "помогает мне выразить себя и нравится мне это.";

    private static String[] createArrayOfWords(String word) { // Приведение текста в массив слов.
                                                              // Удаление всех знаков препинания и перевод всех слов в
                                                              // нижний регистр.
        System.out.println("Начальный текст: \n" + word + "\n");
        String replaceWord = word.replaceAll("\\p{Punct}", "");
        return replaceWord.toLowerCase().split(" "); // Вернулся чистый массив слов.
    }

    private static void uniqueWordsInText(String[] str) {
        System.out.printf("Преобразованный текст в массив строк:\n%s\n\n", Arrays.toString(str));
        System.out.println("Список уникальных слов в тексте:\n(в скобках количество повторений каждого слова в тексте)");

        List<String> s = new ArrayList<>(List.of(str)); // Преобразовали поступающий на вход массив слов в ArrayList
        int numberUniqueWords = 0; // для подсчета уникальных слов.
        int totalNumberWords = 0; // для подсчета всех слов.
        for (int i = 0; i < s.size(); i++) {
            int count = 0; // для подсчета повторения каждого слова.
            String wordNow = s.get(i); // положил слово, на котором находится цикл в данной итерации.
            for (int j = i; j < s.size(); j++) {
                if (wordNow.equals(s.get(j))) { // сравниваем слова по всему ArrayList
                    count++; // если совпадают, сохраняем совпадения
                }
            }
            System.out.print(s.get(i) + "(" + count + ") "); // после завершения второго цикла for выводим слово и
                                                             // количество его повторений в консоль.
            s.removeAll(Collections.singleton(wordNow)); // Полностью удаляем это слово из всей коллекции
            totalNumberWords += count; // этим сложением достигается подсчет всех слов.
            numberUniqueWords++; // тут складывается количество уникальных слов.
            i--; // т.к. удалили слово на котором находились, что бы не перескакивать в первом цикле for, где сразу сработает i++
        }
        System.out.printf("\nКоличество уникальных слов в тексте -> %s\n",numberUniqueWords); // вывод количества уникальных слов.
        System.out.printf("Общее количество слов в тесте -> %s",totalNumberWords); // вывод общего количества слов
    }


    public static void main(String[] args) {
        String[] arrayOfWords = createArrayOfWords(words);
        uniqueWordsInText(arrayOfWords);
    }
}
