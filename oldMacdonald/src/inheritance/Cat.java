package inheritance;

public class Cat
    extends Feline
{
    public Cat()
    {
        super("Cat");
    }

    @Override
    public String giveMeat() {
        return "Nah, not interested";
    }

    @Override
    public String tickle() {
        return "PURR PURR PURR";
    }

    @Override
    public String feedFish()
    {
        return "Yummy! A whole salmon's just gone!";
    }
}
