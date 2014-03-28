import acm.program.ConsoleProgram;

import java.util.Random;

/**
 * Created by Khanh-Long on 3/24/14.
 */
public class Game extends ConsoleProgram {

    public void run() {
        play();
    }

    private void play() {
        //--- Create a map
        int width = 20, height = 10;
        Map theMap = new Map(width, height);

        theMap.setupMap();

        //--- Calculate player to treasure distance
        double originalDistance = theMap.distance();

        //--- While treasure isn't found
        println(theMap);
        boolean gameOver = false;
        while (!gameOver && theMap.playerHealth>0) {
            //--- Ask player where to go
            char direction = readChar("Move? (n,s,e,w) ");

            //--- Move the player
            theMap.movePlayer(direction);

            //--- Draw the map
            println(theMap);

            // TODO Tell them how they're doing
            if (theMap.distance()>originalDistance){ println("Cold.");}
            else if (theMap.distance()<originalDistance){ println("Hot!");}
            else if (theMap.distance()==originalDistance) { println("Lukewarm...");}
//            println("Player coordinates: " + theMap.getPlayerCoordinate());
//            println("Treasure coordinates: " + theMap.getTreasureCoordinate());
//            println("Distance: " + theMap.distance());

            // See if they won
            if (theMap.objectFound()) {
                println("You win!");
                gameOver = true;
            }
        }
    }
}
