
import acm.program.ConsoleProgram;
import sun.net.www.content.image.gif;

import java.util.List;

public class Application
	extends ConsoleProgram
{
	public void run()
	{
		println("  *********************************");
		println("  ***  Road to the Winter Ball  ***");
		println("  *********************************");
		println();

		Game theGame = new Game();
        List<Person> girls = theGame.getLoveInterests();
        List<String> gifts = theGame.getActions();
        int personChoice = 0;

		while (!theGame.isOver())
		{
            println("Day " + theGame.getDay());
			println("Who do you want to gift? (1-Alice/2-Emma/3-Michelle)");

            personChoice = readInt()-1;

            println("Sounds like a plan. What do you wanna send " + girls.get(personChoice).getName() + "'s way? (1/2/3/4/5)");
            println(gifts);

            int giftChoice = readInt()-1;

            girls.get(personChoice).loveDevelop(gifts.get(giftChoice));

            println();

            theGame.day++;
		}

        for(int i = 0; i<girls.size();i++){
            String ending = girls.get(i).getEnding();

            println("With " + girls.get(i).getName() + theGame.getEndingText(ending));
        }


	}
}
