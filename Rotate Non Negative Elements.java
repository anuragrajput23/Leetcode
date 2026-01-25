class Solution {
    public void rotate(List<Integer> list, int i, int j){
        // int n = list.size();
        while(i<=j){
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
    }
    public int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : nums){
            if(ele >= 0) list.add(ele);
        }
        if(list.size()== 0) return nums;
       k =k%list.size();
        rotate(list, 0, k - 1);
        rotate(list, k, list.size() - 1);
        rotate(list, 0, list.size() - 1);
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0) continue;
            else if(nums[i] >= 0) nums[i] = list.get(j++);

        }
        return nums;
    }
}