package ru.medwedSa.Leseen_1_Swing.HomeWork;

import java.awt.*;

public class  Background extends SpriteHome{

    private float time;
    private static final float AMPLITUDE = 225f / 2f;
    private Color color;

    @Override
    void update(GameCanvasHome canvas, float deltaTime) { // относительно deltaTime
        time += deltaTime; // накапливаем в time
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 1.5f)); // все вычисления для увеличения амплитуды для
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f)); // функции косинуса, которая в простом исполнении
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time)); // будет работать от 1 до -1
        color = new Color(red, green, blue); // Меняем наше полученное rgb относительно накопленных значений int
    }


    @Override
    void render(GameCanvasHome canvas, Graphics g) {
        canvas.setBackground(color);
    }
}
