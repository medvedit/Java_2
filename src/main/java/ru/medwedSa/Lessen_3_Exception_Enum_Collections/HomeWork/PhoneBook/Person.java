package ru.medwedSa.Lessen_3_Exception_Enum_Collections.HomeWork.PhoneBook;

public class Person { // создал класс человек, с публичными переменными, полями дло телефонной книги.
    public String surname;
    public String phone;
    public String mail;

    Person (String surname, String number, String mail){
        this.surname = surname;
        this.phone = number;
        this.mail = mail;
    }
}
