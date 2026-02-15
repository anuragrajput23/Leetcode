class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        HashMap<Integer,Integer> mapCount = new HashMap<>();
        for(int el : map.keySet()){
            int freq = map.get(el);
            mapCount.put(freq, mapCount.getOrDefault(freq,0)+1);
        }
        for(int i=0; i<n; i++){
            int freq = map.get(nums[i]);
            if(mapCount.get(freq)==1){
                return nums[i];
            }
        }
        return -1;
    }
}