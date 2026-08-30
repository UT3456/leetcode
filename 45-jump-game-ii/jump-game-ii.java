class Solution {
    public int jump(int[] nums) {
        int []dp=new int [nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
    private int solve(int arr[],int i,int []dp)
    {
        if(i>=arr.length-1)
        {
            return 0;//no min jump needed you already at the index

        }
        if(dp[i]!=-1){
            return dp[i];
        }
        //try all ways
        int min=(int)(1e9);
        for(int j=1;j<=arr[i];j++)
        {
       min=Math.min(min ,1+solve(arr,i+j,dp));
        }
        return dp[i]=min;
    }
}