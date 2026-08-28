class Solution {

    public int minCut(String s) {
        int n = s.length();

        // dp[i] = minimum cuts needed for substring s[0...i-1]
        int[] dp = new int[n + 1];

        // isPal[i][j] = true if s[i...j] is palindrome
        boolean[][] isPal = new boolean[n][n];

        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }

        for (int end = 0; end < n; end++) {

            for (int start = 0; start <= end; start++) {

                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 || isPal[start + 1][end - 1])) {

                    isPal[start][end] = true;

                    dp[end + 1] = Math.min(
                        dp[end + 1],
                        dp[start] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}