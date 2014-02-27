package inheritance;

abstract public class Animal
{
    //The animal class has
    public String species;

    public Animal(String species)
	{
		this.species = species;
	}

	abstract public String pet();
	abstract public String giveMeat();
    abstract public String tickle();
    abstract public String feedFish();
}
