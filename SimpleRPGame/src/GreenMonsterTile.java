import java.awt.*;

/**
 * Created by Khanh-Long on 3/30/14.
 */
public class GreenMonsterTile extends Tile {

    public GreenMonsterTile(ImageManager im) {
        super(im);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(im.greenMonsterTile, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
    }
}
