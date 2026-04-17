class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            if (map.containsKey(nums[i])) {
                mini = Math.min(mini, Math.abs(map.get(nums[i])-i));
                map.put(reversed(nums[i]),i);
            }else{
                int rev = reversed(nums[i]);
                map.put(rev, i);
            }
        }
        return mini==Integer.MAX_VALUE ? -1 : mini;
    }
    public int reversed(int num){
        int ans = 0;
        while(num != 0){
            int rem = num%10;
            ans = 10*ans + rem;
            num /= 10;
        }
        return ans;
    }
}