package ru.medwedSa.Leseen_1_Swing.ClassWork;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Graphics;

public class MainCircles extends JFrame { // класс MainCircles наследуется от JFrame
    // Создаем окно программы. X и Y точка от левого верхнего угла монитора (начало отсчета),
    // а координаты WIDTH и HEIGHT - ширина и высота создаваемого окна (от точки X и Y).
    private static final int POS_X = 935; // X
    private static final int POS_Y = 85; // Y
    private static final int WINDOW_WIDTH = 700; // WIDTH
    private static final int WINDOW_HEIGHT = 450; // HEIGHT

    private final Ball[] sprites = new Ball[10]; // Создали 10 шариков.


    private void update(GameCanvas canvas, float deltaTime) {
        for (Ball item : sprites) {
            item.update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (Ball item : sprites) {
            item.render(canvas, g);
        }
    }

    protected void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime) { // Метод отрисовки (onDrawCanvas - на холсте рисования)
                                                                            // GameCanvas c - на какой canvas отрисовалось.
                                                                            // Graphics g - Это фундаментальный класс для того, чтобы представить 2-мерные формы. Мы рисуем шарики.
                                                                            // float deltaTime - Хотим знать, сколько времени прошло с предыдущей отрисовки.
        update(c, deltaTime);
        render(c, g);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    private MainCircles() {
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT); // создали окно, границы окна от точки X и Y, на ширину WIDTH и высоту HEIGHT.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // прописали условие действия при нажатии на "красный крестик" открытого окна.
        setTitle("Окошко..."); // текст будет виден в открытом окне
//        setResizable(false); // если раскомментировать эту строку, то возможность менять размер активного окна программы исчезнет.
        setBackground(Color.lightGray);

        GameCanvas canvas = new GameCanvas(this); // Создали новый объект canvas и передали в него ссылку на саму себя.
                                                           // (мы хотим сами на себе рисовать). У нас есть созданное окно в классе
                                                           // MainCircles с координатами, с исполнением по нажатию на "красный крестик",
                                                           // с текстом "Окошко...", выбранным цветом и передаем ссылку на созданное,
                                                           // это окно, в конструктор класса GameCanvas.
                                                           // А в конструкторе класса GameCanvas ссылка записывается в переменную
                                                           // this.controller, которая в свою очередь снова дергает класс MainCircles.
        canvas.setBackground(Color.darkGray); // Залили созданную canvas цветом.
        add(canvas); // Добавили созданную canvas на поле созданного окна из метода setBounds.
        initApplication();
        setVisible(true); // показать созданное окно.
    }
    public static void main(String[] args) {
        new MainCircles();
    }

}
