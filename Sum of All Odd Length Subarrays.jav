class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int allsum = 0;
        for(int i=1; i<=n; i += 2){
            allsum += allOddLengthSum(arr,i);
        }
        return allsum;
    }
    public int allOddLengthSum(int[] arr, int k){
        int r=0,l=0;
        int sum = 0;
        int allsum = 0;
        while(r < arr.length){
            sum += arr[r];
            while((r-l+1) > k){
                sum -= arr[l];
                l++;
            }
            if((r-l+1)==k){
                allsum += sum;
            }
            r++;
        }
        return allsum;
    }
}