class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int l=0;
        int r=0;
        int maxiSum  = 0;
        int miniLen = Integer.MAX_VALUE;

        while(r < n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map.get(nums[r])==1) maxiSum += nums[r];
            while(maxiSum >= k){
                miniLen = Math.min((r-l+1), miniLen);
                int freq = map.get(nums[l]);
                if(freq == 1){
                    map.remove(nums[l]);
                    maxiSum -= nums[l];
                }else{
                    map.put(nums[l],freq-1);
                }
                l++;
            }
            r++;
        }
        if(miniLen == Integer.MAX_VALUE) return -1;
        return miniLen;
    }
}
