class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long result = 0;
        for(int i=1; i<=n; i++){
            int digit = (int)(Math.log(i)/Math.log(2))+1;
            result = ((result<<digit)%mod +i)%mod;
        }
        return (int)result;
    }
}