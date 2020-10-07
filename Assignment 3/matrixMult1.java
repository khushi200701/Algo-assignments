import java.util.*;

public class matrixMult1 {

	static void mult(int A[][], int B[][],int n) 
	{ 
		int[][] c=new int[n][n];
	    for (int i=0;i<n;i++) 
	    { 
	        for (int j=0;j<n;j++) 
	        { 
	            c[i][j] = 0; 
	            for (int k=0;k<n;k++) 
	            { 
	               c[i][j]= (A[i][k]*B[k][j])+c[i][j]; 
	            } 
	        } 
	    } 
	    
	    System.out.println("Resultant matrix : ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(c[i][j]+"  ");
			}
			System.out.println();
		}
	} 
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter order of matrices (n) : ");
		int n=sc.nextInt();
		int[][] a=new int[n][n];
		int[][] b=new int[n][n];
		System.out.println("Enter values in matrix A: ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter values in matrix B: ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				b[i][j]=sc.nextInt();
			}
		}
		mult(a,b,n);
		
	}

}
