import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Khanh-Long on 3/28/14.
 */
public class KeyManager implements KeyListener {

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Game.getPlayer().up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Game.getPlayer().dn = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Game.getPlayer().lt = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Game.getPlayer().rt = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Game.getPlayer().up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Game.getPlayer().dn = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Game.getPlayer().lt = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Game.getPlayer().rt = false;
        }
    }

    public void keyTyped(KeyEvent e) {

    }


}
