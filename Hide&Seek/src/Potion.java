/**
 * Created by Khanh-Long on 3/27/14.
 */
public class Potion {
    private int potionX, potionY;
    private static final int potionStrength = 10;

    public Potion(int potionX, int potionY) {
        this.potionX = potionX;
        this.potionY = potionY;
    }

    public int getPotionX() {
        return potionX;
    }

    public int getPotionY() {
        return potionY;
    }

    public void setPotionX(int x) {
        potionX = x;
    }

    public void setPotionY(int y) {
        potionY = y;
    }
}
