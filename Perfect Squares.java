class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            list.add(i*i);
        }
        return solve(0,n,list);
    }
    public int solve(int i, int sum, ArrayList<Integer> list){
        if(i>=list.size()) return Integer.MAX_VALUE;
        if(sum==0) return 0;
        int take =Integer.MAX_VALUE;
        int ntake;
        if(list.get(i)<=sum){
           int res = solve(i,sum-list.get(i),list);
           if(res != Integer.MAX_VALUE){
                take = 1+res;
           }
        }
        ntake = solve(i+1,sum,list);

        return Math.min(ntake,take);
    }
}