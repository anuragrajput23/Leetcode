class Solution {
    public int bitwiseComplement(int n) {
        int result = 0;
        int cnt = 0;
        if(n==0) return 1;
        while(n > 0){
            int rem = n%2;
            int flip = (rem==1 ? 0 : 1);
            result += Math.pow(2,cnt)*flip;
            cnt++;
            n = n/2;
        }
        return result;
    }
}