class Solution {
    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        dp = new int[m+1][n+1];
        for(int[] row : dp) Arrays.fill(row,-1000000000);
        return solve(0,0,nums1,nums2);
    }
    public int solve(int i, int j, int []nums1, int[] nums2){
        if(i==nums1.length || j==nums2.length) return -1000000000;
        if(dp[i][j]!=-1000000000) return dp[i][j];
        int moment = nums1[i]*nums2[j];
        int incre_i = solve(i+1,j,nums1,nums2);
        int incre_both = (nums1[i]*nums2[j]) + solve(i+1, j+1, nums1, nums2);
        int incre_j = solve(i,j+1,nums1,nums2);

        int maxi1 = Math.max(moment, incre_i);
        int maxi2 = Math.max(incre_both, incre_j);

        return dp[i][j]= Math.max(maxi1,maxi2);

    }
}
