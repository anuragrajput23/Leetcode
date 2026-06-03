class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int ele : nums){
            if(ele==0) cnt0++;
            else if(ele==1) cnt1++;
            else cnt2++;
        }
        int i=0;
        while(cnt0-- > 0){
            nums[i++]=0;
        }
        while(cnt1-- > 0){
            nums[i++]=1;
        }
        while(cnt2-- > 0){
            nums[i++]=2;
        }
    }
}

//Duth Flag Algorithm  //O(N)
class Solution {
    public void swap(int i, int j,int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int mid = 0;
        int hi = n-1;
        while(mid <= hi){
            if(nums[mid]==0){
                swap(lo,mid,nums);
                lo++; mid++;
            }
            else if(nums[mid]==1) mid++;
            else if(nums[mid]==2){ swap(mid,hi,nums); hi--;}
        }
    }
}