package inheritance;

abstract public class Feline
	extends Animal
{
	public Feline(String species)
	{
		super(species);
	}

	@Override
	public String pet()
	{
		return "purrs";
	}
}
