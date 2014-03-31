/**
 * Created by Khanh-Long on 3/30/14.
 */
public class Unicorn extends MythicalAnimal {
    public Unicorn(String name, int strength, int xCoord, int yCoord)
    {
        super(name, strength, xCoord, yCoord);
    }

    public boolean fightFire(){
        return true;
    }
    public boolean fightIce(){
        return true;
    }
    public boolean fightElectricity(){
        return false;
    }
}
