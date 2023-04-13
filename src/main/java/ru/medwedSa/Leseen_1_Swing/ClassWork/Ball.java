package ru.medwedSa.Leseen_1_Swing.ClassWork;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball extends Sprite { // наследуем от класса Sprite
    private static final Random rnd = new Random(); // создали рандомную переменную rnd для задания цвета.
    private final Color color; // функция цвета шарика.
    private float vX; // параметр скорости перемещения по оси X.
    private float vY; // параметр скорости перемещения по оси Y.

    public Ball() { // конструктор Ball
        halfHeight = 20 + (float) (Math.random() * 50f); // halfHeight - полувысота.
        halfWidth = halfHeight; // halfWidth - полуширина.
        color = new Color(rnd.nextInt()); // в переменную rnd передали int значения для цветовой палитры. В метод Color(rgb int, rgb int, rgb int)
        vX = 100f + (float) (Math.random() * 200f); // Задание скорости.
        vY = 100f + (float) (Math.random() * 200f); // Задание скорости.
    }

    public void update(GameCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()) { // мячик дошел до определенных координат и поменял свое направление.
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) { // мячик дошел до определенных координат и поменял свое направление.
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) { // мячик дошел до определенных координат и поменял свое направление.
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) { // мячик дошел до определенных координат и поменял свое направление.
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    public void render(GameCanvas canvas, Graphics g) { // Переопределили из класса Sprite.
                                                 // То, как его отрисовать. В нашем случае это будет заполненный круг.
        g.setColor(color); // Объекту графики g нужно установить цвет.
        g.fillOval( // Объекту графики g нужно нарисовать заполненный овал с координатам.
                (int) getLeft(),
                (int) getTop(),
                (int) getWidth(),
                (int) getHeight());
    }
}
