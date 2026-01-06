// class Solution {
//     public String largestEven(String s) {
//         int n = s.length();
//         char[] arr = s.toCharArray();
//         int i=0;
//         long num = 0;
//         long maxi = Integer.MIN_VALUE;
//         while(i<n){
//             num = num*10 + arr[i]-'0';
//             if(num%2==0) maxi = Math.max(maxi, num);
//             i++;
//         }
//         if(maxi==Integer.MIN_VALUE) return "";
//         return maxi+"";

//     }
// }

// class Solution {
//     public String largestEven(String s) {
//         int n= s.length();
//         int id = -1;
//         for(int i=n-1; i>=0; i--){
//             int check = s.charAt(i)-'0';
//             if(check%2==0){
//                 id = i;
//                 break;
//             }
//         }
//         if(id==-1) return "";
//         return s.substring(0,id+1);
//     }
// }

class Solution {
    public String largestEven(String s) {
       StringBuilder sb = new StringBuilder(s);
       int n = sb.length();
       for(int i=n-1; i>=0; i--){
        if((sb.charAt(i)-'0') % 2==0){
            return sb.toString();
        }else{
            sb.deleteCharAt(i);
        }
       }
       return "";
    }
}