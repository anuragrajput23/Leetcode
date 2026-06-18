class Solution {
    public boolean checkGoodInteger(int n) {
        int sqsum = 0;
        int dgsum = 0;
        while(n!=0){
            int digit = n%10;
            dgsum += digit;
            sqsum += digit*digit;
            n /= 10;
        }
        return (sqsum-dgsum >= 50);
    }
}