// class Solution {
//     public int hammingWeight(int n) {
//         int cnt = 0;

//         while(n!=0){
//             cnt += n & 1;
//             n >>= 1;
//         }
//         return cnt;
//     }
// }

class Solution {
    public int hammingWeight(int n) {
        int cnt=0;
        for(int i=31; i>=0; i--){
            if(((n>>i) & 1) == 1){
                cnt++;
            }
        }
        return cnt;
    }
}