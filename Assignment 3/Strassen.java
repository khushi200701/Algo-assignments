import java.util.Scanner;

public class Strassen 
{
	public static int[][] sub(int[][] x, int[][] y)
    {
        int n = x.length;
        int[][] z = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                z[i][j]= x[i][j]-y[i][j];
        return z;
    }
	
	public static int[][] add(int[][] x, int[][] y)
    {
        int n = x.length;
        int[][] z = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                z[i][j] =x[i][j] +y[i][j];
        return z;
    }
	
	static void split(int[][] l, int[][] m, int i, int j) 
    {
        for(int a = 0,b=i;a<m.length;a++,b++)
            for(int c=0,d=j;c<m.length;c++,d++)
                m[a][c] = l[b][d];
    }
	static void join(int[][] m, int[][] l, int i, int j) 
    {
        for(int a = 0,b= i; a < m.length;a++,b++)
            for(int c= 0, d= j; c< m.length; c++, d++)
                l[b][d] = m[a][c];
    }    
	
	static int[][] mult(int a[][], int b[][]) 
	{ 
		int n=a.length;
		int[][] c=new int[n][n];
		
		if (n==1)
            c[0][0] = a[0][0]*b[0][0];
		
        else
        {
            int[][] a1 = new int[n/2][n/2];
            int[][] a2 = new int[n/2][n/2];
            int[][] a3 = new int[n/2][n/2];
            int[][] a4 = new int[n/2][n/2];
            int[][] b1 = new int[n/2][n/2];
            int[][] b2 = new int[n/2][n/2];
            int[][] b3 = new int[n/2][n/2];
            int[][] b4 = new int[n/2][n/2];
 
            split(a,a1,0,0);
            split(a,a2,0,n/2);
            split(a,a3,n/2,0);
            split(a,a4,n/2,n/2);
           
            split(b,b1,0,0);
            split(b,b2,0,n/2);
            split(b,b3,n/2,0);
            split(b,b4,n/2,n/2);
 
            /*
              M1 = (A11 + A22)(B11 + B22)
              M2 = (A21 + A22) B11
              M3 = A11 (B12 - B22)
              M4 = A22 (B21 - B11)
              M5 = (A11 + A12) B22
              M6 = (A21 - A11) (B11 + B12)
              M7 = (A12 - A22) (B21 + B22)
            */
 
            int [][] M1 = mult(add(a1,a4), add(b1,b4));
            int [][] M2 = mult(add(a3,a4),b1);
            int [][] M3 = mult(a1,sub(b2,b4));
            int [][] M4 = mult(a4,sub(b3,b1));
            int [][] M5 = mult(add(a1,a2),b4);
            int [][] M6 = mult(sub(a3,a1), add(b1,b2));
            int [][] M7 = mult(sub(a2,a4), add(b3,b4));
 
            /*
              C11 = M1 + M4 - M5 + M7
              C12 = M3 + M5
              C21 = M2 + M4
              C22 = M1 - M2 + M3 + M6
           */
            int [][] c1 = add(sub(add(M1, M4), M5), M7);
            int [][] c2 = add(M3, M5);
            int [][] c3 = add(M2, M4);
            int [][] c4 = add(sub(add(M1, M3), M2), M6);
 
            
            join(c1,c,0,0);
            join(c2,c,0,n/2);
            join(c3,c,n/2,0);
            join(c4,c,n/2,n/2);
        }
       
        return c;
    }
		

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter order of matrices (n) : ");
		int n=sc.nextInt();
		int[][] a=new int[n][n];
		int[][] b=new int[n][n];
		System.out.println("Enter values in matrix A: ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("Enter values in matrix B: ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				b[i][j]=sc.nextInt();
			}
		}
		
		int[][] c=new int[n][n];
		c=mult(a,b);
		
		System.out.println("Resultant matrix : ");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(c[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	

}
