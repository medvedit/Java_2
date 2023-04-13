package ru.medwedSa.Lessen_2_Exception_add_Interface.HomeWork.myDecision;

public class MyArraySizeException extends Exception {
    MyArraySizeException(String message) {
        super("\nОшибка входящего массива!\nМатрица поступила на вход не 4х4\n" + message);
    }
}
