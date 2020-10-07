import java.util.*;

public class exponent {
	
	    static int calc(int x,int n) 
	    { 
	        if (n==0) 
	            return 1; 
	        else if (n%2==0) 
	            return calc(x,n/2)*calc(x,n/2); 
	        else
	            return x*calc(x,n/2)*calc(x,n/2); 
	    } 
	  
	 
	    public static void main(String[] args) 
	    { 
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter number and power : ");
	        int x=sc.nextInt();
	        int n=sc.nextInt();
	        int ans=calc(x,n);
	  
	        System.out.println("Answer: "+ans); 
	    } 
	} 
