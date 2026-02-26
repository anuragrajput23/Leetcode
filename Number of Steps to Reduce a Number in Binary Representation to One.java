// class Solution {
//     public int numSteps(String s) {
//         StringBuilder sb = new StringBuilder(s);
//         int n  = sb.length();
//         int oper = 0;
//         while(sb.length()>1){
//             if(sb.charAt(sb.length()-1)=='0'){
//                 sb.deleteCharAt(sb.length()-1);
//                 oper++;
//             }else{
//                 int i=sb.length()-1;
//                 while(i>=0 && sb.charAt(i)=='1'){
//                     sb.setCharAt(i,'0');
//                     i--;
//                 }
//                 if(i>=0){
//                     sb.setCharAt(i,'1');
//                 }else{
//                     sb.insert(0,'1');
//                 }
//                 oper++;
//             }
//         }
//         return oper;
//     }
// }

//O(n)
class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int op=0;
        int carry = 0;
        for(int i=n-1; i>=1; i--){
            if(((s.charAt(i)+'0') + carry)%2==1){
                carry=1;
                op += 2;
            }else{
                op++;
            }
        }
        return op+carry;
    }
}