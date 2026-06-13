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

//O(nlogn)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int ans = 0;
        Arrays.sort(nums);
        int lastElem = Integer.MIN_VALUE;
        int maxiLen = 1;
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(nums[i]-1==lastElem){
                cnt++;
                lastElem = nums[i];
            }else if(nums[i] != lastElem){
                cnt = 1;
                lastElem = nums[i];
            }
            maxiLen = Math.max(maxiLen, cnt);
        }
        return maxiLen;
    }
}

//O(n) O(N) space
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int maxiLen = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        for(int it : set){
            if(!set.contains(it-1)){
                int cnt = 1;
                int x = it;
                while(set.contains(x+1)){
                    x = x+1;
                    cnt = cnt+1;
                }
                maxiLen = Math.max(maxiLen, cnt);
            }
        }
        return maxiLen;
    }
}