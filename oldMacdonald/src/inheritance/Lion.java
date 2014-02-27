package inheritance;

public class Lion
	extends Feline
{
	public Lion()
	{
		super("Lion");
	}

	@Override
	public String giveMeat()
	{
		return "It tore right through it!";
	}

    @Override
    public String tickle() {
        return "It bit off your legs!";
    }

    @Override
    public String feedFish() {
        return "It wants to eat you instead!";
    }

}
