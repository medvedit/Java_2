package ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Games.Common;

import java.awt.*;

public interface CommonObject {

    void  update(GameCanvas canvas, float deltaTime);
    void  render(GameCanvas canvas, Graphics g);
}
