class Solution {
    public int check(String s, char ch1, char ch2){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int cnt1=0;
        int cnt2 = 0;
        int maxLen = 1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=ch1 && s.charAt(i)!=ch2){
                cnt1=0;
                cnt2 = 0;
                map.clear();
                map.put(0,i);
                continue;
            }
            if(s.charAt(i)==ch1) cnt1++;
            if(s.charAt(i)==ch2) cnt2++;
            if(cnt1==cnt2){
                maxLen = Math.max(maxLen, cnt1+cnt2);
            }
            int diff = cnt1-cnt2;
            if(map.containsKey(diff)){
                maxLen = Math.max(maxLen, i-map.get(diff));
            }
            else{
                map.put(diff,i);
            }
        }
        return maxLen;
    }
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        int cnt = 1;
        //case 1 : aaaaaaa...
        for(int i=1; i<n; i++){
            if(s.charAt(i-1)==s.charAt(i)){
                cnt++;
            }
            else{
                maxLen = Math.max(maxLen, cnt);
                cnt=1;
            }
        }
        maxLen = Math.max(maxLen, cnt);

        //case 2 : aaabbb
        maxLen = Math.max(maxLen, check(s,'a','b'));
        maxLen = Math.max(maxLen, check(s,'b','c'));
        maxLen = Math.max(maxLen, check(s,'c','a'));

        //case 3: check all three alphabet;
        int cnta = 0;
        int cntb = 0;
        int cntc = 0;
        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("0#0", -1);

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='a') cnta++;
            if(s.charAt(i)=='b') cntb++;
            if(s.charAt(i)=='c') cntc++;

            if(cnta==cntb && cnta==cntc){
                maxLen = Math.max(maxLen, cnta+cntb+cntc);
            }
            int diffAB = cnta-cntb;
            int diffAC = cnta-cntc;
            String key = diffAB + "#" + diffAC;

            if(map1.containsKey(key)){
                maxLen = Math.max(maxLen,i-map1.get(key));
            }
            else{
                map1.put(key,i);
            }
        }
        return maxLen;
    }
}