import java.awt.*;


/**
 * Created by Khanh-Long on 3/28/14.
 */
public abstract class Tile {

    protected ImageManager im;

    public static Tile grass = new GrassTile(Game.getImageManager());
    public static Tile mountain = new MountainTile(Game.getImageManager());
    public static Tile gold = new GoldTile(Game.getImageManager());
    public static Tile red = new RedMonsterTile(Game.getImageManager());
    public static Tile potion = new PotionTile(Game.getImageManager());
    public static Tile green = new GreenMonsterTile(Game.getImageManager());
    public static Tile blue = new BlueMonsterTile(Game.getImageManager());
    public static Tile treasure = new TreasureTile(Game.getImageManager());

    public Tile(ImageManager im) {
        this.im = im;
    }

    public abstract void tick();

    public abstract void render(Graphics g, int x, int y);

}
