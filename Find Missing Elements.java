class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int mini = nums[0];
        int maxi = nums[0];
        for(int ele : nums){
            mini = Math.min(ele,mini);
            maxi = Math.max(ele,maxi);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int el : nums) set.add(el);
        for(int i=mini; i<=maxi;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}