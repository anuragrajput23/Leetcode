class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int i=0; i<n; i++){
            Set<Integer> odd = new HashSet<>();
            Set<Integer> even = new HashSet<>();
            for(int j=i; j<n; j++){
                if(nums[j]%2==0) even.add(nums[j]);
                else odd.add(nums[j]);
                if(odd.size()==even.size()){
                    maxLen = Math.max(maxLen, (j-i+1));
                }
            }

        }
        return maxLen;
    }
}