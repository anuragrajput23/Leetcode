class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int cnt = 0;

        for(int j=0; j<n; j++){
            for(int i=0; i<m; i++){
                if(nums1[i]%(nums2[j]*k)==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}