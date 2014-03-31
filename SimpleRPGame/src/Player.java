import java.awt.*;


/**
 * Created by Khanh-Long on 3/28/14.
 */
public class Player {

    private int x, y;
    private ImageManager im;
    private Level level;
    public boolean up = false, dn = false, lt = false, rt = false;
    //private final int SPEED = 3;

    public Player(int x, int y, Level level, ImageManager im) {
        this.x = x;
        this.y = y;
        this.im = im;
        this.level = level;
    }

    public void tick() {
        if (up && (level.getTileType(x, y - 1) == 1)) {
            y -= 1;
        }
        if (dn && (level.getTileType(x, y + 1) == 1)) {
            y += 1;
        }
        if (lt && (level.getTileType(x - 1, y) == 1)) {
            x -= 1;
        }
        if (rt && (level.getTileType(x + 1, y) == 1)) {
            x += 1;
        }
    }

    public boolean validLocation(int nx, int ny) {
        if (isMountain(nx - 16, ny - 16)) {
            return false;
        }
        if (isMountain(nx + 16, ny - 16)) {
            return false;
        }
        if (isMountain(nx - 16, ny + 16)) {
            return false;
        }
        if (isMountain(nx + 16, ny + 16)) {
            return false;
        }

        // if all the points checked are unblocked then we're in an ok

        // location

        return true;
    }

    public boolean isMountain(int x, int y) {
        if ((x >= 0) && (y >= 0))
            if ((x <= 20) && (y <= 20))
               if ((level.getTileType(x, y) == 2))
                return true;
        return false;
    }

    public void render(Graphics g) {
        g.drawImage(im.player, x, y, Game.TILESIZE * Game.SCALE, Game.TILESIZE * Game.SCALE, null);
    }
}
