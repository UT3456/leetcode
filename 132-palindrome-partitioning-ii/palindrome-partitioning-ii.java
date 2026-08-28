import java.util.Arrays;

class Solution {

    private int[] dp;

    public int minCut(String s) {
        int n = s.length();
        dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(s, 0, n - 1);
    }

    private int solve(String s, int i, int j) {

        // No cut needed
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        // Already computed
        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            // Only partition if left part is palindrome
            if (isPalindrome(s, i, k)) {

                int tempAns = 1 + solve(s, k + 1, j);
                ans = Math.min(ans, tempAns);
            }
        }

        return dp[i] = ans;
    }

    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}