class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new int[]{trips[i][1],trips[i][0]});
            list.add(new int[]{trips[i][2],-1*trips[i][0]});
        }
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int currCap = 0;
        for(int[] row : list){
            currCap += row[1];
            if(currCap > capacity) return false;
        }
        return true;
    }
}