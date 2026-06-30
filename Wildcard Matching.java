class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        return solve(n-1,m-1,p,s);
    }
    public boolean solve(int i, int j, String s1, String s2){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int k=0; k<=i; k++){
                if(s1.charAt(k)!='*') return false;
            }
            return true;
        }
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
            return solve(i-1,j-1,s1,s2);
        }
        if(s1.charAt(i)=='*'){
            return solve(i-1,j,s1,s2) || solve(i,j-1,s1,s2);
        }else{
            return false;
        }

    }
}