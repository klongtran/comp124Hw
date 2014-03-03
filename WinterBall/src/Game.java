import java.util.LinkedList;
import java.util.List;

/**
 * Created by Khanh-Long on 2/26/14.
 */
public class Game {
    public String getDay(int day) {
        String date = "February" + day;
        return date;
    }

    public List<String> getActions() {
        List<String> actions = new LinkedList<>();

        actions.add("Bubble tea");
        actions.add("Chocolate");
        actions.add("Moonshine");
        actions.add("Fake Swarovski necklace");
        actions.add("Dalai Lama ticket");

        return actions;
    }

    public List<Person> getLoveInterests() {
        List<Person> people = new LinkedList<>();
        Person aPerson;



        aPerson = new Person("Alice", 0);
        people.add(aPerson);

        return people;
    }

    public String getEnding() {

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

    }
}
