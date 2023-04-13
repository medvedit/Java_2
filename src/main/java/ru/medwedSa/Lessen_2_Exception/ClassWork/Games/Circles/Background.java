package ru.medwedSa.Lessen_2_Exception.ClassWork.Games.Circles;

import ru.medwedSa.Lessen_2_Exception.ClassWork.Games.Common.CommonObject;
import ru.medwedSa.Lessen_2_Exception.ClassWork.Games.Common.GameCanvas;

import java.awt.*;

public class Background implements CommonObject {

    private float time;
    private static final float AMPLITUDE = 225f / 2f;
    private Color color;

    @Override
     public void update(GameCanvas canvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 1.5f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}
