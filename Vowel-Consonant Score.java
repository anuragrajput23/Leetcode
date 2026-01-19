class Solution {
    public int vowelConsonantScore(String s) {
        int constt = 0;
        int vowel = 0;
        for(char ch : s.toCharArray()){
            if(s.contains(ch+"")){
                if("aeiou".contains(ch+"")){
                    vowel++;
                }
                if("bcdfghjklmnpqrstvwxyz".contains(ch+"")){
                    constt++;
                }
            }
        }
        if(constt>0){
            return (int)Math.floor((vowel)/constt);
        }
        return 0;
    }
}