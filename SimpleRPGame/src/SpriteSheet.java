import java.awt.image.BufferedImage;

/**
 * Created by Khanh-Long on 3/28/14.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage crop(int col, int row, int w, int h) {
        return sheet.getSubimage(col * 16, row * 16, w, h);
    }
}
