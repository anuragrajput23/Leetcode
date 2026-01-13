class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int[] ans = new int[2];

        for(int i=1; i<=nums.length; i++){
            int freq = map.getOrDefault(i,0);
            if(freq == 2){
                ans[0] = i;
            }else if(freq==0){
                ans[1] = i;
            }
        }
        return  ans;
    }
}