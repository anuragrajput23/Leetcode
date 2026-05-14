class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int target = n-1;
        int sum= (n-1)*(n)/2+n-1;
        int sumArray = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int ele : nums){
            sumArray += ele;
            if(ele>target) return false;
            map.put(ele,map.getOrDefault(ele,0)+1);
            if(map.get(ele)>1){
                cnt++;
                if(cnt>=2) return false;
            }
        }
        if(sumArray==sum) return true;
        return false;
    }
}