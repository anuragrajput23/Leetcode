class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0; i<n; i++){
            HashMap<Character,Integer> freqMap = new HashMap<>();
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
                 Set<Integer> set = new HashSet<>();

                for(char c : freqMap.keySet()){
                    int freq = freqMap.get(c);
                    set.add(freq);
                }
                if(set.size()==1){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
}