/**
 * Created by Khanh-Long on 3/27/14.
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import java.util.Scanner;

/**
 * A single entity moving round our map. It maintains its position
 * in terms of grid cells. Note that the positions are floating
 * point numbers allowing us to be partially across a cell.
 *
 * @author Khanh-Long Tran
 */
public class Entity {
    /** The x position of this entity in terms of grid cells */
    private float x;
    /** The y position of this entity in terms of grid cells */
    private float y;
    /** The image to draw for this entity */
    private Image image;
    /** The map which this entity is wandering around */
    private Map map;
    /** The angle to draw this entity at */
    private float ang;
    /** The size of this entity, this is used to calculate collisions with walls */
    private float size = 0.3f;
    /** Amout of gold the player has */
    private int health = 15;

    private Scanner userInput = new Scanner(System.in);

    public boolean dead = false;

    String[] accepted = {"0", "1", "2", "3"};
    /**
     * Create a new entity in the game
     *
     * @param image The image to represent this entity (needs to be 32x32)
     * @param map The map this entity is going to wander around
     * @param x The initial x position of this entity in grid cells
     * @param y The initial y position of this entity in grid cells
     */
    public Entity(Image image, Map map, float x, float y) {
        this.image = image;
        this.map = map;
        this.x = x;
        this.y = y;
    }

    public double OriginalDistance() {
        int objectX = map.getTreasureX();
        int objectY = map.getTreasureY();

        double originalDistance = Math.sqrt((1.5 - objectX)*(1.5 - objectX) + (1.5 - objectY)*(1.5 - objectY));

        return originalDistance;
    }

    public double CurrentDistance() {

        int objectX = map.getTreasureX();
        int objectY = map.getTreasureY();

        double currentDistance = Math.sqrt((x - objectX)*(x - objectX) + (y - objectY)*(y - objectY));

        return currentDistance;
    }

    public String HuntStatus() {
        if (CurrentDistance() >= OriginalDistance()) return "Wrong way dude!";
        else if (CurrentDistance() == 0) return "You got it!";
        else return "Getting there!";
    }

    public Boolean foundTreasure() {
        if ((int) x == map.getTreasureX() && (int) y == map.getTreasureY()) return true;
        return false;
    }

    /**
     * Move this entity a given amount. This may or may not succeed depending
     * on collisions
     *
     * @param dx The amount to move on the x axis
     * @param dy The amount to move on the y axis
     * @return True if the move succeeded
     */
    public boolean move(float dx, float dy) {
        // work out what the new position of this entity will be

        float nx = x + dx;
        float ny = y + dy;

        // check if the new position of the entity collides with

        // anything

        if (validLocation(nx, ny)) {
            // if it doesn't then change our position to the new position

            x = nx;
            y = ny;

            // and calculate the angle we're facing based on our last move

            ang = (float) (Math.atan2(dy, dx) - (Math.PI / 2));
            return true;
        } else if (potionLocation(nx, ny)) {
            // if it is a gold location update the gold a player has

            health += 50;

            map.setData(nx, ny, 0);

            // then update the new position
            x = nx;
            y = ny;

            // and calculate the angle we're facing based on our last move

            ang = (float) (Math.atan2(dy, dx) - (Math.PI / 2));
            return true;
        } else if (monsterLocation(nx, ny)) {
            //tell the user which animal was found
            MythicalAnimal enemy = getMonster((int) nx, (int) ny);
            System.out.println("You found " + enemy.getName() + "! Now slay it or die trying!");

            //fight while alive (have health points)
            while (health>0){
                //choose how to fight
                System.out.println("You have " + health + " HP left!");
                System.out.println("Choose to fight with: fire(0), ice(1), electricity(2).");
                String inp = userInput.nextLine();

                //check for the right type of input
                while (!in(accepted, inp)){
                    System.out.println("You must type in an integer 0 thru 3.");
                    inp = userInput.nextLine();
                }

                //start the fight
                int fightChoice = Integer.parseInt(inp);
                fight(fightChoice, enemy);

                //check if the user won
                if(enemy.healthPoints<1){
                    System.out.println("You won! " + enemy.getName() + " is dead!");
                    map.setData(nx, ny, 0);
                    // then update the new position
                    x = nx;
                    y = ny;

                    ang = (float) (Math.atan2(dy, dx) - (Math.PI / 2));
                    return true;
                }
            }
            dead = true;
        }

        // if it wasn't do anything apart from
        // tell the caller

        return false;
    }

    /**
     * Check if the entity would be at a valid location if its position
     * was as specified
     *
     * @param nx The potential x position for the entity
     * @param ny The potential y position for the entity
     * @return True if the new position specified would be valid
     */
    public boolean validLocation(float nx, float ny) {
        // here we're going to check some points at the corners of

        // the player to see whether we're at an invalid location

        // if any of them are blocked then the location specified

        // isn't valid

        if (map.blocked(nx - size, ny - size)) {
            return false;
        }
        if (map.blocked(nx + size, ny - size)) {
            return false;
        }
        if (map.blocked(nx - size, ny + size)) {
            return false;
        }
        if (map.blocked(nx + size, ny + size)) {
            return false;
        }

        // if all the points checked are unblocked then we're in an ok

        // location

        return true;
    }

    public boolean potionLocation(float nx, float ny) {
        // here we're going to check some points at the corners of

        // the player to see whether we're at an invalid location

        // if any of them are blocked then the location specified

        // isn't valid

        if (map.potion(nx - size, ny - size)) {
            return true;
        }
        if (map.potion(nx + size, ny - size)) {
            return true;
        }
        if (map.potion(nx - size, ny + size)) {
            return true;
        }
        if (map.potion(nx + size, ny + size)) {
            return true;
        }

        // if all the points checked are not gold
        return false;
    }

    public boolean monsterLocation(float nx, float ny) {
        // here we're going to check some points at the corners of

        // the player to see whether we're at an invalid location

        // if any of them are blocked then the location specified

        // isn't valid

        if (map.monster(nx - size, ny - size)) {
            return true;
        }
        if (map.monster(nx + size, ny - size)) {
            return true;
        }
        if (map.monster(nx - size, ny + size)) {
            return true;
        }
        if (map.monster(nx + size, ny + size)) {
            return true;
        }

        // if all the points checked are not monsters
        return false;
    }

    /**
     * Draw this entity to the graphics context provided.
     *
     * @param g The graphics context to which the entity should be drawn
     */
    public void paint(Graphics2D g) {
        // work out the screen position of the entity based on the

        // x/y position and the size that tiles are being rendered at. So

        // if we'e'd render on screen
        // at 15,15.

        int xp = (int) (Map.TILE_SIZE * x);
        int yp = (int) (Map.TILE_SIZE * y);

        // rotate the sprite based on the current angle and then

        // draw it

        g.rotate(ang, xp, yp);
        g.drawImage(image, (int) (xp - 16), (int) (yp - 16), null);
        g.rotate(-ang, xp, yp);
    }

    public int getHealth() {
        return health;
    }

    //command for fighting, adjusted for the type of fighting
    public void fight(int choice, MythicalAnimal enemy)
    {
        //create a random generator to account for luck while fighting
        Random dice = new Random();
        switch(choice)
        {
            //check whether the enemy knows how to fight using the magic chosen by the user,
            //if yes, the enemy loses relatively fewer health points than the user does, and vice versa.
            case 0:
                if (enemy.fightFire()){
                    enemy.healthPoints -=1;
                    int userDamage = dice.nextInt(3);
                    health -= userDamage;
                    System.out.println("You ain't doing so great...");
                    System.out.println(enemy.getName()+" lost 1 health point, but you lost " + userDamage + " in the counterstrike");
                }
                else{
                    enemy.healthPoints-=5;
                    int userDamage = dice.nextInt(2);
                    health -= userDamage;
                    System.out.println("Good job!");
                    System.out.println(enemy.getName()+" lost 5 health points, whereas you lost " + userDamage + " in the counterstrike");
                }
                break;
            case 1:
                if (enemy.fightIce()){
                    enemy.healthPoints-=1;
                    int userDamage = dice.nextInt(4);
                    health -= userDamage;
                    System.out.println("You ain't doing so great...");
                    System.out.println(enemy.getName()+" lost 1 health point, but you lost " + userDamage + " in the counterstrike");
                }
                else{
                    enemy.healthPoints-=6;
                    int userDamage = dice.nextInt(3);
                    health -= userDamage;
                    System.out.println("Good job!");
                    System.out.println(enemy.getName()+" lost 6 health points, whereas you lost " + userDamage + " in the counterstrike");
                }
                break;
            case 2:
                if (enemy.fightElectricity()){
                    enemy.healthPoints-=1;
                    int userDamage = dice.nextInt(6);
                    health -= userDamage;
                    System.out.println("You ain't doing so great...");
                    System.out.println(enemy.getName()+" lost 1 health point, but you lost " + userDamage + " in the counterstrike");
                }
                else{
                    enemy.healthPoints-=5;
                    int userDamage = dice.nextInt(2);
                    health -= userDamage;
                    System.out.println("Good job!");
                    System.out.println(enemy.getName()+" lost 5 health points, whereas you lost " + userDamage + " in the counterstrike");
                }
                break;
        }
    }

    public MythicalAnimal getMonster(int xCoord, int yCoord) {
        if (monsterLocation(xCoord, yCoord)) {
            if (xCoord == map.dragon.xCoord && yCoord == map.dragon.yCoord) return map.dragon;
            else if (xCoord == map.unicorn.xCoord && yCoord == map.unicorn.yCoord) return map.unicorn;
            else if (xCoord == map.puppycorn.xCoord && yCoord == map.puppycorn.yCoord) return map.puppycorn;
        } return null;
    }

    //check if a String character is in a String array
    private boolean in(String[] array, String input) {
        for (int i=0; i<array.length; i++) {
            if (input.equals(array[i])){
                return true;
            }
        }
        return false;
    }
}

