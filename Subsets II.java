class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        solve(0,nums,list,ans);
        return ans;
    }
    public void solve(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=idx; i<nums.length; i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            solve(i+1,nums,list,ans);
            list.remove(list.size()-1);
        }
    }
}