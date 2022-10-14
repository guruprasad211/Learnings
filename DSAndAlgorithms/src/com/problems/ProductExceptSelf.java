package com.problems;
class ProductExceptSelf{
    
    void prodArray(int a[], int n){
        
        if(n == 1) { 
            System.out.print("0"); 
            return; 
        } 
  
        int prod = 1; 
        int p[] = new int[n]; 
  
        /* Initialize the product array p[] as 1 */
        for(int j=0; j<n; j++) 
            p[j] = 1; 
  
        /* prod variable contains product of 
           elements on left side excluding a[i] */
        for(int i=0; i<n; i++) { 
            p[i] = prod; 
            prod *= a[i]; 
        } 
        
        /* Initialize prod to 1 for product on right side */
        prod = 1; 
  
        /* prod variable contains product of 
           elements on right side excluding a[i] */
        for(int i=n-1; i>=0; i--) { 
            p[i] *= prod; 
            prod *= a[i]; 
        } 
        for(int i=0; i<n; i++) 
            System.out.print(p[i] + " ");
  
        return; 
    }
    
    public static void main(String[] args){
        ProductExceptSelf pro = new ProductExceptSelf();
      int a[] = { 1, 2,3};
      int n = a.length;
      pro.prodArray(a,n);
    }
}