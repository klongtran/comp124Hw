/**
 * Created by Khanh-Long on 3/30/14.
 */
public class Dragon extends MythicalAnimal {
    public Dragon(String name, int strength, int xCoord, int yCoord)
    {
        super(name, strength, xCoord, yCoord);
    }

    public boolean fightFire(){
        return true;
    }
    public boolean fightIce(){
        return false;
    }
    public boolean fightElectricity(){
        return true;
    }
}
