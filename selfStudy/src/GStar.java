import acm.graphics.GMath;
import acm.graphics.GPolygon;

/**
 * Created by Khanh-Long on 3/19/14.
 */
public class GStar extends GPolygon {
    public GStar(double width) {
        double dx = width / 2;
        double dy = dx * GMath.tanDegrees(18);
        double edge = width / 2 - dy * GMath.tanDegrees(36);
        addVertex(-dx, -dy);
        int angle = 0;
        for (int i = 0; i < 5; i++){
            addPolarEdge(edge, angle);
            addPolarEdge(edge, angle + 72);
            angle -= 72;
        }
    }
}
