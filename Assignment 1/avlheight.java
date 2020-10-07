import java.util.*;
public class avlheight {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of nodes in tree : ");
		int n=sc.nextInt();
		double x=(Math.log(n)/Math.log(2));  //log n (base 2)
		int min=(int)x;
		float max=(float)(1.44*x);
		
		System.out.println("When height of one node is 1:");
		System.out.println("Minimum height of tree is "+(min+1)+"\nMaximum height of tree is "+(max+1));
		System.out.println();
		System.out.println("When height of one node is 0: ");
		System.out.println("Minimum height of tree is "+min+"\nMaximum height of tree is "+max);
		
		sc.close();

	}

}
