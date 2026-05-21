class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
         for (int num : arr1) {
            while (num != 0) {
                set.add(num);
                num /= 10;
            }
        }
        int ans = 0;
        for(int ele : arr2){
            int checked = prefixCheck(ele);
            ans = Math.max(ans,checked);
        }
        return ans;
    }
    public int prefixCheck(int num){
        int len = 0;
        while(num!=0){
            if(set.contains(num)){
                len = String.valueOf(num).length();
                break;
            }
            num = num/10;
        }
        return len;
    }
}