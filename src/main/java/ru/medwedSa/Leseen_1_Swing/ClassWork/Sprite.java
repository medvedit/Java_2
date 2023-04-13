package ru.medwedSa.Leseen_1_Swing.ClassWork;

import java.awt.Graphics;

public class Sprite { // класс содержащий в себе двумерный объект (Graphics).
    protected float x; // координаты по оси X
    protected float y; // координаты по оси Y
    protected float halfWidth; // координаты по ширине - храним половину ширины
    protected float halfHeight; // координаты по высоте - храним половину высоты
    // Половина, что бы начинать рисовать не с левого верхнего угла, как предлагает библиотека swing, а с центра нашего окна.

    //<editor-fold desc="Геттеры и сеттеры. Привидение оси координат, относительно - начало рисования фигур - центр окна.">
    protected float getLeft(){
        return x - halfWidth;
    }
    protected void setLeft(float left){
        x = left + halfWidth;
    }
    protected float getRight(){
        return x + halfWidth;
    }
    protected void setRight(float right){
        x = right - halfWidth;
    }
    protected float getTop(){
        return y - halfHeight;
    }
    protected void setTop(float top){
        y = top + halfHeight;
    }
    protected float getBottom(){
        return y + halfHeight;
    }
    protected void setBottom(float bottom){
        y = bottom - halfHeight;
    }
    //</editor-fold>

    protected float getWidth(){
        return  2f * halfWidth;
    } // полная ширина
    protected float getHeight(){
        return 2f * halfHeight;
    } // полная высота

    void  update(GameCanvas canvas, float deltaTime) {} // Логика. Как Sprite должен обновиться с течением времени.
                                                        // В нашем случае это будет изменение координат, перемещение.
    void  render(GameCanvas canvas, Graphics g) {} // То, как его отрисовать. В нашем случае это будет заполненный круг.
}
