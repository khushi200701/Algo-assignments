package myproject;

import java.util.Scanner;

public class MatrixChainRecursive 
{
	static int matrix(int m[],int i, int j)    //i,j is size of matrix
	{
		if(i>=j)
		{
			return 0;
		}
		
		int k;
		int count;
		int min=Integer.MAX_VALUE;
	
		
		for(k=i;k<j;k++)
		{
			count=matrix(m,i,k)+matrix(m,k+1,j)+m[i-1]*m[k]*m[j];
			
			 if (count<min) 
		            min = count;
			
		}
		return min;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of the matrices : ");
		int n=sc.nextInt();
		int[] m=new int[n+1];
		System.out.println("Enter order of the matrices : ");
		for(int i=0;i<=n;i++)
		{
			m[i]=sc.nextInt();
		}
		
		int cost;
		cost=matrix(m,1,n);
		System.out.println("Minimum cost : "+cost);

	}

}
