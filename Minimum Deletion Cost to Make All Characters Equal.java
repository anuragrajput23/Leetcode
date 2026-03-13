class Solution {
    public long minCost(String s, int[] cost) {
        int n = cost.length;
        HashMap<Character, Long> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),(long)map.get(s.charAt(i))+cost[i]);
            }else{
                map.put(s.charAt(i),(long)cost[i]);
            }
        }
        if(map.size()==1) return 0;
        long tt = 0;
        long maxChar = -1;
        for(char chh : map.keySet()){
            long charCost = (long)map.get(chh);
            maxChar = Math.max(maxChar, charCost);
            tt += charCost;
        }
        return tt-maxChar;
    }
}