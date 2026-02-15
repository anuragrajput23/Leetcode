class Solution {
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;

        StringBuilder sb = new StringBuilder();
        int sum  =0;
        int carry = 0;
        while(m >= 0 || n >= 0){
            sum = carry;
            // sum += a.charAt(m)-'0' + b.charAt(n)-'0';
            if(m >= 0){
                sum += a.charAt(m)-'0';
                m--;
            }
            if(n >= 0){
                sum += b.charAt(n)-'0';
                n--;
            }
            sb.append((sum%2==0) ? 0 : 1);
            carry = (sum > 1) ? 1 : 0;
        }
        if(carry>0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}