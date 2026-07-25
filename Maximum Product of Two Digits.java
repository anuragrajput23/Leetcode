class Solution {
    public int maxProduct(int n) {
        int f = 0;
        int s = 0;
        while(n!=0){
            int digit = n%10;
            n = n/10;
            if(digit > f){
                s=f;;
                f = digit;
            }else if(s < digit){
                s=digit;
            }
        }
        return f*s;
    }
}