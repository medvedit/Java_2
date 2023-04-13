package ru.medwedSa.Lessen_3_Exception_Enum_Collections.ClassWork.Package_a_Exception;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * Продолжение темы ИСКЛЮЧЕНИЯ от лекции №2.
 * Предположим: Требуется создать поток(работа с файлом .txt), в котором открываем файл, читаем из файла и
 * закрываем файл (освобождаем файл для дальнейшей работы с ним).
 * В классе созданного потока нужно:
 * 1. Открыть файл. Если файл не найден, то вывести ошибку - "Файл не найден..."
 * 2. Предположим, что при чтении файла, что-то поло не так и нет возможности прочитать
 *    файл (искусственно созданная ситуация в коде). Закомментировал System.out.println("Файл прочитали") и
 *    оставил только переход кода ошибку SQLException.
 *    В этом случае в шаге 1. мы открыли "какой-то" поток - файл открылся,
 *    2. "захватили какой-то ресурс" - попытались прочитать файл, но не прочитали -
 *    - вылетела ошибка, остановка кода(приложения). При этом не случилось закрытия работы с файлом,
 *    что не дает дальнейшей работы с файлом никому, и мы не сможем разорвать связь с файлом принудительно,
 *    т.к. код(приложение) легло, вылетело в ошибку. Для этого читаем дальше...
 * 3. Для исключения оставленного НЕ ЗАКРЫТОГО файла, после вывода ошибки SQLException("Невозможно прочитать файл..."),
 *    в блок кода try-catch прописываем блок finally - который будет выполнен даже при условии ошибки и остановки
 *    выполнения кода(приложения). finally - обязателен к выполнению в любом случае.
 *    Итог: Файл открылся // открыли файл.
 *          Закрыли работу с файлом // НО файл всё таки закрыли
 *          java.io.IOException: Невозможно прочитать файл... // не смотря на получение ошибки..
 * 	        at ru.medwedSa.Lessen_3_Exception.ClassWork.Package_a_Exception.Main$TestStream.read(Main.java:33)
 * 	        at ru.medwedSa.Lessen_3_Exception.ClassWork.Package_a_Exception.Main.main(Main.java:49)
 */
public class Main {
    static class TestStream { // Создали класс для работы с файлом.
        TestStream(String name) throws FileNotFoundException { // Метод открытия доступа к файлу, в который передаем имя файла
                                                               //  + пробрасываем ВОЗМОЖНУЮ ошибку при отсутствии файла для работы в нем.
            if (!name.equals("Test.txt")) { // если файл с именем test.txt не найден, то...
                throw new FileNotFoundException("Файл не найден..."); // Выбрасываем ошибку. Обработка через try-catch в классе main.
            }
            System.out.println("Файл открылся");
        }

        void read() throws SQLException { // Метод чтения из файла
                throw new SQLException("Невозможно прочитать файл..."); // Допустим, что-то в файле не так, и
                                                                        // нет возможности его прочитать.
                                                                        // Искусственно созданная ситуация.
//            System.out.println("Файл прочитали");
        }

        void close() { // Метод закрытия работы с файлом.
            System.out.println("Закрыли работу с файлом");
        }
    }

    public static void main(String[] args) {
        TestStream file = null; // объявили переменную file со значением null для класса TestStream
        try {
            file = new TestStream("Test.txt"); // создали ссылку на новый объект file для класса TestStream
                                                                // с объектом Test.txt
            file.read(); // прочитали из файла
//            file.close(); // закрыли работу с файлом
        } catch (FileNotFoundException e) { // Вызов при срабатывании исключения FileNotFoundException
            System.out.println(e.getMessage()); // Вывод сообщения об ошибке "Файл не найден..."
        } catch (SQLException e) { // Вызов при срабатывании исключения SQLException
            e.printStackTrace(); // Вывод сообщения об ошибке "Невозможно прочитать файл..."
        } finally {
            file.close();
        }
    }
}