class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = arr.clone();
        Arrays.sort(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank =1;
        for(int i=0; i<n; i++){
            if(!map.containsKey(arr[i])) map.put(arr[i],rank++);
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int index = map.get(temp[i]);
            ans[i]=index;
        }
        return ans;
    }
}