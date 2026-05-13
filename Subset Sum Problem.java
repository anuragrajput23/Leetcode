class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp =new Boolean[n+1][sum+1];
        //populating base case
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }
        //poipulating all remaining boxes
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];



        // return solve(0,n,arr,sum, dp);
    }
    /*static boolean solve(int i, int n, int[] arr, int sum, Boolean[][] dp){
        if(sum==0) return true;
        if(i==n) return false;
        if(i==n-1){
            return (sum == arr[i]);
        }
        if(dp[i][sum]!=null){
            return dp[i][sum];
        }

        boolean take = false;
        if(arr[i] <= sum){
            take = solve(i+1, n, arr, sum-arr[i],dp);
        }
        boolean ntake = solve(i+1,n,arr,sum,dp);
        return dp[i][sum] = (take || ntake);
    }*/
}