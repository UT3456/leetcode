class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return solve(text1,text2,text1.length(),text2.length());
        //bottom up 
        int  m=text1.length();
        int n=text2.length();
        int dp [][] =new int [m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            //if  either them is zero make it zero 
            dp[i][0]=0;
            
        }
        for(int i=0;i<=n ;i++) dp[0][i]=0;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {   if(text1.charAt(i-1)==text2.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }
        return dp[m][n];
    } 
    private int solve(String s1,String s2,int m,int n)
    {
        if(m==0 || n==0) return 0;
        //if they are matching
        if(s1.charAt(m-1)==s2.charAt(n-1))
        {
            return 1 + solve(s1,s1,m-1,n-1);
        }
        //eles take reaing 
        return Math.max(solve(s1,s2,m-1,n),solve(s1,s2,m,n-1));
    }
}