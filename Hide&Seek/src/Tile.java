import java.awt.*;

/**
 * Created by Khanh-Long on 3/27/14.
 */
import java.awt.Color;

public class Tile {

    public static void main(String[] args) {
        Picture input = new Picture(args[0]);
        int height = input.height();
        int width  = input.width();
        int M = Integer.parseInt(args[1]);
        int N = Integer.parseInt(args[2]);

        Picture output = new Picture(N*input.width(), M*input.height());

        // convert to black and white
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = input.get(x, y);
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        output.set(width*j + x, height*i + y, c);
                    }
                }
            }
        }
        output.show();
        output.save("temp.png");
    }



}
