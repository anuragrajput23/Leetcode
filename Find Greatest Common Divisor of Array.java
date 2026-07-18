class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int maxi=Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int ele : nums){
            maxi = Math.max(ele,maxi);
            mini = Math.min(ele,mini);
        }
        return gcd(mini,maxi);
    }
    public int gcd(int x, int y){
        while(y!=0){
            int temp = x%y;
            x=y;
            y=temp;

        }
        return x;
    }
}