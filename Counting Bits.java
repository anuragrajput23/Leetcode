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
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<n+1; i++){
            ans[i] = solve(i);
        }
    return ans;
    }
    public int solve(int n){
        int count = 0;
        while(n!=0){
            count += (n & 1);
            n = n>>1;
        }
        return count;
    }
}