class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(cand);
        solve(0,cand,target,list,ans);
        return ans;
    }
    public void solve(int idx, int[] cand, int target, List<Integer> list, List<List<Integer>> ans){
        int n = cand.length;
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx==n) return;
        for(int i=idx; i<n; i++){
            if(i>idx && cand[i]==cand[i-1]) continue;
            if(cand[idx] <= target){
                list.add(cand[i]);
                solve(i+1,cand,target-cand[i],list,ans);
                list.remove(list.size()-1);
            }else{
                break;
            }
        }
    }
}