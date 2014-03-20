import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * Created by Khanh-Long on 3/19/14.
 */
public class DisplayPicture extends GraphicsProgram {
    public void run() {
        add(new GImage("ArsenalLogo.jpg"));
        addCitation("Courtesy GoogleImage");
    }

    private void addCitation(String text) {
        GLabel label = new GLabel(text);
        label.setFont(CITATION_FONT);
        double x = getWidth() - label.getWidth();
        double y = getHeight() - CITATION_MARGIN + label.getAscent();
        add(label, x, y);
    }

    private static final String CITATION_FONT = "SansSerif-10";
    private static final int CITATION_MARGIN = 13;

    public static final int APPLICATION_WIDTH = 640;
    public static final int APPLICATION_HEIGHT = 640 + CITATION_MARGIN;
}
