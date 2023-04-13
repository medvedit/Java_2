package ru.medwedSa.Leseen_1_Swing.HomeWork;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GameCanvasHome extends JPanel {
    private long lastFrameTime;
    private final MainCirclesHome controller;

    GameCanvasHome(MainCirclesHome controller) {
        lastFrameTime = System.nanoTime();
        this.controller = controller;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        controller.onDrawCanvas(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
    public int getLeft() {return 0; }
    public int getRight() {return getWidth() - 1; }
    public int getTop() {return 0; }
    public int getBottom() {return getHeight() - 1; }
}
