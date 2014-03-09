import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khanh-Long on 2/26/14.
 */
public class Person {

    public Person(String name, List<String> favoritePresents) {
        targetName = name;
        targetFavoritePresents = favoritePresents;
    }

    public String getName() { return targetName;};

    public void loveDevelop(String present){
        if (targetFavoritePresents.contains(present)){
            targetLoveLevel++;
        }
    }

    public String getEnding(){
        String response = null;

        if (targetLoveLevel >= LOVE_LEVEL_FOR_A_DATE){
            response = "Date";
        }   else if (targetLoveLevel < LOVE_LEVEL_FOR_A_DATE){
            response = "noDate";
        }

        return response;
    }

    public static final int LOVE_LEVEL_FOR_A_DATE = 3;

    private String targetName;
    private int targetLoveLevel = 0;
    private List<String> targetFavoritePresents = new ArrayList<>();
}
