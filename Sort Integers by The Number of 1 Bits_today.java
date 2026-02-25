class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
       ArrayList<int[]> list = new ArrayList<>();
       for(int ele : arr){
        list.add(new int[]{ele,Integer.bitCount(ele)});
       }
       Collections.sort(list,(a,b)->{
        if(a[1]!=b[1]){
            return a[1]-b[1];
        }
        else{
            return a[0]-b[0];
        }
       });
       int[] ans = new int[n];
       for(int i=0; i<list.size();i++){
        ans[i] = list.get(i)[0];
       }
       return ans;

    }
}