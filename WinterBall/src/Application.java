import Game.Game;
import acm.program.ConsoleProgram;

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

        int day = 0;

		while (!theGame.isOver())
		{
			println("Day " + theGame.getDay(day));
			println("What do you want to do?");

			int action = getAction(theGame.getActions());

			List<Person> boys = theGame.getLoveInterests();

			println();
            day++;
		}
		String ending = theGame.getEnding();
		println(theGame.getEndingText(ending));
	}

	private String getAction(List<String> actions)
	{
		for (int i=0; i<actions.size(); i++)
		{
			println(i + ") " + actions.get(i));
		}
		print("Choice: ");
		int selectedActionIndex = readInt();
		String action = actions.get(selectedActionIndex);
		return action;
	}
}
