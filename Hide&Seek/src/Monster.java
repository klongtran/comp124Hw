/**
 * Created by Khanh-Long on 3/26/14.
 */
public class Monster {
    private int health;
    private int power;
    private int monsterX, monsterY;

    public Monster(int monsterX, int monsterY) {
        this.monsterX = monsterX;
        this.monsterY = monsterY;
    }

    public int getHealth() {
        return health;
    }

    public int getMonsterX() {
        return monsterX;
    }

    public int getMonsterY() {
        return monsterY;
    }

    public void setMonsterX(int x) {
        this.monsterX = x;
    }

    public void setMonsterY(int y) {
        this.monsterY = y;
    }

}
