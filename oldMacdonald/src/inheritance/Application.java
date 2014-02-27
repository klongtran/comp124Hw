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
            println("What do you want to do?");
            println(getActions());
            int action = readInt();

		//--- Call the appropriate method on the mystery animal


            String result = mysteryAnimal.pet();
		    println("The animal " + result);

		//--- Ask the user what animal they think this is
            println("What do you think this animal is?");
            String guess = readLine();

            if (guess == mysteryAnimal.getName()) {
                println("You got it!");
            }

            println("Play again?");
            wantToPlay = readBoolean();
        }
    }

    public List<String> getActions() {
        List<String> actions = new LinkedList<>();

        actions.add("1. Pet");
        actions.add("2. Give meat");
        actions.add("3. Tickle");
        actions.add("4. Feed fish");

        return actions;
    }
}
