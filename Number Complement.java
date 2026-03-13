class Solution {
    public int findComplement(int num) {
        int result = 0;
        int cnt = 0;
        while(num > 0){
            int rem=num%2;
            int flip = rem==0 ? 1 : 0;
            result = result + (1<<cnt)*flip;
            cnt++;
            num = num/2;
        }
        return result;
    }
}