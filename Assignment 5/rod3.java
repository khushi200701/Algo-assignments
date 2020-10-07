
import java.util.*;

class rod3
{ 
    static int cut(int price[],int n) 
    { 
        int b[] = new int[n+1]; 
        b[0] = 0; 
  
        for (int i = 1; i<=n; i++) 
        { 
            int max = -10; 
            for (int j = 0; j < i; j++) 
                max = Math.max(max,price[j] +b[i-j-1]); 
            b[i] = max; 
        } 
        return b[n]; 
    } 
  
    public static void main(String args[]) 
    { 
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter maximum number of pieces ");
    	int t=sc.nextInt();
    	System.out.println("Enter the prices of pieces : ");
    	int[] a=new int[t];
    	for(int i=0;i<t;i++)
    	{
    		a[i]=sc.nextInt();
    	}
    	int n = a.length; 
        System.out.println("Maximum value = " +cut(a, n)); 
    } 
} 