package ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Interface;

/**
 * Наглядная зависимость от интерфейсов.
 */
public class Main {

    private interface Animal{
        void breathes();
        void looks();
    }
    private  interface Human extends Animal{
        void talk();
        default void walks() {
            System.out.println("Ходит на двух ногах");
        }
    }
    private interface Bull extends Animal{
        default void walks() {
            System.out.println("Ходит на четырех ногах");
        }
        void voice();
    }

    private static class Minotaur implements Human, Bull{
        @Override public void breathes() {}
        @Override public void looks() {}
        @Override public void talk() {}
        @Override public void walks() {Human.super.walks();}
        @Override public void voice() {}
    }

    private static class Men implements Human{
        @Override public void breathes() {}
        @Override public void looks() {
            System.out.println("Человек смотрит");
        }
        @Override public void talk() {}
        @Override public void walks() {}
    }

    public static void main(String[] args) {
        Men men = new Men();
        men.looks();
        Bull minotaur = new Minotaur();
        minotaur.walks();
    }
}
