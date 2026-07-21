class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;
        int cnt1=0;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++; j--;
            }else{
                i++;
                cnt1++;
            }
        }
       i=0;
       j=n-1;
       int cnt2 = 0;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++; j--;
            }else{
                j--;
                cnt2++;
            }
        }
        if(cnt1<=1 || cnt2 <= 1) return true;
        return false;
    }
}