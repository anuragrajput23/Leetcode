class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && ch=='a' && st.peek()=='b'){
                st.pop();
                cnt++;
            }else{
                st.push(ch);
            }
        }
        return cnt;
    }
}