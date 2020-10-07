import java.util.*;
import java.lang.Math; 

public class karatsuba {
	
	static String mult(String x, String y)
	{
		int xl=x.length();
		int yl=y.length();
		
		String a=x.substring(0,xl/2);
		String b=x.substring(xl/2,xl);
		String c=y.substring(0,yl/2);
		String d=y.substring(yl/2,yl);
		System.out.println(a + " " + b);
		System.out.println(c + " " + d);
		int aa=Integer.parseInt(a);
		int bb=Integer.parseInt(b);
		int cc=Integer.parseInt(c);
		int dd=Integer.parseInt(d);
				
		double z= ((aa*cc*Math.pow(10, xl)) + bb*dd + (((aa+bb)*(cc+dd)-aa*cc-bb*dd)*Math.pow(10, xl/2)));
		return Double.toString(z);		
		
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Input first number: ");
		String a=sc.nextLine();		
		System.out.println("Input second number: ");
		String b=sc.nextLine();		
		String c=mult(a,b);
		System.out.println("Product is = " +c);
	}

}

