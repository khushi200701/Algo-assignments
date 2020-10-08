
import java.util.*;

public class ActivitySelectionGreedy
{
	static public void act(int[] s, int[] e, int n)
	{
		int i=0;
		System.out.print("Activities executed: ");
		System.out.print(i+" ");
		int count=1;
		for(int j=1;j<n;j++)
		{
			if(s[j]>=e[i])
			{
				System.out.print(j+" ");
				i=j;
				count++;				
			}
		}
		System.out.println("\nTotal activities executed: "+count);
		
	}
	

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of activities: ");
		int n=sc.nextInt();
		int[] start=new int[n];
		int[] end=new int[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter start and end times of activity: ");
			start[i]=sc.nextInt();
			end[i]=sc.nextInt();			
		}
		 
		act(start,end,n);
		

	}

}
