import java.util.Scanner;

public class MaxSubArray {
	
	static int maxsum(int a[],int n)	
	{
		if(n==1)
		{
			return a[0];
		}
		
		int mid = n/2;
		int leftmax = maxsum(a,mid);
		
		int rightmax = maxsum(a,n-mid);
		int leftsum = -10;
		int rightsum = -10;
		int sum=0;
		
		for(int i=mid;i < n; i++)
		{
			sum = sum+ a[i];
			rightsum = Math.max(rightsum,sum);
		}
		sum = 0;
		
		for(int i= (mid-1);i >= 0; i--)
		{
			sum= sum+ a[i];
			leftsum = Math.max(leftsum,sum);
		}
		
		int ans = Math.max(leftmax,rightmax);
		return Math.max(ans,leftsum+rightsum);
	}


	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n=sc.nextInt();
		int[] a=new int[n];
		System.out.println("Enter "+n+" numbers in array: ");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		int max= maxsum(a,n);
		System.out.println("Maximum sum of subarray is = "+max);

	}

}
