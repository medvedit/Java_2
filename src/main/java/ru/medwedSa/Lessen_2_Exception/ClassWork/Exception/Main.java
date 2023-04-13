package ru.medwedSa.Lessen_2_Exception.ClassWork.Exception;

/**
 * Возникающее исключение при делении на ноль.
 */
public class Main {
    public static int division()  {
        int i = 10 / 0;
        return i;
    }

    public static void main(String[] args) {

        System.out.println(division()); // Exception in thread "main" java.lang.ArithmeticException: / by zero
                                        //  at ru.medwedSa.Lesson_2.ClassWork.Exception.Main.division(Main.java:5)
                                        //  at ru.medwedSa.Lesson_2.ClassWork.Exception.Main.main(Main.java:11)
    }
}
