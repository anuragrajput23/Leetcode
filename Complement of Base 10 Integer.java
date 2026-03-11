class Solution {
    public int bitwiseComplement(int n) {
        int result = 0;
        int cnt = 0;
        if(n==0) return 1;
        while(n > 0){
            int rem = n%2;
            int flip = (rem==1 ? 0 : 1);
            result += Math.pow(2,cnt)*flip;
            cnt++;
            n = n/2;
        }
        return result;
    }
}

//M2
// class Solution {
//     public int bitwiseComplement(int n) {
//         int mask = 1;
//         while(mask < n){
//             mask = (mask << 1) | 1;
//         }
//         return mask^n;
//     }
// }

//M3
class Solution {
    public int bitwiseComplement(int n) {
        // int mask = 1;
        // while(mask < n){
        //     mask = (mask << 1) | 1;
        // }
        int k = (int)(Math.log(n)/Math.log(2))+1;
        int mask = (1 << k)-1;
        return mask^n;
    }
}