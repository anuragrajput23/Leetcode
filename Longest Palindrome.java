class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        int ans = 0;
        boolean oddFre = false;
        for(char c : map.keySet()){
            int fre = map.get(c);
            if(fre%2==0){
                ans += fre;
            }else{
                ans += fre-1;
                oddFre=true;
            }
        }
        if(oddFre) return ans +1;
        return ans;
    }
}