package inheritance;

import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by baylor on 2/26/14.
 */
public class Application
	extends ConsoleProgram
{
	public void run()
	{
		//--- Old MacDonald had a farm...
		List<Animal> farm = new ArrayList<>();
		Animal a = new Lion();
		farm.add(a);
		Animal b = new Tiger();
		farm.add(b);
		Animal c = new Cat();
		farm.add(c);

        println("Welcome to Animal Farm. Here visitors are constantly killed if they can't identify the beast in three tries!");
        println("One was unleashed and sprinting towards you! Act now!");
		//--- We're going to play this game until the user tells us to quit
		boolean wantToPlay = true;

		while (wantToPlay==true){

		//--- Pick an animal at random
            int size = farm.size();
            int pick = new Random().nextInt(size);

		//--- If you don't remember how to do random numbers,
		//---   Google is your friend. Also, your text book.
		    Animal mysteryAnimal = farm.get(pick);

		//--- Ask the user what action they want to take


		//--- Call the appropriate method on the mystery animal
            for (int j = 0; j<3; j++){
                println("What do you want to do? (3 tries before you die)");
                println(getActions());
                int action = readInt();
                switch (action) {
                    case 1:
                        println(mysteryAnimal.pet());
                        break;
                    case 2:
                        println(mysteryAnimal.giveMeat());
                        break;
                    case 3:
                        println(mysteryAnimal.tickle());
                        break;
                    case 4:
                        println(mysteryAnimal.feedFish());
                        break;
                    default:
                        println("Invalid choice");
                        break;
                }
            }
		//--- Ask the user what animal they think this is
            println("What do you think this animal is? (0-Lion/1-Tiger/2-Cat)");
            int guess = readInt();

            if (guess == pick) {
                println("You got it!");
            }

            println("That's not it! Play again? (true/false)");
            wantToPlay = readBoolean();
        }
    }

    public List<String> getActions() {
        List<String> actions = new LinkedList<>();

        actions.add("1. Feed OREOs");
        actions.add("2. Give Dalai Lama ticket");
        actions.add("3. Tickle the beast");
        actions.add("4. Just run, leave your girlfriend behind!");

        return actions;
    }
}
