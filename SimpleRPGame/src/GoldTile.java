import java.awt.*;

/**
 * Created by Khanh-Long on 3/28/14.
 */
public class GoldTile extends Tile {

    public GoldTile(ImageManager im) {
        super(im);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(im.goldTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
    }
}
