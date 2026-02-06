class Solution {
    public int maxFrequency(int[] nums, int k, int oper) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int ele : nums) maxi = Math.max(ele,maxi);
        int[] pf = new int[maxi+k+2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            int l = Math.max(nums[i]-k,0);
            int r = Math.min(nums[i]+k, maxi+k);

            pf[l] += 1;
            if((r+1) <= maxi+1) pf[r+1] -= 1;

        }
        int result = 1;
        for(int i=1; i<maxi+k+2; i++){
            pf[i] += pf[i-1];
            int targetFreq = map.getOrDefault(i,0);
            int needToConvert = pf[i] - targetFreq;
            int maxPossibleFreq = Math.min(needToConvert, oper);
            result = Math.max(result, targetFreq+ maxPossibleFreq);
        }
        return result;
    }
}