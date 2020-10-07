
import java.util.*;

public class maxmin 
{
	static maxmin m=new maxmin();
    static int max,min;
       
    
    public int[] MaxMin(int[] a,int i,int j,int max,int min)
    {
        int mid;
        int max_;
        int min_;
        
        int ans[]=new int[2];
       
        if (i==j) 
        { 
        	max = min = a[i]; 
        } 
        
        else if (i==j-1) 
          {
                if (a[i] < a[j]) 
                { 
                	this.max = getMax(this.max,a[j]); this.min = getMin(this.min,a[i]); 
                }
                else 
                { 
                	this.max = getMax(this.max,a[i]); this.min = getMin(this.min,a[j]); 
                }
          }
     else
     {
           
           mid= (i+j)/2;
        
           max_=min_=a[mid+1];
           MaxMin(a,i,mid,max,min);    
           MaxMin(a,mid+1,j,max_,min_);
          
           if (this.max < max_) this.max = max_;
           if (this.min > min_) this.min = min_;
     }
        ans[0]=this.max; ans[1]=this.min;
        return ans;
    }
    
    public static int getMax(int i,int j)
    {
        if(i>j) return i;
        else return j;
    }
    
    public static int getMin(int i,int j)
    {
        if(i>j) return j;
        else return i;
    }

   
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter total number of numbers :");
		int n=sc.nextInt();
		int[] a=new int[n];
		System.out.println("Enter numbers : ");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		
		maxmin.max=maxmin.min=a[0];
        int[] ans=m.MaxMin(a,0,n-1,a[0],a[0]);
        System.out.println("Maximum : "+ans[0]+"\nMinimum : "+ans[1]);
		

	}

}
