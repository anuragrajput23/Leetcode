class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            int next = to_check(i,nums1[i],n-1,nums2);
            if(next!=-1) maxi = Math.max(maxi, (next-i));
        }
        return maxi==Integer.MIN_VALUE ? 0 : maxi;
    }
    public int to_check(int l, int target, int r,int[] nums2){
        int idx = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums2[mid]>=target){
                idx=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return idx;
    }
}