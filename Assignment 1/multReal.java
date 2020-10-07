
import java.util.*;

public class multReal {
	
	static String multR(String a, String b)
	{
		String[] x=a.split("\\.");
		String[] y=b.split("\\.");
		a=x[0]+x[1];
		b=y[0]+y[1];
		String c=mult(a,b);
		
		int k=x[1].length()+y[1].length();
		c= c.substring(0,c.length()-k)+"."+c.substring(c.length()-k);
		
		return c;
		
	}
	static String mult(String a, String b)
	{
		int al=a.length();
		int bl=b.length();		
		a=new StringBuilder(a).reverse().toString();
		b=new StringBuilder(b).reverse().toString();
		
		int[] c=new int[al+bl];
		
		for(int i=0;i<al;i++)
		{
			for(int j=0;j<bl;j++)
			{
				c[i+j]=c[i+j]+(a.charAt(i)-'0')*(b.charAt(j)-'0');
			}
		}
		String pro="";
		for(int i=0;i<c.length;i++)
		{
			int d=c[i]%10;
			int car=c[i]/10;
			
			if(i+1<c.length)
			{
				c[i+1]=c[i+1]+car;
			}
			pro=pro+d;
		}
		pro=new StringBuilder(pro).reverse().toString();
		return pro;
		
		
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Input first number: ");
		String a=sc.nextLine();		
		System.out.println("Input second number: ");
		String b=sc.nextLine();		
		String c=multR(a,b);
		System.out.println("Product is = " +c);
	}

}

