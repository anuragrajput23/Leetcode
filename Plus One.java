class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i= n-1;
        while(i >= 0){
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            else if(digits[i]==9){
                digits[i]=0;
                i--;
            }
        }
        int []ans = new int[n+1];
        ans[0] = 1;
        for(int j=1; j<ans.length; j++){
            ans[j] = digits[j-1];
        }
        return ans;
    }
}
