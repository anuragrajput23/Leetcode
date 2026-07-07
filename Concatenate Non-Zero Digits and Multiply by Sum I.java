public class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        int num = 0;
        int sum  =0;
        while(n>0){
            int rem = n%10;
            if(rem > 0) num = num*10+rem;
            sum += rem;
            n /= 10;
        }
        while(num >0){
            int rem = num%10;
            ans = ans*10+rem;
            num /= 10;
        }
        return (long)ans*sum;
    }
}
