/**
 * Created by Khanh-Long on 3/27/14.
 */
public class Wall {
    private int wallX, wallY;

    public Wall(int wallX, int wallY) {
        this.wallX = wallX;
        this.wallY = wallY;
    }

    public int getWallX() {
        return wallX;
    }

    public int getWallY() {
        return wallY;
    }

    public void setWallX(int x) {
        wallX = x;
    }

    public void setWallY(int y) {
        wallY = y;
    }
}
