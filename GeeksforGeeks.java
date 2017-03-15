
public class GeeksforGeeks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = new int[]{60, 100, 120,20, 40, 30, 70};
        int wt[] = new int[]{10,20,30,5,10,15,5};
    int  W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
    
    int n1 = 3, k = 100;
    System.out.println("Minimum number of trials in worst case with "+n1+"  eggs and "+k+
             " floors is "+eggDrop(n, k));   
	}
	
	
	 static int eggDrop(int n, int k)
	    {
	       /* A 2D table where entry eggFloor[i][j] will represent minimum
	       number of trials needed for i eggs and j floors. */
	        int eggFloor[][] = new int[n+1][k+1];
	        int res;
	        int i, j, x;
	          
	        // We need one trial for one floor and0 trials for 0 floors
	        for (i = 1; i <= n; i++)
	        {
	            eggFloor[i][1] = 1;
	            eggFloor[i][0] = 0;
	        }
	          
	       // We always need j trials for one egg and j floors.
	        for (j = 1; j <= k; j++)
	            eggFloor[1][j] = j;
	          
	        // Fill rest of the entries in table using optimal substructure
	        // property
	        for (i = 2; i <= n; i++)
	        {
	            for (j = 2; j <= k; j++)
	            {
	                eggFloor[i][j] = Integer.MAX_VALUE;
	                for (x = 1; x <= j; x++)
	                {
	                     res = 1 + max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
	                     if (res < eggFloor[i][j])
	                        eggFloor[i][j] = res;
	                }
	            }
	        }
	          
	        // eggFloor[n][k] holds the result
	        return eggFloor[n][k];
	 
	    }
	
	
	    /* Function to get minimum number of trials needed in worst
	    case with n eggs and k floors */
	   /* static int eggDrop(int n, int k)
	    {
	       /* A 2D table where entry eggFloor[i][j] will represent minimum
	       number of trials needed for i eggs and j floors. */
	      /*  int eggFloor[][] = new int[n+1][k+1];
	        int res;
	        int i, j, x;
	          
	        // We need one trial for one floor and0 trials for 0 floors
	        for (i = 1; i <= n; i++)
	        {
	            eggFloor[i][1] = 1;
	            eggFloor[i][0] = 0;
	        }
	          
	       // We always need j trials for one egg and j floors.
	        for (j = 1; j <= k; j++)
	            eggFloor[1][j] = j;
	          
	        // Fill rest of the entries in table using optimal substructure
	        // property
	        for (i = 2; i <= n; i++)
	        {
	            for (j = 2; j <= k; j++)
	            {
	                eggFloor[i][j] = Integer.MAX_VALUE;
	                for (x = 1; x <= j; x++)
	                {
	                     res = 1 + max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
	                     if (res < eggFloor[i][j])
	                        eggFloor[i][j] = res;
	                }
	            }
	        }
	          
	        // eggFloor[n][k] holds the result
	        return eggFloor[n][k];
	    }
	
	*/
	    // A utility function that returns maximum of two integers
	     static int max(int a, int b) { return (a > b)? a : b; }
	      
	     // Returns the maximum value that can be put in a knapsack of capacity W
	     static int knapSack(int W, int wt[], int val[], int n)
	     {
	        // Base Case
	    if (n == 0 || W == 0)
	        return 0;
	      
	    // If weight of the nth item is more than Knapsack capacity W, then
	    // this item cannot be included in the optimal solution
	    if (wt[n-1] > W)
	       return knapSack(W, wt, val, n-1);
	      
	    // Return the maximum of two cases: 
	    // (1) nth item included 
	    // (2) not included
	    else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
	                     knapSack(W, wt, val, n-1)
	                      );
	      }

}
