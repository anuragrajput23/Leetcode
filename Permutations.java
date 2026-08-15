class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[n];
        solve(0,nums,freq,list,ans);
        return ans;
    }
    public void solve(int x, int[] nums, boolean[] freq, List<Integer> list, List<List<Integer>> ans){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(freq[i]==false){
                list.add(nums[i]);
                freq[i]=true;
                solve(x+1,nums,freq,list,ans);
                list.remove(list.size()-1);
                freq[i]=false;
            }
        }
    }
}

//space O(1)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(0,nums,ans);
        return ans;
    }
    public void solve(int idx, int[] nums, List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int ele : nums){
                list.add(ele);
            }
            ans.add(list);
            return;
        }
        for(int i=idx; i<nums.length; i++){
            swap(i,idx,nums);
            solve(idx+1,nums,ans);
            swap(i,idx,nums);
        }
    }
    public void swap(int i,int j, int[] nums){
        int temp= nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
}