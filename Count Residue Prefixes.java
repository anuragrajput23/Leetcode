class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        int ans = 0;
        for(char ch : s.toCharArray()){
            set.add(ch);
            len++;
            if(set.size()==len%3) ans++;
        }
        return ans;
    }
}
