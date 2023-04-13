/**
 *  Весь код без строчных комментариев полностью скопирован из работы в классе (package ru.medwedSa.Leseen_1.ClassWork).
 *  А код с комментариями добавлен, как домашняя работа.
 *  Код который закомментирован - соответственно не нужен с учетом выполненного домашнего задания. Не удален, а просто закомментирован.
 *  Описание домашней работы:
 *  1. Разобраться и процентировать код находящийся в package ru.medwedSa.Leseen_1.ClassWork
 *  2. Написать КЛАСС Background, изменяющий цвет canvas в зависимости от времени в приложении.
 *  3. Реализовать добавление новых кружков по клику, используя только массивы.
 *  4. Реализовать по клику другой кнопки удаление кружков, используя массивы.
 */

package ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Games.Circles;

import ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Games.Common.CommonObject;
import ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Games.Common.Controller;
import ru.medwedSa.Lessen_2_Exception_add_Interface.ClassWork.Games.Common.GameCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame implements Controller {

    private static final int POS_X = 935;
    private static final int POS_Y = 85;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 450;

    private CommonObject[] objects = new CommonObject[1];
    private int objectsCount;

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < objectsCount; i++) {
            objects[i].update(canvas, deltaTime);
        }
    }
    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < objectsCount; i++) {
            objects[i].render(canvas, g);
        }
    }
    @Override
    public void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime) {
        update(c, deltaTime);
        render(c, g);
    }
    private void initApplication() {
        addObjects(new Background());
    }

    private MainCircles() {
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Шарики... (ЛКМ - добавить шарик ПКМ - удалить шарик)");

        GameCanvas canvas = new GameCanvas(this);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    addObjects(new Ball(e.getX(), e.getY()));
                else if (e.getButton() == MouseEvent.BUTTON3)
                    removeSprite();
            }
        });
        add(canvas);
        initApplication();
        setVisible(true);
    }
    private void addObjects(CommonObject s) {
        if (objectsCount == objects.length) {
            CommonObject[] temp = new CommonObject[objects.length * 2];
            System.arraycopy(objects, 0, temp, 0, objects.length);
            objects = temp;
        }
        objects[objectsCount++] = s;
    }
    private  void removeSprite() {
        if (objectsCount > 1) {
            objectsCount--;
        }
    }

    public static void main(String[] args) {
        new MainCircles();
    }

}
