class Solution {
    public static int longestBitonicSequence(int n, int[] arr) {
        // code here
        // int n = arr.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp1[i] = Math.max(dp1[i],dp1[j]+1);
                }
            }
        }
        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>i; j--){
                if(arr[i] > arr[j]){
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }
        int maxi = 0;
        for(int i=0; i<n; i++){
            if(dp1[i] > 1 && dp2[i] > 1){
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        }
        return maxi;
    }
}
