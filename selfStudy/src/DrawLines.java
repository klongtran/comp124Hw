import acm.graphics.GLine;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

/**
 * Created by Khanh-Long on 3/19/14.
 */
public class DrawLines extends GraphicsProgram {

    public void init() {
        addMouseListeners();
    }

    public void mousePressed(MouseEvent e) {
        line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
        add(line);
    }

    public void mouseDragged(MouseEvent e) {
        line.setEndPoint(e.getX(), e.getY());
    }

    private GLine line;
}
