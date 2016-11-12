package cs350;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//source: https://en.wikibooks.org/wiki/Algorithm_Implementation/Geometry/Convex_hull/Monotone_chain#Java
public class MonotoneChain {
	public static long cross(Point O, Point A, Point B) {
		return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Point> convex_hull(ArrayList<Point> P) {

		if (P.size() > 1) {
			int n = P.size(), k = 0;
			ArrayList<Point> H = new ArrayList<Point>(2 * n);
			for(int i = 0; i < n; i++)
			{
				Point temp = new Point(P.get(i).x, P.get(i).y);
				H.add(i, temp);
			}

			Collections.sort(P);

			// Build lower hull
			for (int i = 0; i < n; ++i) {
				while (k >= 2 && cross(H.get(k-2), H.get(k-1), P.get(i)) <= 0)
					k--;
				H.set(k++, P.get(i));
			}

			// Build upper hull
			for (int i = n - 2, t = k + 1; i >= 0; i--) {
				while (k >= t && cross(H.get(k-2), H.get(k-1), P.get(i)) <= 0)
					k--;
				H.set(k, P.get(i));
				k++;
				//H[k++] = P[i];
			}
			if (k > 1) {
				//H = Arrays.copyOfRange(H, 0, k - 1); // remove non-hull vertices after k; remove k - 1 which is a duplicate
				List H2 = new ArrayList<Point>();
				H2 = new ArrayList<Point>(H.subList(0, k-1));
				H = (ArrayList<Point>) H2;
			}
			return H;
		} else if (P.size() <= 1) {
			return P;
		} else{
			return null;
		}
	}

}
