class Solution {
    public int binaryGap(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%2);
            n=n/2;
        }
       int maxLen = 0;
       int size = sb.length();
       for(int i=0; i<size; i++){
        for(int j=i+1; j<size; j++){
            if(sb.charAt(j)=='1' && sb.charAt(i)=='1'){
                maxLen = Math.max(maxLen, j-i);
                break;
            }
        }
       }
       return maxLen;
    }
}