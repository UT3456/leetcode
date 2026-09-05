class Solution {
    public int maxSumDivThree(int[] nums) {
    int dp[][]=new int[nums.length+1][3];
    for(int [] arr:dp)
    {
        Arrays.fill(arr,-1);
    }
        return solve(0,nums,0,dp);
    
        

    }
    private int solve(int i,int arr[],int rem, int [][]dp)
    {  if(i==arr.length)
    {
        return rem==0?0:Integer.MIN_VALUE;
    }
    if(dp[i][rem]!=-1) return dp[i][rem];
      int take = arr[i]+solve(i+1,arr,(rem+arr[i])%3,dp);
      int skip =solve(i+1,arr,rem,dp);
      return dp[i][rem]=Math.max(take,skip);
    }
}