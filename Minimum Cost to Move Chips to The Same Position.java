class Solution {
    public int minCostToMoveChips(int[] position) {
        int n = position.length;
        int o=0;
        int e=0;

        for(int chips : position){
            if(chips%2==0) e++;
            else o++;
        }
        return Math.min(e,o);
    }
}