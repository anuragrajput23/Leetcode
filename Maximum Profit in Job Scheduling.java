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

//optimized solution using binary search
class Solution {
    int[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<int[]> list = new ArrayList<>();
        dp = new int[startTime.length];
        Arrays.fill(dp,-1);
        for(int i=0; i<profit.length; i++){
            list.add(new int[]{startTime[i],endTime[i],profit[i]});
        }
        Collections.sort(list, (a,b) -> a[0]-b[0]);
        return solve(list,0);
    }
    public int binarySearch(List<int[]> list, int l, int target){
        int r=list.size()-1;
        int result = list.size();
        while(l<=r){
            int mid = l+(r-l)/2;
            if(list.get(mid)[0]>=target){
                result = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return result;
    }
    public int solve(List<int[]> list, int i){
        if(i>=list.size()) return 0;
        if(dp[i]!=-1) return dp[i];
        int take = 0;
        int ntake = 0;
            int next = binarySearch(list, i+1, list.get(i)[1]);
            take = list.get(i)[2]+solve(list,next);
        ntake = solve(list,i+1);
        return dp[i]= Math.max(ntake,take);
    }
}