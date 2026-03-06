class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int cnt = 0;
        int i=0;
        while(i<n){
            if(s.charAt(i)=='1'){
                cnt++;
                if(cnt>1) return false;
                while(i<n && s.charAt(i)=='1'){
                    i++;
                }
            }
            i++;
        }
        return true;
    }
}