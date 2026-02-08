// class Solution {
//     public int minimumDeletions(String s) {
//         int n = s.length();
//         Stack<Character> st = new Stack<>();
//         int cnt = 0;
//         for(char ch : s.toCharArray()){
//             if(!st.isEmpty() && ch=='a' && st.peek()=='b'){
//                 st.pop();
//                 cnt++;
//             }else{
//                 st.push(ch);
//             }
//         }
//         return cnt;
//     }
// }
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] pfb = new int[n];
        int[] sfa = new int[n];

        int freq=0;
        for(int i=0; i<n; i++){
            pfb[i] = freq;
            if(s.charAt(i)=='b') freq++;
        }
        freq = 0;
        for(int i=n-1; i>=0; i--){
            sfa[i] = freq;
            if(s.charAt(i)=='a') freq++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.min(ans, pfb[i]+sfa[i]);
        }
        return ans;
    }
}