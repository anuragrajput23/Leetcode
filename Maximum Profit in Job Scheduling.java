class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<profit.length; i++){
            list.add(new int[]{startTime[i],endTime[i],profit[i]});
        }
        Collections.sort(list, (a,b) -> a[0]-b[0]);
        return solve(list,0,list.get(0)[0]);
    }
    public int solve(List<int[]> list, int i, int temp){
        if(i>=list.size()) return 0;
        int take = 0;
        int ntake = 0;
        if(list.get(i)[0] >= temp){
            take = list.get(i)[2]+solve(list,i+1,list.get(i)[1]);
        }
            ntake = solve(list,i+1,temp);

        return Math.max(ntake,take);

    }
}