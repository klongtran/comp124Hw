import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Khanh-Long on 3/28/14.
 */
public class ImageLoader {

    public BufferedImage load(String path) {
        try {
            return ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
