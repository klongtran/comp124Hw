import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.util.Random;

/**
 * Created by Khanh-Long on 3/19/14.
 */
public class ChangingColorSquare extends GraphicsProgram {

    public void run() {
        double x = (getWidth() - width)/2;
        double y = (getHeight() - height)/2;
        GRect rect = new GRect(x, y, width, height);
        add(rect);

        while (true) {
            Random generator = new Random();
            int red = generator.nextInt(255);
            int green = generator.nextInt(255);
            int blue = generator.nextInt(255);

            Color randomColor = new Color(red, green, blue);
            rect.setFilled(true);
            rect.setColor(randomColor);
            pause(100);
        }

    }

    private static final int width = 200;
    private static final int height = 100;
}
