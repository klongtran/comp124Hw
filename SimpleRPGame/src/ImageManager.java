import java.awt.image.BufferedImage;

/**
 * Created by Khanh-Long on 3/28/14.
 */
//--- Boost performance by creating instance variable to hold crop-out images
public class ImageManager {

    public BufferedImage player, grassTile, mountainTile, goldTile, redMonsterTile, potionTile,
                            greenMonsterTile, blueMonsterTile, treasureTile;

    //--- Crop out player and store him
    public ImageManager(SpriteSheet ss) {
        player = ss.crop(0, 0, 16, 16);
        grassTile = ss.crop(1, 0, 16, 16);
        mountainTile = ss.crop(2, 0, 16, 16);
        goldTile = ss.crop(3, 0, 16, 16);
        redMonsterTile = ss.crop(4, 0, 16, 16);
        potionTile = ss.crop(5, 0, 16, 16);
        greenMonsterTile = ss.crop(6, 0, 16, 16);
        blueMonsterTile = ss.crop(7, 0, 16, 16);
        treasureTile = ss.crop(0, 1, 16, 16);
    }

}
