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
			dynamic[0][j] = pMatrix[0][j] + dynamic[0][j-1];
		}
		for(int j = 1; j < ROW; j++)
		{
			dynamic[j][0] = pMatrix[j][0] + dynamic[j-1][0];
		}
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
			dynamic[i][1] = dynamic[i-1][1] + pMatrix[i][1];
			for(int j = 1; j < COL; j++)
			{
				dynamic[i][j] = Math.max(dynamic[i-1][j], (dynamic[i][j-1] + pMatrix[i][j]));
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
		return dynamic[ROW-1][COL-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[ROW][COL];
		for(int i = 0; i < ROW; i++)
		{
			for(int j = 0; j < COL; j++)
			{
				matrix[i][j] = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
				//matrix[i][j] = 1;
			}
		}
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
