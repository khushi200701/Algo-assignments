
public class PolyMult {
	 
	   
	   static int[] multiply(int A[], int B[],int m, int n)  
	    { 
	        int[] u1 = new int[m + n - 1]; 
	        int[] v1 = new int[m + n - 1]; 
	        int[] w1 = new int[m + n - 1]; 
	        int[] x1 = new int[m + n - 1]; 

	        int[] A0 = new int[m]; 
	        int[] A1 = new int[m]; 
	        int[] B0 = new int[n]; 
	        int[] B1 = new int[n]; 
	  

	        for (int i = 0; i < m/2; i++)  
	        { 
	            A0[i] = A[i]; 
	        } 
	  
	    for (int k=0,i = m/2; i < m; i++,++k)  
	        { 
	            A1[k] = A[i]; 
	        } 
	  
	    for (int i = 0; i < n/2; i++)  
	        { 
	            B0[i] = B[i]; 
	        } 
	  
	    for (int k=0, i = n/2; i < n; i++,++k)  
	        { 
	            B1[k] = B[i]; 
	        } 
	  
	  
	    u1=multiply(A0,B0,m/2,n/2);
	    v1=multiply(A0,B1,m/2,n/2+1);
	    w1=multiply(A1,B0,m/2+1,n/2);
	    x1=multiply(A1,B1,m/2+1,n/2+1);
	    
	    
	        return (u1+(v1+w1)+x1); 
	    }
	  
	   static void printPoly(int poly[], int n)  
	    { 
	        for (int i = 0; i < n; i++)  
	        { 
	            System.out.print(poly[i]); 
	            if (i != 0)  
	            { 
	                System.out.print("x^" + i); 
	            } 
	            if (i != n - 1)  
	            { 
	                System.out.print(" + "); 
	            } 
	        } 
	    } 
	  
	
	    public static void main(String[] args) 
	    { 
	        // The following array represents  
	        // polynomial 5 + 10x^2 + 6x^3 
	        int A[] = {5, 0, 10, 6}; 
	  
	        // The following array represents  
	        // polynomial 1 + 2x + 4x^2 
	        int B[] = {1, 2, 4}; 
	        
	        int m = A.length; 
	        int n = B.length; 
	  
	        System.out.println("First polynomial is n"); 
	        printPoly(A, m); 
	        System.out.println("nSecond polynomial is n"); 
	        printPoly(B, n); 
	  
	        int[] pro = multiply(A, B, m, n); 
	  
	        System.out.println("nProduct polynomial is n"); 
	        printPoly(pro, m + n - 1); 
	    } 
	}

	


