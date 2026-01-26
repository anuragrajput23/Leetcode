class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans= new ArrayList<>();
        int check_mini = Integer.MAX_VALUE;
        for(int i=1;i<n; i++){
            check_mini = Math.min(Math.abs(arr[i]-arr[i-1]),check_mini);
        }
        for(int i=1; i<n; i++){
        List<Integer> list = new ArrayList<>();
            if(Math.abs(arr[i-1]-arr[i])==check_mini){
                list.add(arr[i-1]);
                list.add(arr[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}