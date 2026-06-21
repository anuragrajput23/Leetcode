class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            String str = "";
            for(int j=i; j<n; j++){
                str += s.charAt(j);
                int beauty = check(str);
                ans += beauty;
            }
        }
        return ans;
    }
    public int check(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()) map.put(ch,map.getOrDefault(ch,0)+1);
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(char ch : map.keySet()){
            mini = Math.min(mini, map.get(ch));
            maxi = Math.max(maxi, map.get(ch));
        }
        return maxi-mini;
    }
}

class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxi = 0;
                int mini = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxi = Math.max(maxi, freq[k]);
                        mini = Math.min(mini, freq[k]);
                    }
                }

                ans += (maxi - mini);
            }
        }

        return ans;
    }
}