class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] result = new int[2051];
        int m = logs.length;
        for(int i=0; i<m; i++){
            int b = logs[i][0];
            int d = logs[i][1];

            result[b] += 1;
            result[d] -= 1;
        }
        int years = -1;
        int maxPopu = -1;
        int currPopu = -1;
        for(int i=1950; i<2050; i++){
            result[i] +=(i-1 >= 1950) ? result[i-1] : 0;
            if(result[i] > maxPopu){
                currPopu = result[i];
                maxPopu = currPopu;
                years = i;
            }
        }
        return years;
    }
}