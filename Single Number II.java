class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int bit=0; bit<=31; bit++){
            int temp = 1<<bit;
            int one=0,zero=0;
            for(int num : nums){
                if((num & temp)==0){
                    zero++;
                }else{
                    one++;
                }
            }
            if(zero%3==1){
                continue;
            }else{
                ans = (ans | (temp));
            }
        }
        return ans;
    }
}