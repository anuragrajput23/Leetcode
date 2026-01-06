class Solution {
    public String largestEven(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i=0;
        long num = 0;
        long maxi = Integer.MIN_VALUE;
        while(i<n){
            num = num*10 + arr[i]-'0';
            if(num%2==0) maxi = Math.max(maxi, num);
            i++;
        }
        if(maxi==Integer.MIN_VALUE) return "";
        return maxi+"";

    }
}