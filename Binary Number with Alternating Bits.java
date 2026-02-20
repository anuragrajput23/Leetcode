// class Solution {
//     public boolean hasAlternatingBits(int n) {
//         StringBuilder sb = new StringBuilder();
//         while(n > 0){
//             sb.append(n%2);
//             n = n/2;
//         }
//         for(int i=1; i<sb.length(); i++){
//             if(sb.charAt(i-1)==sb.charAt(i)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }

//without using space
class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n==0) return true;
        int curr = n%2;
        n = n/2;
        while(n > 0){
            int temp = n%2;
            if(curr==temp) return false;
            curr = temp;
            n = n/2;
        }
        return true;
    }
}
