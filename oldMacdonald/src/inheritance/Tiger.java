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
    public String tickle()
    {
        return "OUCH! It bit off your arm!";
    }

    public String getName()
    {
        return "Tiger";
    }
}
