class Solution {
    public int climbStairs(int n) {
        return solve(n);
    }
    public int solve(int n){
        if(n==0) return 1;
        if(n<0) return 0;
        int step1 = solve(n-1);
        int step2 = solve(n-2);
        return step1+step2;
    }
}