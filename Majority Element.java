class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int elem=nums[0];
        int freq = 1;
        for(int i=1; i<n; i++){
            if(elem==nums[i]){
                freq++;
            }
            else if(elem!=nums[i] && freq>0){
                freq--;
            }else{
                elem = nums[i];
            }
        }
        return elem;
    }
}