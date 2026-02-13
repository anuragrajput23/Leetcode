// class Solution {
//     public int[] countBits(int n) {
//         int[] ans = new int[n+1];
//         for(int i=0; i<n+1; i++){
//             ans[i] = Integer.bitCount(i);
//         }
//     return ans;
//     }
// }

//without using built-in..
// class Solution {
//     public int[] countBits(int n) {
//         int[] ans = new int[n+1];
//         for(int i=0; i<n+1; i++){
//             ans[i] = solve(i);
//         }
//     return ans;
//     }
//     public int solve(int n){
//         int count = 0;
//         while(n!=0){
//             count += (n & 1);
//             n = n>>1;
//         }
//         return count;
//     }
// }

//dynamic type
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        if(n==0) return ans;
        for(int i=1; i<n+1; i++){
            if(i%2==0) ans[i]= ans[i/2];
            else ans[i] = ans[i/2]+1;
        }
    return ans;
    }
}