import java.util.Scanner;

class rod1 
{ 
    static int cut(int price[], int n) 
    { 
        if (n <= 0) 
            return 0; 
        int max= -10; 
  
        for (int i = 0; i<n; i++) 
            max= Math.max(max,price[i] + cut(price, n-i-1));   
        return max; 
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