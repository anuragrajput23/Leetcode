class Solution {
      public int totalWaviness(int num1, int num2) {
        int cnt = 0;
        for(int j=num1; j<=num2; j++){
            String str = j+"";
            for(int i=1; i<str.length()-1; i++){
                int a = str.charAt(i-1)-'0';
                int b = str.charAt(i)-'0';
                int c = str.charAt(i+1)-'0';
                if((a < b && b > c) || (a > b && c > b)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}