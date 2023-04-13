package ru.medwedSa.Lessen_3_Exception_Enum_Collections.HomeWork.PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;


public class PhoneBook {
    private final HashMap<String, ArrayList<Person>> bookEntry = new HashMap<>();


    protected void add(String surname, String phone, String mail) {
        if (bookEntry.containsKey(surname)) { // если ли по такой фамилии(ключ) запись есть. то..
            ArrayList<Person> people = bookEntry.get(surname); // ссылку с совпавшей, с найденной фамилией в телефонном справочнике
                                                               // прикрепляем к ArrayList<Person> people, а далее
            people.add(new Person(surname, phone, mail)); // в people складываем всю вводимую информацию, новый Person
            // в итоге получаем новую запись в  HashMap<String, ArrayList<Person>> bookEntry, где
            // String - та фамилия ссылку с которой только что прикрепили к  ArrayList<Person> people, а
            // ArrayList<Person> - все данные  people.add(new Person(surname, phone, mail))
        } else { // иначе, если по фамилии(ключ) записи нет
            ArrayList<Person> people = new ArrayList<>(); // создал новый ArrayList people с полями из класса Person
            people.add(new Person(surname, phone, mail)); // добавил в people new Person с веденными данными лт пользователя
            bookEntry.put(surname,people); // перенес новые данные в телефонную книгу bookEntry
                                           // где surname выступает ключом по фамилии, а people данными к ключу в виде списка ArrayList
        }
    }

    protected void getPhone(String surname) {
        if(bookEntry.containsKey(surname)) { // если в телефонной книге по ключу - фамилии есть совпадение, то
            ArrayList<Person> persons = bookEntry.get(surname); // ссылки на все совпадения по ключу складываем в
                                                                // ArrayList persons со всеми полями из класса Person
            ArrayList<String> result = new ArrayList<>(); // создали новый ArrayList result для хранения и вывода(в дальнейшем) результата.
            for (int i = 0; i < persons.size(); i++) { // проходим циклом по всему persons.size()
                result.add(persons.get(i).phone); // и записываем все телефонные номера в result
            }
            System.out.printf("Для контакта <%s>\nНайдены следующие номера телефонов: %s\n",surname, result); // вывод в консоль
        } else {
            System.out.printf("Фамилии <%s> в телефонной книге нет...\n", surname);// если совпадений по фамилии(ключу) нет.
        }
    }
    protected void getMail(String surname) { // идентичный методу getPhone, но сокращен, оптимизирован код.
        if(bookEntry.containsKey(surname)){
            System.out.printf("Для контакта <%s>\nНайдены следующие адреса mail: %s\n",surname,
            /* Нижние две строки кода полностью повторяют "развернутый", подробный код из метода getPhone */
                    bookEntry.get(surname).stream().map(person -> person.mail) // озвучивание написания этого кода преподавателем в JAVA_2, урок_4, минута 31:00
                            .collect(Collectors.toCollection(ArrayList::new)));
        } else {
            System.out.printf("Фамилии <%s> в телефонной книге нет...\n", surname);
        }
    }
}
