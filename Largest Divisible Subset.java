class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,-1,result,curr,nums);
        return result;
    }
    public void solve(int i,int prev, List<Integer> result, List<Integer> curr, int[] nums){
        if(i>=nums.length){
            if(curr.size() > result.size()){
                result.clear();
                result.addAll(curr);
            }
            return;
        }
        if(prev==-1 || nums[i]%nums[prev]==0){
            curr.add(nums[i]);
           solve(i+1,i, result, curr, nums);
        curr.remove(curr.size() - 1);
        }
        solve(i+1,prev,result,curr,nums);
    }
}