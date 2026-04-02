class Solution {

    public int maximumAmount(int[][] coins) {
        return solve(0, 0, 0, coins);
    }
    private int solve(int i, int j, int k, int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        if (i >= m || j >= n) return Integer.MIN_VALUE;

        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] >= 0) return coins[i][j];
            else {
                if (k < 2) return 0;   // neutralize
                return coins[i][j];    // take loss
            }
        }

        int val = coins[i][j];

        if (val >= 0) {
            int right = solve(i, j + 1, k, coins);
            int down  = solve(i + 1, j, k, coins);
            return val + Math.max(right, down);
        } else {
            int right1 = solve(i, j + 1, k, coins);
            int down1  = solve(i + 1, j, k, coins);
            int takeLoss = val + Math.max(right1, down1);

            int neutralize = Integer.MIN_VALUE;
            if (k < 2) {
                int right2 = solve(i, j + 1, k + 1, coins);
                int down2  = solve(i + 1, j, k + 1, coins);
                neutralize = Math.max(right2, down2);
            }

            return Math.max(takeLoss, neutralize);
        }
    }
}