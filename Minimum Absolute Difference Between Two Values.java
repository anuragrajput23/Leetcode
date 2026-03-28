// class Solution {
//     public int minAbsoluteDifference(int[] nums) {
//         int n = nums.length;
//         int mini = Integer.MAX_VALUE;
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 if((nums[i]==1 && nums[j]==2 || (nums[i]==2 && nums[j]==1))){
//                     mini = Math.min(mini, Math.abs(j-i));
//                 }
//             }
//         }
//         if(mini==Integer.MAX_VALUE) return -1;
//         return mini;
//     }
// }

//M2
class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int one = -1;
        int two = -1;
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                one = i;
                if(two!=-1){
                    mini = Math.min(Math.abs(one-two),mini);
                }
            }
            else if(nums[i]==2){
                two = i;
                if(one!=-1){
                    mini = Math.min(Math.abs(two-one),mini);
                }
            }
        }
        return mini==Integer.MAX_VALUE ? -1 : mini;
    }
}