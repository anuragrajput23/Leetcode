class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int prev = 0;
        int cnt = 1;
        int ans = 0;
        for(int i=1; i<n; i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cnt++;
            }else{
                ans += Math.min(prev,cnt);
                prev = cnt;
                cnt = 1;
            }
        }
        ans += Math.min(cnt,prev);
        return ans;
    }
}