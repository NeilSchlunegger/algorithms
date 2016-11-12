package cs350;
//source: http://www.sanfoundry.com/java-program-implement-graham-scan-algorithm-find-convex-hull/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GrahamScan
{
 private Stack<Point> hull = new Stack<Point>();

 public GrahamScan(ArrayList<Point> pts)
 {

     int N = pts.size();
     
     Collections.sort(pts);

     Collections.sort(pts, pts.get(0).POLAR_ORDER);

     hull.push(pts.get(0)); // p[0] is first extreme point
     int k1;
     for (k1 = 1; k1 < N; k1++)
         if (!pts.get(0).equals(pts.get(k1)))
             break;
     if (k1 == N)
         return; // all points equal

     int k2;
     for (k2 = k1 + 1; k2 < N; k2++)
         if (Point.ccw(pts.get(0), pts.get(k1), pts.get(k2)) != 0)
             break;
     hull.push(pts.get(k2-1)); // points[k2-1] is second extreme point

     for (int i = k2; i < N; i++)
     {
         Point top = hull.pop();
         while (Point.ccw(hull.peek(), top, pts.get(i)) <= 0)
         {
             top = hull.pop();
         }
         hull.push(top);
         hull.push(pts.get(i));
     }

 }

 public GrahamScan() {
	// TODO Auto-generated constructor stub
}

public Iterable<Point> hull()
 {
     Stack<Point> s = new Stack<Point>();
     for (Point p : hull)
         s.push(p);
     return s;
 }

}
