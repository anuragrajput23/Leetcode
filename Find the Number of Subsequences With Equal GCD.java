public class Solution {
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        return solve(0,0,0,nums);
    }
    public int gcd(int x, int y) {
    while (y != 0) {
        int temp = y;
        y = x % y;
        x = temp;
    }
    return x;
}
    public int solve(int i, int first, int second, int[] nums){
        int mod = 1000000007;
        if(i==nums.length){
            boolean lastSame = (first!=0 && second!=0);
            boolean lastGcd = first==second;
            return (lastSame == true && lastGcd==true) ? 1 : 0;
        }
        int ntake = solve(i+1,first,second,nums);
        int take1 = solve(i+1,gcd(first,nums[i]), second,nums);
        int take2 = solve(i+1,first,gcd(second,nums[i]),nums);
        return (ntake+take1+take2)%mod;
    }
}
