class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt=0;
        for(int i=left; i<=right; i++){
            int cntBit = Integer.bitCount(i);
            if(checkPrime(cntBit)){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean checkPrime(int num){
        if(num < 2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}