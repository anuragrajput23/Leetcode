public class Solution {
    public int minOperations(String s) {
        int a=solve(s,true);
        int b=solve(s,false);
        return Math.min(a,b);
    }
    public int solve(String s,boolean zero){
        int n = s.length();
        int op=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if((ch=='0' && !zero) || (ch=='1' && zero)){
                op++;
            }
            zero=!zero;
        }
        return op;
    }
} Minimum Changes To Make Alternating Binary String {
    
}
