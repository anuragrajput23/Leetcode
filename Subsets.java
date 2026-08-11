class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(0, list, nums, ans);
        return ans;
    }
    public void solve(int i, List<Integer> list, int[] nums, List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        solve(i+1,list,nums,ans);
        list.remove(list.size()-1);
        solve(i+1,list,nums,ans);
    }
}