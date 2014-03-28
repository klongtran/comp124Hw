import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by Khanh-Long on 3/28/14.
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 320, HEIGHT = 336, SCALE = 2, TILESIZE = 16;
    public static boolean running = false;
    //** Help game multitask */
    public Thread gameThread;

    private BufferedImage spriteSheet;
    private static ImageManager im;

    private static Player player;

    private Level l1;

    public void init() {
        ImageLoader loader = new ImageLoader();
        spriteSheet = loader.load("/spritesheet.png");

        SpriteSheet ss = new SpriteSheet(spriteSheet);

        //--- set the player variable to spritesheet
        im = new ImageManager(ss);

        player = new Player(0, 0, im);

        BufferedImage limage = loader.load("/level.png");
        l1 = new Level(limage);

        this.addKeyListener(new KeyManager());

    }

    public synchronized void start() {
        if(running)return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stop() {
        if(!running)return;
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60D;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now -lastTime) / ns;
            lastTime = now;
            // only update 60 times per second
            if(delta >= 1) {
                tick();
                delta--;
            }
            // draw all objects onto screen
            render();
        }
    }

    public void tick() {
        player.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        //--- a paint brush
        Graphics g = bs.getDrawGraphics();
        //RENDER HERE

        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        l1.render(g);
        player.render(g);

        //END RENDER
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame("Tiles.Tile RPG");
        frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);

        /** Important line to prevent memory leak! */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        frame.setVisible(true);

        game.start();
    }

    public static Player getPlayer() {
        return player;
    }

    public static ImageManager getImageManager() {
        return im;
    }
}
