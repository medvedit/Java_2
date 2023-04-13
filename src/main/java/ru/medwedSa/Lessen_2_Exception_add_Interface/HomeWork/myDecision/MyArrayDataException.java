package ru.medwedSa.Lessen_2_Exception_add_Interface.HomeWork.myDecision;


 public class MyArrayDataException extends Exception {
    public int i;
    public int j;

    MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
