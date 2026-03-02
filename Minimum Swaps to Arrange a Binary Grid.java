class Solution {
    public int minSwaps(int[][] grid) {
        // ArrayList<Integer> list = new ArrayList<>();
        int n = grid.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int j=n-1;
            int cnt = 0;
            while(j>=0 && grid[i][j]==0){
                cnt++;
                j--;
            }
            ans[i] = cnt;
        }
        int steps = 0;
        for(int i=0; i<n; i++){
            int req = n-i-1;
            int k;
            for(k=i; k<=n; k++){
                if(k==n) return -1;
                if(req <= ans[k]){
                    steps += (k-i);
                    break;
                }

            }
            while(k > i){
                int temp = ans[k];
                ans[k] = ans[k-1];
                ans[k-1] = temp;
                k--;
            }
        }
        return steps;
    }
}