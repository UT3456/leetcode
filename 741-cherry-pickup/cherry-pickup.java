class Solution {

    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return Math.max(0, solve(grid, 0, 0, 0));
    }

    private int solve(int[][] grid, int r1, int c1, int r2) {

        int n = grid.length;

        // Calculate c2
        int c2 = r1 + c1 - r2;

        // Invalid
        if (r1 >= n || c1 >= n ||
            r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 ||
            grid[r2][c2] == -1) {
            return (int) -1e9;
        }

        // Destination
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        // Already calculated
        if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }

        // Current cherries
        int cherries = grid[r1][c1];

        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        // Four choices

        // Right, Right
        int f1 = solve(grid, r1, c1 + 1, r2);

        // Down, Right
        int f2 = solve(grid, r1 + 1, c1, r2);

        // Down, Down
        int f3 = solve(grid, r1 + 1, c1, r2 + 1);

        // Right, Down
        int f4 = solve(grid, r1, c1 + 1, r2 + 1);

        int max = Math.max(
                Math.max(f1, f2),
                Math.max(f3, f4)
        );

        return dp[r1][c1][r2] = cherries + max;
    }
}