class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(words[i].equals(target)){
                int forward = Math.abs(i-startIndex);
                int backward = n-forward;
                ans= Math.min(ans,Math.min(forward,backward));
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}