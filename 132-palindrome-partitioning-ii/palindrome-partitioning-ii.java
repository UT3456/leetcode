import java.util.Arrays;

class Solution {

    public boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int solve(String str, int i, int j, int[] dp) {

        if (i >= j) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            if (isPalindrome(str, i, k)) {
                int tempAns = 1 + solve(str, k + 1, j, dp);
                ans = Math.min(ans, tempAns);
            }
        }

        return dp[i] = ans;
    }

    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(s, 0, n, dp) - 1;
    }
}