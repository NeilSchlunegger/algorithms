package cs350;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	public static final int MAX = 12;
	public static final int MIN_RANDOM = -10000;
	public static final int MAX_RANDOM = 10000;
	public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        ArrayList<Point> pointsClone1 = new ArrayList<Point>();
        ArrayList<Point> pointsClone2 = new ArrayList<Point>();
        ArrayList<Point> pointsClone3 = new ArrayList<Point>();
        for (int i = 0; i < MAX; i++)
        {
            int x = ThreadLocalRandom.current().nextInt(MIN_RANDOM, MAX_RANDOM);
            int y = ThreadLocalRandom.current().nextInt(MIN_RANDOM, MAX_RANDOM);
            Point tempPoint = new Point(x, y);
            points.add(i, tempPoint);
            pointsClone1.add(i,tempPoint);
            pointsClone2.add(i,tempPoint);
            pointsClone3.add(i,tempPoint);
        }

//        System.out.println("Raw Original Points are: ");
//        for(int i = 0; i < MAX; i++)
//        {
//        	System.out.print("(" + points.get(i).x + "," + points.get(i).y + ")");
//        }
//        System.out.println();
        QuickHull qh = new QuickHull();
        long startTime1 = System.nanoTime();
        ArrayList<Point> qhPoints = qh.quickHull(points);
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1) / 1000000;
        System.out.println("total time for QuickHull is " + duration1 + " ms");
        
        long startTime2 = System.nanoTime();
        ArrayList<Point> mcPoints = MonotoneChain.convex_hull(pointsClone1);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2) / 1000000;
        System.out.println("total time for Monotone is " + duration2 + " ms");
        
        long startTime3 = System.nanoTime();
        GrahamScan graham = new GrahamScan(pointsClone3);
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3) / 1000000;
        System.out.println("total time for Graham is " + duration3 + " ms");
 
        System.out.print("QH: ");
        for(Point ps: qhPoints)
        	System.out.print(ps);
       
        System.out.print("\nGS: ");
        for (Point ps : graham.hull())
          System.out.print(ps);

        System.out.print("\nMC: ");
        for(Point ps : mcPoints)
        	System.out.print(ps);
	}
}
