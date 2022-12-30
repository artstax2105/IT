
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
//класс должен иметь одно приватное поле.
//BufferdImage управляет изображением, содержимое которого можно записать
    private BufferedImage image;
//
    // конструктор принимает высоту и ширину и инициализирует объект BufferedImage новым изображением
//TYPE_INT_RGB - обозначает что цвета будут красные зеленые и синие
    public JImageDisplay(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension dimension = new Dimension(width, height);
        //когда компонент включен, он отобразит все изображение
        super.setPreferredSize(dimension);
    }

    // для предоставления собственного код для отрисовки
    //мы передаем null, т.к ImageObserver больше не требуется
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

    //    данный метод устанавливает все пиксели в черный цвет
    // через цикл проходит по всем пикселям и задает новый цвет
    public void clearImage() {
        for (int i=0; i < image.getHeight(); i++ ) {
            for (int j = 0; j < image.getWidth(); j ++) {
                drawPixel(i,j,0);
            }
        }
    }

    //    данный пиксель устанавливает все пиксели в определенные цвет
    public void drawPixel (int x, int y, int rgbColor) {
        image.setRGB(x,y,rgbColor);
    }
}