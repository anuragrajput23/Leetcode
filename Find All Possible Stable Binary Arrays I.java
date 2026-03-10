// class Solution {
//     int mod = 1000000007;
//     public int numberOfStableArrays(int zero, int one, int limit) {
//         int startWithOne = solve(zero, one, false, limit);
//         int startWithZero = solve(zero, one, true, limit);
//         return (startWithOne + startWithZero)%mod;
//     }
//     public int solve(int zero, int one, boolean check, int limit){
//         if(zero==0 && one==0){
//             return 1;
//         }
//         int result = 0;
//         if(check==true){
//             for(int len = 1; len <= Math.min(limit, zero); len++){
//                 result = (result + solve(zero-len, one, false,limit))%mod;
//             }
//         }else{
//             for(int len = 1; len <= Math.min(limit, one); len++){
//                 result = (result + solve(zero,one-len,true,limit))%mod;
//             }
//         }
//         return result;
//     }
// }

//more optimised
class Solution {
    int mod = 1000000007;
    int[][][] dp = new int[201][201][2];
    public int numberOfStableArrays(int zero, int one, int limit) {
        for(int z=0; z<201; z++){
            for(int o=0; o<201; o++){
                for(int c=0; c<2; c++){
                    dp[z][o][c] = -1;
                }
            }
        }
        int startWithOne = solve(zero, one, false, limit);
        int startWithZero = solve(zero, one, true, limit);

        return (startWithOne + startWithZero)%mod;
    }
    public int solve(int zero, int one, boolean check, int limit){

        if(zero==0 && one==0){
            return 1;
        }
         int c = check==true ? 1 : 0;
        if(dp[zero][one][c]!=-1) return dp[zero][one][c];
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
        return dp[zero][one][c] =result;
    }
}