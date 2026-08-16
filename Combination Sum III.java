class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(1,k,n,ans,list);
        return ans;
    }
    public void solve(int idx,int k, int target, List<List<Integer>> ans, List<Integer> list){
        if(target==0){
            if(list.size()==k){
                ans.add(new ArrayList<>(list));
                return;
            }else{
                return;
            }
        }
        for(int i=idx; i<=9; i++){
            if(i<=target){
                list.add(i);
                solve(i+1,k,target-i,ans,list);
                list.remove(list.size()-1);
            }
        }
    }
}

//slight optimised
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(1,k,n,ans,list);
        return ans;
    }
    public void solve(int idx,int k, int target, List<List<Integer>> ans, List<Integer> list){
        if(target==0){
            if(list.size()==k){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(list.size()==k) return;
        for(int i=idx; i<=9; i++){
            if(i<=target){
                 if (i > target) {
                    break;
                }
                list.add(i);
                solve(i+1,k,target-i,ans,list);
                list.remove(list.size()-1);
            }
        }
    }
}