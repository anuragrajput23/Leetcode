class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++){
            count += findDigit2(nums[i],digit);
        }
        return count;
    }
    public int findDigit2(int num, int digit){
        int current = 0;
        while(num!=0){
            int rem = num%10;
            if(rem==digit) current++;
            num = num/10;
        }
        return current;
    }
}