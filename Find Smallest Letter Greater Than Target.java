class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        int n = arr.length;
        int r=0;
        int l=n-1;
        char ans = arr[0];

        while(r<=l){
            int mid = l+(r-l)/2;
            if((arr[mid]-'0') > (target-'0')){
                ans = arr[mid];
                l=mid-1;
            }
            else{
                r=mid+1;
            }
        }

        return ans;
    }
}