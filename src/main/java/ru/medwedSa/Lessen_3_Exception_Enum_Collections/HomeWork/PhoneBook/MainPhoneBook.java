package ru.medwedSa.Lessen_3_Exception_Enum_Collections.HomeWork.PhoneBook;
/**
* Задача №2: Написать простой класс - Телефонный справочник. Который хранит в себе список фамилий и телефонных номеров.
*            В этот телефонный справочник, с помощью метода .add() можно добавлять записи. С помощью метода .get()
*            можно искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
*            (в случае однофамильцев), тогда при запросе такой фамилии должны выводится все телефонные номера.
*            ОБЯЗАТЕЛЬНО: Фамилия используется в качестве ключа для Map.
*/
public class MainPhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add( "Иванов", "49-99-33", "hshsh@sjjsj.ss");
        phoneBook.add( "Иванов", "93-99-23", "sdhdh@sjjdd.ur");
        phoneBook.add( "Петров", "67-98-33", "gdheryyw@hddhhf.se");
        phoneBook.add( "Сидоров", "38-44-12", "jdhjvnv@nfnfr.er");
        phoneBook.add( "Сидоров", "22-33-55", "djdkfjfrh@gjutit.ws");
        phoneBook.add( "Сидоров", "44-35-95", "jfjfhfhf@jfjrur.qa");

        phoneBook.getPhone("Сидоров");
        phoneBook.getMail("Сидоров");
        phoneBook.getPhone("Пупкин");
        phoneBook.getPhone("Петров");
    }
}
