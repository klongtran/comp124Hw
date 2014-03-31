import java.awt.*;

/**
 * Created by Khanh-Long on 3/30/14.
 */
public class RedMonsterTile extends Tile {

    public RedMonsterTile(ImageManager im) {
        super(im);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(im.redMonsterTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
    }
}
