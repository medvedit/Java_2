package ru.medwedSa.Lessen_3_Exception_Enum_Collections.ClassWork.Package_a_Exception_partTwo;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Итак, в Package_a_Exception.Main нам удалось реализовать работу с открытием, чтением и закрытием файла при
 * создании разных исключений. То есть даже при возникновении исключения на стадии не возможности прочитать
 * информацию из файла, работа с файлом, а точнее закрытие файла совершалось с помощью прописания в
 * блок try-catch пункта finally. (полное описание в пакете Package_a_Exception в файле Main)
 * .......
 * Рассмотрим ситуацию при которой у нас в самом начале выполнения кода файл не найден,
 * выпадает ошибка FileNotFoundException("Файл не найден..."), то в этом случае мы получим еще вторую ошибке о том
 * Cannot invoke "ru.medwedSa.Lessen_3_Exception.ClassWork.Package_a_Exception.Main$TestStream.close()" because "file" is null
 * то-есть и закрывать нам не чего в блоке finally -> file.close(). Файл же не открыт!
 * Что бы не прописывать в блоке try-catch пункт finally  -> file.close() и получать автоматическое закрытие
 * прерывание работы с файлом моно поступить следующим образом:
 * 1. Добавляем реализацию интерфейса (implements Closeable) для класса TestStream
 *    и @Override один единственный метод этого интерфейса -> close()
 * 2. Далее в функции Main, в оператор try в скобках прописываем ресурсы, с которыми в блоке кода try-catch будет
 *    производиться работа. Это синтаксическая возможность для блока try-catch называемая try-with-resources.
 *    Эти не хитрые манипуляции дают нам возможность автоматически закрывать потоки, работу с файлом если
 *    что-то пошло не по плану.
 *    Возникло подавленное исключение.
 *    Итог: Файл открылся
 *          java.sql.SQLException: Невозможно прочитать файл...
 * 	        at ru.medwedSa.Lessen_3_Exception.ClassWork.Package_a_Exception_partTwo.Main$TestStream.read(Main.java:36)
 * 	        at ru.medwedSa.Lessen_3_Exception.ClassWork.Package_a_Exception_partTwo.Main.main(Main.java:49)
 * 	        Suppressed: java.io.IOException: Нет возможности закрыть файл!
 * 		        at ru.medwedSa.Lessen_3_Exception.ClassWork.Package_a_Exception_partTwo.Main$TestStream.close(Main.java:41)
 * 		        at ru.medwedSa.Lessen_3_Exception.ClassWork.Package_a_Exception_partTwo.Main.main(Main.java:48)
 */
public class Main {
    static class TestStream implements Closeable {
        TestStream(String name) throws FileNotFoundException {
            if (!name.equals("Test.txt")) {
                throw new FileNotFoundException("Файл не найден...");
            }
            System.out.println("Файл открылся");
        }
        void read() throws SQLException {
            throw new SQLException("Невозможно прочитать файл..."); // если раскомментировать тут и...
//            System.out.println("Файл прочитали"); // и закомментировать тут, то получим ошибку в чтении файла, но файл закроется.
        }
        @Override // переопределили функцию от интерфейса Closeable
        public void close() throws IOException {
            throw new IOException("Нет возможности закрыть файл!");
//            System.out.println("Закрыли работу с файлом");
        }
    }


    public static void main(String[] args) {
        try (TestStream file = new TestStream("Test.txt")){ // в скобках прописали ресурсы, захватили ресурс -> try-with-resources
            file.read();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

}

