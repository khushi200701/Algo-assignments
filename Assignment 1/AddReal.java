

import java.util.*;

public class AddInt {
	
	static String sum(String a, String b)
	{
		int al=a.length();
		int bl=b.length();		
		a=new StringBuilder(a).reverse().toString();
		b=new StringBuilder(b).reverse().toString();
		int car=0;
		String c="";
		
		if(al<bl) {
		for(int i=0;i<al;i++)
		{
			int sum=((int)(a.charAt(i)-'0')+(int)(b.charAt(i)-'0')+car);
			c=c+(char)(sum%10+'0');
			car=sum/10;
		}

		
		for(int i=al;i<bl;i++)
		{
			int sum=((int)(b.charAt(i)-'0')+car);
			c=c+(char)(sum%10+'0');
			car=sum/10;
		}
		}
		else
		{
			for(int i=0;i<bl;i++)
			{
				int sum=((int)(a.charAt(i)-'0')+(int)(b.charAt(i)-'0')+car);
				c=c+(char)(sum%10+'0');
				car=sum/10;
			}
			for(int i=bl;i<al;i++)
			{
				int sum=((int)(a.charAt(i)-'0')+car);
				c=c+(char)(sum%10+'0');
				car=sum/10;
			}
		}
		if(car>0)
			c=c+(char)(car);//+'0');
		
		c=new StringBuilder(c).reverse().toString();
		return c;
		
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Input first number: ");
		String a=sc.nextLine();		
		System.out.println("Input second number: ");
		String b=sc.nextLine();		
		String c=sum(a,b);
		System.out.println("Sum is = " +c);
	}

}
