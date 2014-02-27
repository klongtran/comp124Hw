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
		return "tears it apart";
	}

    public String getName()
    {
        return "Lion";
    }
}
