import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Khanh-Long on 3/24/14.
 */
public class Map extends GraphicsProgram{

    Image tile = getImage("")

    char playerChar = '@';
    char groundChar = '.';
    char monsterChar = 'M';
    char potionChar = 'P';
    char wallChar = '/';

    int width, height;
    int playerX, playerY;
    int objectX, objectY;

    int playerHealth = 5;

    ArrayList<Monster> monsters = new ArrayList<Monster>();

    ArrayList<Potion> potions = new ArrayList<Potion>();

    ArrayList<Wall> walls = new ArrayList<Wall>();

    char[][] map;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        map = new char[width][height];
        fill(groundChar);
    }

    private void fill(char c) {
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                map[x][y] = c;
            }
    }

    public void setupMap() {
        //--- Hide treasure on the map
        Random dice = new Random();
        objectX = dice.nextInt(width);
        objectY = dice.nextInt(height);

        //--- Put the player on the map
        setPlayerLocation(dice.nextInt(width), dice.nextInt(height));

        //--- Hide monster on the map
        for (int i = 0; i < 5; i++) {
            monsters.add(new Monster(dice.nextInt(width), dice.nextInt(height)));
        }

        for (int i = 0; i < 3; i++) {
            potions.add(new Potion(dice.nextInt(width), dice.nextInt(height)));
        }

        for (int i = 0; i < 8; i++) {
            walls.add(new Wall(dice.nextInt(width), dice.nextInt(height)));
        }

        setMonsterLocation();
        setPotionLocation();
        setWallLocation();

    }

    public void movePlayer(char direction) {
        switch(direction){
            case 'N':
            case 'n':
                if(checkForWall()){
                    setPlayerLocation(playerX, playerY);
                    break;
                }
                if (checkForMonster()) {
                    if (beatMonster()) {
                        playerHealth--;
                    }
                    map[playerX][playerY] = groundChar;
                    setPlayerLocation(playerX, playerY - 1);
                    break;
                }
                if (checkForPotion()) {
                    playerHealth++;
                    map[playerX][playerY] = groundChar;
                    setPlayerLocation(playerX, playerY - 1);
                    break;
                }
                map[playerX][playerY] = groundChar;
                setPlayerLocation(playerX, playerY-1);
                break;
            case 'S':
            case 's':
                if(checkForWall()){
                    setPlayerLocation(playerX, playerY);
                    break;
                }
                if (checkForMonster()) {
                    if (beatMonster()) { playerHealth--; };
                    map[playerX][playerY] = groundChar;
                    setPlayerLocation(playerX, playerY + 1);
                    break;
                }
                if (checkForPotion()) {
                    playerHealth++;
                    map[playerX][playerY] = groundChar;
                    setPlayerLocation(playerX, playerY + 1);
                    break;
                }
                map[playerX][playerY] = groundChar;
                setPlayerLocation(playerX, playerY+1);
                break;
            case 'E':
            case 'e':
                if(checkForWall()){
                    setPlayerLocation(playerX, playerY);
                    break;
                }
                if (checkForMonster()) {
                    if (beatMonster()) { playerHealth--; };
                    map[playerX][playerY] = groundChar;
                    setPlayerLocation(playerX+1, playerY);
                    break;
                }
                if (checkForPotion()) {
                    playerHealth++;
                    map[playerX][playerY] = groundChar;
                    setPlayerLocation(playerX+1, playerY);
                    break;
               } 
                map[playerX][playerY] = groundChar;
                setPlayerLocation(playerX+1, playerY);
                break;
            case 'W':
            case 'w':
                if(checkForWall()){
                    setPlayerLocation(playerX, playerY);
                    break;
                }
                if (checkForMonster()) {
                    if (beatMonster()) { playerHealth--; };
                    map[playerX][playerY] = groundChar;
                    setPlayerLocation(playerX-1, playerY);
                    break;
                }
                if (checkForPotion()) {
                    playerHealth++;
                    map[playerX][playerY] = groundChar;
                    setPlayerLocation(playerX-1, playerY);
                    break;
                }
                map[playerX][playerY] = groundChar;
                setPlayerLocation(playerX-1, playerY);
                break;
        }
    }

    public void setPlayerLocation(int x, int y)
    {
        playerX = x;
        if (playerX < 0)
        {
            playerX = 0;
        }
        if (playerX > width-1)
        {
            playerX = width-1;
        }
        playerY = y;
        if (playerY < 0)
        {
            playerY = 0;
        }
        if (playerY > height-1)
        {
            playerY = height-1;
        }
        map[playerX][playerY] = playerChar;
    }

    public void setMonsterLocation()
    {
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getMonsterX() < 0)
            {
                monsters.get(i).setMonsterX(0);
            }
            if (monsters.get(i).getMonsterX() > width-1)
            {
                monsters.get(i).setMonsterX(width - 1);
            }
            if (monsters.get(i).getMonsterY() < 0)
            {
                monsters.get(i).setMonsterY(0);
            }
            if (monsters.get(i).getMonsterY() > height-1)
            {
                monsters.get(i).setMonsterY(height - 1);
            }
            map[monsters.get(i).getMonsterX()][monsters.get(i).getMonsterY()] = monsterChar;

        }
    }

    public void setPotionLocation()
    {
        for (int i = 0; i < potions.size(); i++) {
            if (potions.get(i).getPotionX() < 0)
            {
                potions.get(i).setPotionX(0);
            }
            if (potions.get(i).getPotionX() > width-1)
            {
                potions.get(i).setPotionX(width - 1);
            }
            if (potions.get(i).getPotionY() < 0)
            {
                potions.get(i).setPotionY(0);
            }
            if (potions.get(i).getPotionY() > height-1)
            {
                potions.get(i).setPotionY(height - 1);
            }
            map[potions.get(i).getPotionX()][potions.get(i).getPotionY()] = potionChar;

        }
    }

    public void setWallLocation()
    {
        for (int i = 0; i < walls.size(); i++) {
            if (walls.get(i).getWallX() < 0)
            {
                walls.get(i).setWallX(0);
            }
            if (walls.get(i).getWallX() > width-1)
            {
                walls.get(i).setWallX(width - 1);
            }
            if (walls.get(i).getWallY() < 0)
            {
                walls.get(i).setWallY(0);
            }
            if (walls.get(i).getWallY() > height-1)
            {
                walls.get(i).setWallY(height - 1);
            }
            map[walls.get(i).getWallX()][walls.get(i).getWallY()] = wallChar;

        }
    }

    @Override
    public String toString()
    {
        String output = "";
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                output += map[x][y];
            }
            output += System.getProperty("line.separator");
        }
        return output;
    }

    public boolean checkForWall() {
        for (int i = 0; i < walls.size(); i++) {
            if (walls.get(i).getWallX()==playerX && walls.get(i).getWallY()==playerY)
                return true;
        }
        return false;
    }

    public boolean checkForMonster() {
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getMonsterX()==playerX && monsters.get(i).getMonsterY()==playerY)
                return true;
        }
        return false;
    }

    public boolean checkForPotion() {
        for (int i = 0; i < potions.size(); i++) {
            if (potions.get(i).getPotionX()==playerX && potions.get(i).getPotionY()==playerY)
                return true;
        }
        return false;
    }

    public boolean objectFound()
    {
        return ((playerX==objectX) && (playerY==objectY));
    }

    public boolean beatMonster() {
        if (playerHealth >= 5) return true;
        else return false;
    }

    // TODO make a distance calculation function
    public double distance() {
        return Math.sqrt((playerX-objectX)*(playerX-objectX) + (playerY-objectY)*(playerY-objectY));
    }

    public int getPlayerX() { return playerX;}
    public int getPlayerY() { return playerY;}
    public int getObjectX() { return objectX;}
    public int getObjectY() { return objectY;}

    public String getPlayerCoordinate() {
        String coordinate = getPlayerX() + " " + getPlayerY();
        return coordinate;
    }

    public String getTreasureCoordinate() {
        String coordinate = getObjectX() + " " + getObjectY();
        return coordinate;
    }

}
