package ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Games.Circles;


import ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Games.Common.GameCanvas;
import ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Games.Common.Sprite;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {
    private static final Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    public Ball() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }
    Ball(int x, int y){
        this();
        this.x = x;
        this.y = y;
    }
    @Override
    public void update(GameCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }
    @Override
    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval(
                (int) getLeft(),
                (int) getTop(),
                (int) getWidth(),
                (int) getHeight());
    }

}
