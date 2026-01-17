class Solution {
    public String removeKdigits(String s, int k) {
        int n = s.length();
        if(n==k) return "0";
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && k>0 && st.peek()>arr[i]-'0'){
                st.pop();
                k--;
            }
            st.push(arr[i]-'0');
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        int idx = 0;
        while(idx<sb.length() && sb.charAt(idx)-'0' == 0 ){
            idx++;
        }
        if(idx==sb.length()) return "0";
        sb = new StringBuilder(sb.substring(idx));
        return sb.toString();
    }
}