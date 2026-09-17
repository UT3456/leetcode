class Solution {
      public int coinChange(int[] coins, int amount) {

         int dp[][]=new int [coins.length+1][amount+1];
         for(int arr[]:dp){
            Arrays.fill(arr,-1);
         }
                 int res=solve(coins,amount,0,dp);
        return  res==(int)(1e9)?-1:res;
    }

    private int solve(int coins[], int amount, int i,int[][]dp) {
        if (amount==0)
            return 0;
        if(i>=coins.length && amount>0)
        {
            //that means i cannot for,
            return (int)(1e9);
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        
            //this mean i dont have any coins 
        
        int take = (int)(1e9);
        //i can only take if it is less than the amount

        if (coins[i] <= amount)
            take = 1 + solve(coins, amount - coins[i], i,dp);
        int skip = solve(coins, amount, i + 1,dp);
        return dp[i][amount]=Math.min(take, skip);

    }
    public int numSquares(int n) {
      int n1=(int)Math.sqrt(n);
      int arr[]=new int [n1];
      for(int i=0;i<n1;i++)
      {
        arr[i]=(i+1)*(i+1);

      }
      return   coinChange(arr,n); 
    }
}