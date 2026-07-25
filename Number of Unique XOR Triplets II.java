
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(2048);
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int ans = nums[i] ^ nums[j];
                // if(!set.contains(ans)) set.add(ans);
                set.add(ans);
            }
        }
        Set<Integer> set1 = new HashSet<>(2048);
        int cnt = 0;
        for(int pair : set){
            for(int i=0; i<n; i++)
            set1.add(pair ^ nums[i]);
        }
        return set1.size();
    }
}