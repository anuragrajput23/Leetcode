class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String ss = s+s;
        // String s1,s2;
        char[] s1 = new char[2*n];
        char[] s2 = new char[2*n];

        for(int i=0; i<2*n; i++){
            if(i%2!=0){
                s1[i]='1';
                s2[i]='0';

            }else{
                s2[i] = '1';
                s1[i] ='0';
            }
        }
        int ans = Integer.MAX_VALUE;
        int flip1=0;
        int flip2 = 0;
        int i=0;
        int j=0;
        while(i<2*n){
            if(ss.charAt(i)!=s1[i]){
                flip1++;
            }
            if(ss.charAt(i)!=s2[i]){
                flip2++;
            }
            if((i-j+1)>n){
                if(ss.charAt(j)!=s1[j]){
                    flip1--;
                }
                if(ss.charAt(j)!=s2[j]){
                    flip2--;
                }
                j++;
            }
 if(i - j + 1 == n){
                ans = Math.min(ans, Math.min(flip1, flip2));
            }            i++;

        }
        return ans;
    }
}