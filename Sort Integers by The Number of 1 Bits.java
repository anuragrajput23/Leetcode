class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new int[]{arr[i],Integer.bitCount(arr[i])});
        }
        Collections.sort(list, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for(int i=0; i<n; i++){
            ans[i] = list.get(i)[0];
        }

        return ans;
    }
}