package bugs.bug_6_Polygon_containc_method_does_not_work_correctly;


import java.awt.*;

public class PolygonTest {
    public static void main(String[] args) {
        int[] xPoints = {2, -2, -2, 2};
        //int[] xPoints = {-2, 2, -2, 2};
        int[] yPoints = {2, 2, -2, -2};
// Internally, a polygon comprises of a list of (x,y) coordinate pairs, where each pair defines a vertex of the polygon, and two successive pairs are the endpoints of a line that is a side of the polygon.
// The first and final pairs of (x,y) points are joined by a line segment that closes the polygon.
        Polygon polygon = new Polygon(xPoints, yPoints, xPoints.length);
        boolean checkPoint = polygon.contains(1, 1);
        System.out.print(checkPoint);//why false?) -> should be true))
    }
}
