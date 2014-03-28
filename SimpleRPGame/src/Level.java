import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by Khanh-Long on 3/28/14.
 */
public class Level {

    private int[][] tiles;
    private int w, h;

    public Level(BufferedImage levelImage) {
        w = levelImage.getWidth();
        h = levelImage.getHeight();
        loadLevel(levelImage);
    }

    public void loadLevel(BufferedImage levelImage) {
        tiles = new int[levelImage.getWidth()][levelImage.getHeight()];
        for(int y = 0; y < levelImage.getHeight(); y++) {
            for(int x = 0; x < levelImage.getWidth(); x++) {
                Color c = new Color(levelImage.getRGB(x, y));
                String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());

                switch (h) {
                    case "00FF00"://GRASS TILE
                        tiles[x][y] = 1;
                        break;
                    case "4a4a4a"://MOUNTAIN TILE
                        tiles[x][y] = 2;
                        break;
                    case "ffde3d"://GOLD TILE
                        tiles[x][y] = 3;
                        break;
                    default:
                        tiles[x][y] = 1;
                        break;
                }
            }
        }
    }

    public void render(Graphics g) {
        for (int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                getTile(x, y).render(g, x * 16 * Game.SCALE, y * 16 * Game.SCALE);
            }
        }
    }

    public Tile getTile(int x, int y) {
        switch (tiles[x][y]) {
            case 1:
                return Tile.grass;
            case 2:
                return Tile.mountain;
            case 3:
                return Tile.gold;
            default:
                return Tile.grass;
        }
    }

}
