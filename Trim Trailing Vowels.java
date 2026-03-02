class Solution {
    public String trimTrailingVowels(String s) {
        int n = s.length();
        int cnt = 0;
        for(int i=n-1; i>=0; i--){
            if("aeiou".contains(s.charAt(i)+"")){
                cnt++;
            }
            else{
                return s.substring(0,n-cnt);
            }
        }
        return "";
    }
}