class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int freq = n/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(int key : map.keySet()){
            int f = map.get(key);
            if(f==freq){
                return key;
            }
        }
        return -1;
    }
}