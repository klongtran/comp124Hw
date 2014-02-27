package inheritance;

/**
 * Created by Khanh-Long on 2/27/14.
 */
public class Cat
        extends Feline
{
    public Cat()
    {
        super("cat");
    }

    @Override
    public String feedFish()
    {
        return "Yummy! A whole salmon's just gone!";
    }

    public String getName()
    {
        return "Cat";
    }
}
