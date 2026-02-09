// class Solution {
//     public int maximumPopulation(int[][] logs) {
//         int[] result = new int[2051];
//         int m = logs.length;
//         for(int i=0; i<m; i++){
//             int b = logs[i][0];
//             int d = logs[i][1];

//             result[b] += 1;
//             result[d] -= 1;
//         }
//         int years = -1;
//         int maxPopu = -1;
//         int currPopu = -1;
//         for(int i=1950; i<2050; i++){
//             result[i] +=(i-1 >= 1950) ? result[i-1] : 0;
//             if(result[i] > maxPopu){
//                 currPopu = result[i];
//                 maxPopu = currPopu;
//                 years = i;
//             }
//         }
//         return years;
//     }
// }

class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] log : logs){
            list.add(new int[]{log[0],1});
            list.add(new int[]{log[1],-1});
        }
        // Collections.sort(list, (a, b)-> a[0] - b[0]);
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];   // ✅ FIX: -1 (death) before +1 (birth)
        });

        int maxYear = -1;
        int maxPopu = 0;
        int currPopu = 0;
        for(int[] l : list){
            int[] temp = l;
            currPopu += temp[1];

            if(currPopu > maxPopu){
                maxPopu = currPopu;
                maxYear = temp[0];
            }
        }
        return maxYear;
    }
}