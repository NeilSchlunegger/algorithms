package balancedparen;

public class ParenthesisPrint {

		public static void main(String[] args)
		{
			parenFunc("",0,0,3);
			System.out.println();
		}

public static void parenFunc(String out, int leftParen, int rightParen, int pairsToPrint)
{
	if((leftParen == pairsToPrint) && (rightParen == pairsToPrint)){
		 System.out.println("equals called");
		System.out.println(out);
	}
	else
	{
		if(leftParen < pairsToPrint)
		{
			System.out.println("if left < pairs called, " + "out: " + out + "\tl: "+ leftParen + ", r: " + rightParen);
			parenFunc(out+"(",leftParen+1,rightParen,pairsToPrint);
		}
		if(rightParen < leftParen)
		{
			System.out.println("if right < left called, " + "out: " + out + "\tl: "+ leftParen + ", r: " + rightParen);
			parenFunc(out+")",leftParen,rightParen+1, pairsToPrint);
		}
	}
}
