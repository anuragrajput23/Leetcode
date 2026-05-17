class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        return solve(start,n,arr);
    }
    public boolean solve(int i, int n, int[] arr){
        if(i>= n || i < 0) return false;
        if(arr[i]==0) return true;
        if(arr[i]<0) return false;
        int jump = arr[i];
        arr[i] *= -1;
        boolean a = solve(i+jump,n,arr);
        boolean b = solve(i-jump,n,arr);
        return a || b;
    }
}