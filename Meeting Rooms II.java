class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<start.length; i++){
            list.add(new int[]{start[i],1});
        }
        for(int i=0; i<end.length; i++){
            list.add(new int[]{end[i],-1});
        }
         Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int maxOverLap = 0;
        int overlap = 0;
        for(int[] row : list){
            // int[] temp = row;
            overlap += row[1];
            maxOverLap = Math.max(overlap, maxOverLap);
        }
        return maxOverLap;
    }
}
