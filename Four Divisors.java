class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += solve(nums[i]);
        }
        return ans;
    }
    public int solve(int m){
        int cnt = 0;
        int sum=0;
        for(int fact = 1; fact<=Math.sqrt(m); fact++){
            if(m%fact==0){
                if(fact==m/fact){
                    sum += fact;
                    cnt += 1;
                }else{
                    sum += fact;
                    sum += m/fact;
                    cnt += 2;
                }
            }
            if(cnt > 4){
                break;
            }
        }
        if(cnt==4) return sum;
        return 0;
    }
}
