class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = cand.length;
        List<Integer> list = new ArrayList<>();
        solve(0,n,ans,list,target,cand);
        return ans;
    }
    public void solve(int i, int n, List<List<Integer>> ans, List<Integer> list,int target,int[] cand){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i==n) return;
        solve(i+1,n,ans,list,target,cand);
        if(target >= cand[i]){
        list.add(cand[i]);
            solve(i,n,ans,list,target-cand[i],cand);
            list.remove(list.size() - 1);
        }
    }
}