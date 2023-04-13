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

package ru.medwedSa.Leseen_1_Swing.HomeWork;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCirclesHome extends JFrame{

    private static final int POS_X = 935;
    private static final int POS_Y = 85;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 450;

//    private final BallHome[] sprites = new BallHome[10];
    private SpriteHome[] sprites = new SpriteHome[1]; // Создаем массив sprites в один элемент, предполагая, что дальше я его буду расширять.
    private int spritesCount; // текущее количество sprites, которое находится в данный момент.

//    private void update(GameCanvasHome canvas, float deltaTime) {
//        for (BallHome item : sprites) {
//            item.update(canvas, deltaTime);
//        }
//    }
    private void update(GameCanvasHome canvas, float deltaTime) { // все создаваемые массивы теперь бегут не до конца массива,
        for (int i = 0; i < spritesCount; i++) { // а до конца spritesCount, т.к. массив в дальнейшем по коду будет расширятся
            sprites[i].update(canvas, deltaTime); // или сокращаться по клику на шарики, и в массиве будут появляться элементы null.
        }
    }
//    private void render(GameCanvasHome canvas, Graphics g) {
//        for (BallHome item : sprites) {
//            item.render(canvas, g);
//        }
//    }
    private void render(GameCanvasHome canvas, Graphics g) { // Все создаваемые массивы теперь бегут не до конца массива,
        for (int i = 0; i < spritesCount; i++) { // а до конца spritesCount, т.к. массив в дальнейшем по коду будет расширятся
            sprites[i].render(canvas, g); // или сокращаться по клику на шарики, и в массиве будут появляться элементы null.
        }
    }
    protected void onDrawCanvas(GameCanvasHome c, Graphics g, float deltaTime) {
        update(c, deltaTime);
        render(c, g);
    }
//    private void initApplication() {
//        for (int i = 0; i < sprites.length; i++) {
//            sprites[i] = new BallHome();
//        }
//    }
    private void initApplication() { // В этом случае, для условия выполнения домашки, нам не нужно добавлять все шарики, а
        addSprite(new Background()); // Вызвать метод addSprite и в него пропихнуть клас Background.
                                       // Так как метод addSprite обращается к классу SpriteHome,
                                       // а класс SpriteHome в свою очередь умеет делать обновление и отрисовку шариком.
    }

    private MainCirclesHome() {
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Код написал преподаватель, я только попытался разобраться в нём...");

        GameCanvasHome canvas = new GameCanvasHome(this);

        canvas.addMouseListener(new MouseAdapter() { // addMouseListener (клик мышки) и к нему подключаем MouseAdapter
            @Override
            public void mouseReleased(MouseEvent e) { //
                if (e.getButton() == MouseEvent.BUTTON1) // если срабатывает MouseEvent.BUTTON1 - добавляем шары.
                    addSprite(new BallHome(e.getX(), e.getY())); // getX() и getY() из конструктора в классе BallHome
                else if (e.getButton() == MouseEvent.BUTTON3) // если срабатывает MouseEvent.BUTTON3 - удаляем шары.
                    removeSprite(); //
            }
        });
        add(canvas);
        initApplication();
        setVisible(true);
    }
    private void addSprite(SpriteHome s) { // метод добавления шариков
        if (spritesCount == sprites.length) { // если spritesCount уперся в длину массива и больше добавить шарик некуда, то
            SpriteHome[] temp = new SpriteHome[sprites.length * 2]; // создаем новый массив удвоенной длины.
            System.arraycopy(sprites, 0, temp, 0, sprites.length); // System.arraycopy - создает копию массива.
            // В System.arraycopy передаются 5 значений.
            // 1. src - от куда копируем
            // 2. srcPos - с какой позиции копируем
            // 3. dest - куда копируем
            // 4. destPos - на какую позицию копируем
            // 5. сколько элементов копируем (в нашем случае копируется sprites.length - весь массив)
            sprites = temp; // перезаписываем скопированный массив в sprites
        }
        sprites[spritesCount++] = s; // передвинули spritesCount на одну позицию (увеличили)
    }
    private  void removeSprite() { // Метод удаления шариков. Точнее метод не удаляет шарики из массива,
                                  // а просто уменьшает spritesCount на 1 и все, что за spritesCount не учитывает при выводах и отрисовках.
        if (spritesCount > 1) { // при условии, что в массиве шариков есть хотя бы один шарик
            spritesCount--; // уменьшили spritesCount на 1 элемент.
        }
    }

    public static void main(String[] args) {
        new MainCirclesHome();
    }

}
