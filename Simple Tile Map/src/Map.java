/**
 * Created by Khanh-Long on 3/27/14.
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * The map holds the data about game area. In this case its responsible
 * for both rendering the map and check collision against the grid cells
 * within.
 *
 * Our map is a simple WIDTHxHEIGHT grid containing value 0 to indicate
 * a clear cell and 1 to incidate a wall.
 *
 * @author Kevin Glass
 */
public class Map {

    /** The value indicating a clear cell */
    private static final int CLEAR = 0;
    /** The value indicating a blocked cell */
    private static final int BLOCKED = 1;
    /** The value indicating potion */
    private static final int POTION = 2;
    /** The value indicating monster */
    private static final int MONSTER = 3;
    /** The value indicating treasure */
    private static final int TREASURE = 4;

    /** The width in grid cells of our map */
    private static final int WIDTH = 15;
    /** The height in grid cells of our map */
    private static final int HEIGHT = 15;

    /** The rendered size of the tile (in pixels) */
    public static final int TILE_SIZE = 50;

    /** The actual data for our map */
    private int[][] data = new int[WIDTH][HEIGHT];

    private int[][] dragonCoords, unicornCoords, puppycornCoords;

    private float distanceToTreasure;

    private int treasureX, treasureY;

    public Dragon dragon;
    public Unicorn unicorn;
    public Puppycorn puppycorn;
    /**
     * Create a new map with some default contents
     */
    public Map() {

        Random random = new Random();
        // create some default map data - it would be way

        // cooler to load this from a file and maybe provide

        // a map editor of some sort, but since we're just doing

        // a simple tutorial here we'll manually fill the data

        // with a simple little map

        for (int y = 0; y < HEIGHT; y++) {
            data[0][y] = BLOCKED;
            data[2][y] = BLOCKED;
            data[7][y] = BLOCKED;
            data[11][y] = BLOCKED;
            data[WIDTH-1][y] = BLOCKED;
        }
        for (int x = 0; x < WIDTH; x++) {
            if ((x > 0) && (x < WIDTH-1)) {
                data[x][10] = CLEAR;
            }

            if (x > 2) {
                data[x][9] = BLOCKED;
            }
            data[x][0] = BLOCKED;
            data[x][HEIGHT-1] = BLOCKED;
        }

        data[4][9] = CLEAR;
        data[7][5] = CLEAR;
        data[7][4] = CLEAR;
        data[12][9] = CLEAR;
        data[11][7] = CLEAR;
        data[1][13] = POTION;
        data[5][13] = POTION;
        data[10][1] = POTION;

        dragon = new Dragon("Daenaerys", 10, random.nextInt(WIDTH), random.nextInt(HEIGHT));
        unicorn = new Unicorn("Alice", 5, random.nextInt(WIDTH), random.nextInt(HEIGHT));
        puppycorn = new Puppycorn("Bob", 7, random.nextInt(WIDTH), random.nextInt(HEIGHT));

        data[dragon.getxCoord()][dragon.getyCoord()] = MONSTER;
        data[unicorn.getxCoord()][unicorn.getyCoord()] = MONSTER;
        data[puppycorn.getxCoord()][puppycorn.getyCoord()] = MONSTER;

        treasureX = random.nextInt(WIDTH);
        treasureY = random.nextInt(HEIGHT);

        data[treasureX][treasureY] = TREASURE;
    }

    /**
     * Render the map to the graphics context provided. The rendering
     * is just simple fill rectangles
     *
     * @param g The graphics context on which to draw the map
     */
    public void paint(Graphics2D g) {
        // loop through all the tiles in the map rendering them

        // based on whether they block or not

        for (int x=0;x<WIDTH;x++) {
            for (int y=0;y<HEIGHT;y++) {

                // so if the cell is blocks, draw a light grey block

                // otherwise use a dark gray

                g.setColor(Color.darkGray);
                if (data[x][y] == BLOCKED) {
                    g.setColor(Color.gray);
                } else
                if (data[x][y] == POTION) {
                    g.setColor(Color.pink);
                } else
                if (data[x][y] == MONSTER) {
                    g.setColor(Color.red);
                } else
                if (data[x][y] == TREASURE) {
                    g.setColor(Color.gray);
                }

                // draw the rectangle with a dark outline

                g.fillRect(x*TILE_SIZE,y*TILE_SIZE,TILE_SIZE,TILE_SIZE);
                g.setColor(g.getColor().darker());
                g.drawRect(x*TILE_SIZE,y*TILE_SIZE,TILE_SIZE,TILE_SIZE);
            }
        }
    }

    /**
     * Check if a particular location on the map is blocked. Note
     * that the x and y parameters are floating point numbers meaning
     * that we can be checking partially across a grid cell.
     *
     * @param x The x position to check for blocking
     * @param y The y position to check for blocking
     * @return True if the location is blocked
     */
    public boolean blocked(float x, float y) {
        // look up the right cell (based on simply rounding the floating

        // values) and check the value

        return data[(int) x][(int) y] == BLOCKED;
    }

    public boolean potion(float x, float y) {
        // look up the cell with potion

        return data[(int) x][(int) y] == POTION;
    }

    public boolean monster(float x, float y) {
        // look up the cell with monsters

        return data[(int) x][(int) y] == MONSTER;
    }

    public void setData(float x, float y, int k) {
        data[(int) x][(int) y] = k;
    }

//    public void setCellColor(float x, float y) {
//        g.fillRect((int)x*TILE_SIZE,(int)y*TILE_SIZE,TILE_SIZE,TILE_SIZE);
//        g.setColor(g.getColor().darker());
//    }

    public int getTreasureX() { return treasureX;}
    public int getTreasureY() { return treasureY;}

}
