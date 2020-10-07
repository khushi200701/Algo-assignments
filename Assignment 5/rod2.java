
import java.util.*;

class rod2{
	
	  static final int MAX = 100000;
	  //static int[] r = new int[5+1];

	  
	  public static int cut(int price[], int n) 
	  {
		  int[]r=new int[n];
		  r[0] = 0;
		    for(int i=1; i<=5; i++) {
		      r[i] = -1*MAX;
		    }
	    if (r[n] >= 0) 
	    	{
	     		return r[n];
	    	}

	    int value = -1*MAX;
	    
	    for(int i=1; i<=n; i++) {
	      value = Math.max(value, price[i] + cut(price, n-i));
	    }

	    r[n] = value;
	    return r[n];
	  }

	  public static void main(String[] args) 
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