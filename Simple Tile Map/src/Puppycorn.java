/**
 * Created by Khanh-Long on 3/30/14.
 */
public class Puppycorn extends MythicalAnimal {
    public Puppycorn(String name, int strength, int xCoord, int yCoord)
    {
        super(name, strength, xCoord, yCoord);
    }

    public boolean fightFire(){
        return false;
    }
    public boolean fightIce(){
        return true;
    }
    public boolean fightElectricity(){
        return false;
    }
}
