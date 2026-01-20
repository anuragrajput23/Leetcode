class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        ArrayList<int[]> list = new ArrayList<>();
        for(String str : strs){
            int one = 0;
            int zero = 0;
            for(char ch : str.toCharArray()){
                if(ch=='0') zero++;
                else one++;
            }
            list.add(new int[]{zero, one});
        }
        dp= new int[m+1][n+1][list.size()];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                for(int k=0; k<list.size(); k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0,m,n,list);
    }
    public int solve(int i, int m, int n, ArrayList<int[]> list){
        if(i>=list.size()) return 0;
        if(m==0 && n==0) return 0;
        if(dp[m][n][i]!=-1) return dp[m][n][i];
        int take = 0;
        if(m>=list.get(i)[0] && n>=list.get(i)[1]){
            take =1+ solve(i+1,m-list.get(i)[0],n-list.get(i)[1],list);
        }
        int ntake = solve(i+1,m,n,list);
        return dp[m][n][i]= Math.max(take,ntake);
    }
}