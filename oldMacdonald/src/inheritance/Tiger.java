package inheritance;

/**
 * Created by Khanh-Long on 2/27/14.
 */
public class Tiger
    extends Feline
{
    public Tiger()
    {
        super("Tiger");
    }

    @Override
    public String giveMeat() {
        return "It tore through it!";
    }

    @Override
    public String tickle()
    {
        return "OUCH! It bit off your arm!";
    }

    @Override
    public String feedFish() {
        return "It ate your friend and the driving wheel in whole. Now it's your turn!";
    }

}
