class Solution {
    int mod = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int startWithOne = solve(zero, one, false, limit);
        int startWithZero = solve(zero, one, true, limit);
        return (startWithOne + startWithZero)%mod;
    }
    public int solve(int zero, int one, boolean check, int limit){
        if(zero==0 && one==0){
            return 1;
        }
        int result = 0;
        if(check==true){
            for(int len = 1; len <= Math.min(limit, zero); len++){
                result = (result + solve(zero-len, one, false,limit))%mod;
            }
        }else{
            for(int len = 1; len <= Math.min(limit, one); len++){
                result = (result + solve(zero,one-len,true,limit))%mod;
            }
        }
        return result;
    }
}