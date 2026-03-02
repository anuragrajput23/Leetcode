class Solution {
    public int minPartitions(String n) {
        int maxi = -1;
        for(char ch : n.toCharArray()){
            maxi = Math.max(ch-'0', maxi);
        }
        return maxi;
    }
}