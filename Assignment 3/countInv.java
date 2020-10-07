import java.util.*;

class countInv {
	
	static int MergeSort(int[] a, int n) 
    { 
        int[] t = new int[n]; 
        return mergesort(a,t,0,n-1); 
    } 
	
	static int mergesort(int[] a, int[] t, int l, int r)
	{
		int mid;
		int count=0;
		
		if(r>l)
		{
			mid=(r+l)/2;
			
			count=mergesort(a,t,l,mid);
			count=count+mergesort(a,t,mid+1,r);
			count=count+merge(a,t,l,mid+1,r);
		}
		return count;
	}
	static int merge(int[] a, int[] t, int l, int mid, int r)
	{
		int count=0;
		int i=l;
		int j=mid;
		int k=l;
		
		while((i<=mid-1)&&(j<=r))
		{
			if(a[i]<=a[j])
			{
				t[k]=a[i];
				k++;
				i++;
			}
			else
			{
				t[k]=a[j];
				k++;
				j++;
				
				count=count+(mid-i);
			}
							
		}
		while(i<=mid-1)
		{
			t[k]=a[i];
			k++;
			i++;
		}
		while(j<=r)
		{
			t[k]=a[j];
			k++;
			j++;
		}
		
		for (i=l;i<=r;i++)
		{
			a[i]=t[i];
		}
		return count;
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
		
		int inversions= MergeSort(a,n);
		System.out.println("Number of inversions is = "+inversions);
		

	}

}
