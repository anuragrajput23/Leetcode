class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        int maxLen = 1;
        int cnt=1;
        for(int ele : nums){
            while(set.contains(ele)){
                cnt++;
                ele = ele+1;
            }
            maxLen = Math.max(cnt,maxLen);
            cnt=1;
        }
        return maxLen-1;
    }
}