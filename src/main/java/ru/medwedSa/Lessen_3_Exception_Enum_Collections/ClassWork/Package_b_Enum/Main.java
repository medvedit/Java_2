package ru.medwedSa.Lessen_3_Exception_Enum_Collections.ClassWork.Package_b_Enum;

/**
 *  Речь пойдет о перечислениях.
 *  Перечисления, так же как и любые другие классы писать в другом файле. Тут все в одном файле - для наглядности.
 *  Как правило, в качестве перечислений выступают какие-либо константы - дни недели, цвета, месяцы в году и т.д.
 */
public class Main {

    enum Color { // Создали тип перечисления. Набор статических экземпляров класса, описанных внутри самого класса.
        RED, GREEN, BLUE // Нет никакого присвоения значений, просто перечисление. Просто статические объекты класса Color.
    }


    enum Color2 { // ещё вариант...
        RED("#FF0000"), GREEN("#00FF00"), BLUE("#0000FF"); // появился у переселений еще один параметр - код RGB
                                                                           // Перечисления всегда находятся вначале своего класса !!!
        private final String code; // создали переменную для обращения к code.

        Color2(String code) { // конструктор класса Color2 длч обращения к code.
            this.code = code;
        }
        public String getCode() { // геттер
            return code;
        }
    }

    public static void main(String[] args) {

        System.out.println(Color.BLUE); // простой вызов одного объекта и списка перечислений Color.
        System.out.println(Color.GREEN == Color.RED); // Допустимая проверка равенства. Результатом будет значение boolean.
        System.out.print("\n");
        System.out.println(Color2.RED); // тут все без изменений - все можно так-же.
        System.out.println(Color2.BLUE == Color2.GREEN); // аналогично... Результатом будет значение boolean.
        System.out.println(Color2.BLUE.getCode()); // вызов кода определенного цвета.
        System.out.print("\n");
        Color2[] colors = Color2.values(); // .values() - стандартный метод позволяющий получить все необходимые значения.
        for (Color2 color2 : colors) { // прошли циклом и..
            System.out.print(color2 + " color rgb = "); // достали все названия заданных в перечислении цветов.
            System.out.println(color2.getCode()); // получили все значения code.
        }
    }
}
