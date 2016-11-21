import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Neil {
	public int[][] mine;
	public static final int ROWMAX = 3;
	public static final int COLMAX = 3;
	public static final int RANMIN = 1;
	public static final int RANMAX = 2;
	
	public Neil()
	{
		mine = new int[ROWMAX][COLMAX];
		for(int i = 0; i < ROWMAX; i++)
		{
			for(int j = 0; j < COLMAX; j++)
			{
				mine[i][j] = ThreadLocalRandom.current().nextInt(RANMIN, RANMAX);
			}
		};
	}
	public void print()
	{
		for(int i = 0; i < ROWMAX; i++)
		{
			for(int j = 0; j < COLMAX; j++)
			{
				System.out.print(mine[i][j] + " ");
			}
			System.out.println();
		};
	}
	private static boolean isFinal(int x, int y)
	{
		if(x == ROWMAX - 1 && y == COLMAX - 1)
			return true;
		else
			return false;
	}
	private static boolean isValid(int x, int y, int[][] matrix){
        if(x >= 0 && y >= 0)
        {
            if(x < ROWMAX && y < COLMAX )
            {
                return true;
            }
        }
        return false;
    }
	
	 public static int findMaxGold(int[][] mines, int x, int y, int[][] storage){

		 return 0;
	    }
	 int  numberOfPaths(int n, int m)
	 {
	    if (m == 1 || n == 1)
	         return 1;

	    return  numberOfPaths(n-1, m) + numberOfPaths(n, m-1);
	         
	 }
	public static void main(String [] args)
	{
		Neil neil = new Neil();
		neil.print();
//		System.out.println(neil.findMax());
		int storage[][] = new int[ROWMAX][COLMAX];
		int maxGold = 0;
		for(int i = 0; i < ROWMAX; i++)
		{
			for(int j = 0; j < COLMAX; j++)
			{
				storage[i][j] = 0;
			}
		}
		System.out.println("Total num of paths is " + neil.numberOfPaths(ROWMAX,COLMAX));
		
	}

}
