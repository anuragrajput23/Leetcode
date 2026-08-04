class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return (nums[n-1]-1) * (nums[n-2]-1);
    }
}


class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pqmin = new PriorityQueue<>();
        for(int ele : nums){
            pqmin.offer(ele);
            while(pqmin.size()>2){
                pqmin.remove();
            }
        }
        return (pqmin.poll()-1) * (pqmin.poll()-1);
    }
}