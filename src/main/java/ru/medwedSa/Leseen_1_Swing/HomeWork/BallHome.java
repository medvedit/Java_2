package ru.medwedSa.Leseen_1_Swing.HomeWork;



import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BallHome extends SpriteHome {
    private static final Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    public BallHome() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }
    BallHome(int x, int y){ //
        this(); //
        this.x = x; //
        this.y = y; //
    }
    public void update(GameCanvasHome canvas, float deltaTime) {
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
    public void render(GameCanvasHome canvas, Graphics g) {
        g.setColor(color);
        g.fillOval(
                (int) getLeft(),
                (int) getTop(),
                (int) getWidth(),
                (int) getHeight());
    }

}
