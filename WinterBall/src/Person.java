/**
 * Created by Khanh-Long on 2/26/14.
 */
public class Person {

    public Person(String name, int loveLevel) {
        targetName = name;
        targetLoveLevel = loveLevel;
    }

    public void setName(String name) {
        targetName = name;
    }

    public void setTargetLoveLevel(int loveLevel) { targetLoveLevel = loveLevel}

    public static final int LOVE_LEVEL_FOR_A_DATE = 5;

    private String targetName;
    private int targetLoveLevel;
}
