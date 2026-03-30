class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        int r=0,l=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        long maxi = 0;

        while(r<n){
            map.put(nums.get(r),map.getOrDefault(nums.get(r),0)+1);
            while((r-l+1)>k){
                int temp = nums.get(l);
                int freq = map.getOrDefault(temp,0);
                if(freq > 1){
                    map.put(temp,freq-1);
                }else{
                    map.remove(temp);
                }
                l++;
            }
            if(map.size() >= m && (r-l+1)==k){
               maxi = Math.max(maxi, sum(l,r,nums));
            }
            r++;
        }
        return maxi;
    }
    public long sum(int i, int j, List<Integer> nums){
        long summ = 0;
        for(int y=i; y<=j; y++){
            summ += (long)nums.get(y);
        }
        return summ;
    }
}