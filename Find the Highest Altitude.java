class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int maxHeight = 0;
        int currHeight = 0;
        for(int i=0; i<n; i++){
            currHeight = gain[i]+currHeight;
            maxHeight = Math.max(maxHeight,currHeight);
        }
        return maxHeight;
    }
}