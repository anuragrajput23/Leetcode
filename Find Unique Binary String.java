class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(nums[i], 2));
        }
        for(int i = 0; i <= n; i++){
            if(!set.contains(i)){
                String ans = Integer.toBinaryString(i);
                while(ans.length() < n){
                    ans = "0" + ans;
                }
                return ans;
            }
        }
        return "";
    }
}
