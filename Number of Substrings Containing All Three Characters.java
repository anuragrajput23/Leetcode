class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0,r=0;
        while(r<n){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                ans += n-r;
                int freq = map.get(s.charAt(l));
                if(freq > 1) map.put(s.charAt(l),freq-1);
                else map.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return ans;
    }
}