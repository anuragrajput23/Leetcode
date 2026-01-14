class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(nums[i]);
            int currSum=0;
            for(int j=i; j<n; j++){
                currSum += nums[j];
                set.add(nums[j]);
                if(set.contains(currSum)){
                    ans++;
                }
            }
        }
        return ans;
    }
}