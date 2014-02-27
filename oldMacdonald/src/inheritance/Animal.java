package inheritance;

abstract public class Animal
{

    public String species;
    private String name;

    public Animal(String species)
	{
		this.species = species;
	}

	abstract public String pet();
	abstract public String giveMeat();

    public String getName() {
        return name;
    }
}
