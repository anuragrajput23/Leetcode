class Solution {
    public String reversePrefix(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        return solve(arr,k);
    }
    public String solve(char[] arr, int k){
        int i=0;
        int j=k-1;

        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] =temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}