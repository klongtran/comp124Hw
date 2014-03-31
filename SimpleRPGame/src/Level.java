import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Khanh-Long on 3/28/14.
 */
public class Level {

    public int[][] tiles;
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
                    case "ff3c35"://POTION TILE
                        tiles[x][y] = 4;
                        break;
                    case "ff8419"://RED MONSTER TILE
                        tiles[x][y] = 5;
                        break;
                    case "7cff77"://GREEN MONSTER TILE
                        tiles[x][y] = 6;
                        break;
                    case "4635ff"://BLUE MONSTER TILE
                        tiles[x][y] = 7;
                        break;
                    case "ff21b5"://TREASURE TILE
                        tiles[x][y] = 8;
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
                getTile(x, y).render(g, x * Game.TILESIZE * Game.SCALE, y * Game.TILESIZE * Game.SCALE);
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
            case 4:
                return Tile.potion;
            case 5:
                return Tile.red;
            case 6:
                return Tile.green;
            case 7:
                return Tile.blue;
            case 8:
                return Tile.treasure;
            default:
                return Tile.grass;
        }
    }

    public int getTileType(int x, int y) {

        switch (tiles[x][y]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 1;
        }
    }
}
