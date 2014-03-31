/**
 * Created by Khanh-Long on 3/30/14.
 */
abstract public class MythicalAnimal {
    private String name;
    public int healthPoints;
    public int xCoord, yCoord;

    public MythicalAnimal(String name, int strength, int xCoord, int yCoord)
    {
        this.name = name;
        this.healthPoints = 20 + strength;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() { return xCoord;}
    public int getyCoord() { return yCoord;}

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    abstract boolean fightFire();
    abstract boolean fightIce();
    abstract boolean fightElectricity();
}
