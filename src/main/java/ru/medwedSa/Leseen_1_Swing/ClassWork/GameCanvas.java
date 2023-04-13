package ru.medwedSa.Leseen_1_Swing.ClassWork;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GameCanvas extends JPanel { // Создали класс GameCanvas. Canvas - холст, положка на которой будем рисовать, выполнять действия.
                                         // Точка отсчёта с левого верхнего угла.
                                         // JPanel - это самый простой облегченный контейнерный класс,
                                         // который является частью пакета java.swing.
                                         // Он может группировать или хранить набор компонентов вместе,
                                         // главным образом для создания пользовательского интерфейса.
    private long lastFrameTime; // Текущее время
    private final MainCircles controller; // в качестве переменной храним ссылку на класс MainCircles со значением controller,
                                          // для того, что бы по ссылке MainCircles мы могли обратиться к controller.

    GameCanvas(MainCircles controller) { // Конструктор GameCanvas в который мы принимаем ссылку на controller в классе MainCircles.
        lastFrameTime = System.nanoTime(); // System.nanoTime() для измерения относительных интервалов времени.
        this.controller = controller; // если нам передали какой-то объект в controller, то ссылку на него мы записываем controller.
    }
    @Override
    protected void paintComponent(Graphics g){ // Переопределили метод paintComponent для рисования на созданной панели.
        super.paintComponent(g); // Обращаемся к родительскому классу от JPanel  для работы в paintComponent для перерисовки. Или как //  { do
// Строка 22 и 23 это стандартный набор для переопределения метода paintComponent, а ниже мы прописываем логику перерисовки.
// Но перерисовка окна занимает какое-то количество время, по этому.. :
        long currentTime = System.nanoTime(); // Берем текущее время.
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f; // Вычисляем дельту времени:
                                                                        // из текущего времени (currentTime) - время последнего обновления (lastFrameTime) * на 0.000000001f (чтобы поучить значение не в наносек, а в сек.)
        lastFrameTime = currentTime; // обновляем информацию в lastFrameTime относительно текущего времени.
        controller.onDrawCanvas(this, g, deltaTime); // в controller.onDrawCanvas, для отрисовки передаем:
                                                          // this - отрисованную себя(canvas)
                                                          // g - фигуру, которую рисуем (из метода Graphics)
                                                          // deltaTime - дельта времени.
        try {
            Thread.sleep(17);  // Класс Thread сформирует задержку перерисовывания в 17 миллисекунд или примерно 60 fps (60 кадров в секунду),
                                    // что вполне достаточно для плавности картинки и разгрузит оперативную память.
                                    // Без этого ограничения fps может быть от 200 до ... , в зависимости от железа в компьютере.
                                    // Вычисление 1 сек. / 60 кадров = 16,6 миллисекунд.
        } catch (InterruptedException e) { // прерывание ошибки.
            e.printStackTrace(); // что произошло, и где в коде это произошло.
        }
        repaint(); // Окно перерисовать. Запустили бесконечный цикл. // } while(true)
    }
// Геттеры для создания размеров, границ canvas:
    public int getLeft() {return 0; } // Левая граница. 0 по X
    public int getRight() {return getWidth() - 1; } // Текущая ширина canvas - 1 пиксель. По координате X + getWidth() - 1.
    public int getTop() {return 0; } // Верхняя граница. 0 по Y
    public int getBottom() {return getHeight() - 1; } // Текущая высота - 1 пиксель. По координате Y + getHeight() - 1.

}
