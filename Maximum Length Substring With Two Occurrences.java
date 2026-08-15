class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int i=0,j=0;
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(i<n){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(s.charAt(i))>2){
                int freq = map.get(s.charAt(j));
                if(freq > 1){
                    map.put(s.charAt(j),freq-1);
                }else{
                    map.remove(s.charAt(j));
                }
                j++;
            }
            ans = Math.max(ans,(i-j+1));
            i++;
        }
        return ans;
    }
}