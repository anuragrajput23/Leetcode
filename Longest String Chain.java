class Solution {
    public boolean checkPredecessor(String s1, String s2){
        if(s1.length() != s2.length()+1) return false;
        int i=0,j=0;
        while(i < s1.length()){
            if(j< s2.length() && s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        if(i==s1.length() && j==s2.length()) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];
        int maxChain = 1;
        Arrays.fill(dp,1);
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(checkPredecessor(words[i],words[j])){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxChain = Math.max(dp[i],maxChain);
                }
            }
        }
        return maxChain;
    }
}