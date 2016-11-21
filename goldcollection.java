package sd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	public final static int ROW = 3;
	public final static int COL = 3;
	public final static int MIN = 0;
	public final static int MAX = 5;

	public static int coin(int[][] pMatrix)
	{
		int[][] dynamic = new int[ROW][COL];
		dynamic[0][0] = pMatrix[0][0];
		for(int j = 1; j < COL; j++)
		{
			dynamic[0][j] = pMatrix[0][j] + dynamic[0][j-1];//where youre at now + total from what it took to get there
		}
//		for(int j = 1; j < ROW; j++)
//		{
//			dynamic[j][0] = pMatrix[j][0] + dynamic[j-1][0];
//		}
		//dynamic[1][1] = pMatrix[0][1] + pMatrix[0][1] + pMatrix[1][1];

//		System.out.println("dynamic");
//		for(int i = 0; i < ROW; i++)
//		{
//			for(int j = 0; j < COL; j++)
//			{
//				System.out.print(dynamic[i][j] + "  ");
//			}
//			System.out.println();
//		}
		for(int i = 1; i < ROW; i++)
		{
			dynamic[i][0] = dynamic[i-1][0] + pMatrix[i][0];
			for(int j = 1; j < COL; j++)
			{
				dynamic[i][j] = Math.max(dynamic[i-1][j] + pMatrix[i][j], (dynamic[i][j-1] + pMatrix[i][j]));
			}
		}
		System.out.println("dynamic");
		for(int i = 0; i < ROW; i++)
		{
			for(int j = 0; j < COL; j++)
			{
				System.out.print(dynamic[i][j] + "  ");
			}
			System.out.println();
		}
		
		int i = ROW-1;
		int j = COL-1;
		Queue<Point> myQ = new LinkedList<Point>();
		myQ.add(new Point(i,j));
		//System.out.println(myStack);
		while(i != 0 || j != 0)
		{
			if(i == 0)
			{
				j = j - 1;
				myQ.add(new Point(i,j));
				continue;
			}
			if(j == 0)
			{
				i = i - 1;
				myQ.add(new Point(i,j));
				continue;
			}
			if(dynamic[i-1][j] > dynamic[i][j-1])
			{
				i = i-1;
				myQ.add(new Point(i,j));
			}
			else
			{	
				j = j-1;
				myQ.add(new Point(i,j));
			}
		}
		Stack<Point> myStack = new Stack<Point>();
		while(!myQ.isEmpty())
		{
			myStack.push(myQ.remove());
		}
		while(!myStack.isEmpty())
		{
			myQ.add(myStack.pop());
		}
		System.out.println(myQ);
		
		return dynamic[ROW-1][COL-1];
	}
	public static void main(String[] args) {
		int[][] matrix = new int[ROW][COL];
		for(int i = 0; i < ROW; i++)
		{
			for(int j = 0; j < COL; j++)
			{
				matrix[i][j] = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
				//matrix[i][j] = 1;
			}
		}
//		matrix[0][0] =  2;
//		matrix[0][1] =  4;
//		matrix[0][2] =  0;
//		matrix[1][0] =  0;
//		matrix[1][1] =  3;
//		matrix[1][2] =  0;
//		matrix[2][0] =  1;
//		matrix[2][1] =  0;
//		matrix[2][2] =  5;
		System.out.println("orig matrix");
		for(int i = 0; i < ROW; i++)
		{
			for(int j = 0; j < COL; j++)
			{
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println(coin(matrix));
		//System.out.println();

		//System.out.println(matrix[0][2]);
//		System.out.println("dynamic");
//		for(int i = 0; i < ROW; i++)
//		{
//			for(int j = 0; j < COL; j++)
//			{
//				System.out.print(matrix[i][j] + "  ");
//			}
//			System.out.println();
//		}
}
}
