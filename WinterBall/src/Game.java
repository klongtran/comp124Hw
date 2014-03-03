import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Khanh-Long on 2/26/14.
 */
public class Game {

    public String getDay() {
        String date = "February " + day;
        return date;
    }

    public List<String> getActions() {
        List<String> actions = new LinkedList<>();

        actions.add("Bubble tea");
        actions.add("Chocolate");
        actions.add("Moonshine");
        actions.add("Romantic sushi date");
        actions.add("Dalai Lama ticket");

        return actions;
    }

    public List<Person> getLoveInterests() {
        List<String> AliceFav = Arrays.asList("Bubble tea", "Romantic sushi date");
        List<String> EmmaFav = Arrays.asList("Chocolate", "Dalai Lama ticket");
        List<String> MichelleFav = Arrays.asList("Moonshine", "Dalai Lama ticket");

        Person Alice = new Person("Alice", AliceFav);
        Person Emma = new Person("Emma", EmmaFav);
        Person Michelle = new Person("Michelle", MichelleFav);

        List<Person> people = new LinkedList<>();

        people.add(Alice);
        people.add(Emma);
        people.add(Michelle);

        return people;
    }

    public String getEndingText(String endingID) {
        if (endingID.equals("noDate"))
        {
            return "Finally the day of the Winter Ball is here. " +
                    "Unfortunately, no matter how hard you tried (or didn't try), you just couldn't " +
                    "find that certain special someone who had the qualities you were looking for, " +
                    "which is a nice way of saying that nobody liked you enough to ask you out.";
        }

        return "Sorry, you got an ending that doesn't exist.";
    }

    public boolean isOver() {
        Boolean winterBallStart = false;

        if (day == 14){
            winterBallStart = true;
        }

        return winterBallStart;
    }

    public int day = 7;
}
