class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(s, 0, memo);
    }

    private int solve(String s, int i, int[] memo) {
        if (i == s.length()) {
            return 1;  // Found one complete path
        }
        if (s.charAt(i) == '0') {
            return 0;  // Invalid
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        int ways = solve(s, i + 1, memo); // take 1 digit

        if (i + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(i, i + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += solve(s, i + 2, memo); // take 2 digits
            }
        }

        memo[i] = ways;
        return ways;
    }
}