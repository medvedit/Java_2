package ru.medwedSa.Lessen_2_Exception.ClassWork.Games.Common;

import java.awt.*;

public interface CommonObject {

    void  update(GameCanvas canvas, float deltaTime);
    void  render(GameCanvas canvas, Graphics g);
}
