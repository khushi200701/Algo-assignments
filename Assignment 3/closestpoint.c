#include <stdio.h> 
#include <float.h> 
#include <stdlib.h> 
#include <math.h> 
  
 
struct givenPoint 
{ 
    int x;
    int y; 
}; 
  typedef struct givenPoint pt;

int cX(const void* a, const void* b) 
{ 
   pt *p1 = (pt *) a;
   pt *p2 = (pt *)b; 
    return (p1->x - p2->x); 
} 
 
int cY(const void* a, const void* b) 
{ 
    pt *p1 = (pt *)a,   *p2 = (pt *)b; 
    return (p1->y - p2->y); 
} 
  

float dist(pt p1, pt p2) 
{ 
    return pow( (p1.x - p2.x)*(p1.x - p2.x) + 
                 (p1.y - p2.y)*(p1.y - p2.y) , 1/2
               ); 
} 
  
//Brute Force method 
float bf(pt P[], int n) 
{ 
    float min = 50000.0; 
    for (int i = 0; i < n; ++i) 
        for (int j = i+1; j < n; ++j) 
            if (dist(P[i], P[j]) < min) 
                min = dist(P[i], P[j]); 
    return min; 
} 

float min(float x, float y) 
{ 
    return (x < y)? x : y; 
} 
  
  
 
float stripfn(pt s[], int n, float d) 
{ 
    float min = d;  // Initialize the minimum distance as d 
  
    qsort(s, n, sizeof(pt), cY);  
  
     
    for (int i = 0; i < n; ++i) 
        for (int j = i+1; j < n && (s[j].y - s[i].y) < min; ++j) 
            if (dist(s[i],s[j]) < min) 
                min = dist(s[i], s[j]); 
  
    return min; 
} 
  
//recursive function 
float close1(pt P[], int n) 
{ 
   
    if (n <= 3) 
        return bf(P, n); 
  
    int mid = n/2; 
    pt mid1 = P[mid]; 
  
    float dl = close1(P, mid); 
    float dr = close1(P + mid, n-mid); 
    float d = min(dl, dr); 
  
    pt s[n]; 
    int j = 0; 
    for (int i = 0; i < n; i++) 
        if (abs(P[i].x - mid1.x) < d) 
            s[j] = P[i], j++; 
  
  
    return min(d, stripfn(s, j, d) ); 
} 
  
float closest(pt P[], int n) 
{ 
    qsort(P, n, sizeof(pt), cX); 
    return close1(P, n); 
} 
  

int main() 
{ 
 //   pt P[]={{1,2},{10,15}};
    pt P[] = {{1, 2}, {4, 7}, {3, 4}, {7,2}, {1,10}, {3,6}}; 
    int n = sizeof(P) / sizeof(P[0]); 
    printf("The smallest distance is %f ", closest(P, n)); 
    return 0; 
}