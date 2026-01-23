class Solution {

    public boolean isSorted(List<Integer> list){
        for(int i=1; i<list.size(); i++){
            if(list.get(i) < list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public int minSum(List<Integer> list){
        int index = -1;
    int minSum = Integer.MAX_VALUE;
        // int sum = 0;
        for(int i=1; i<list.size(); i++){
            int sum = list.get(i-1) + list.get(i);
            if(sum < minSum){
                minSum = sum;
                index=i;
            }
        }
        return index;
    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int oper = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : nums) list.add(ele);
        while(!isSorted(list)){
            int idx = minSum(list);
            int add = list.get(idx) + list.get(idx-1);
            list.set(idx-1, add);
            list.remove(idx);
            oper++;

        }
        return oper;
    }
}