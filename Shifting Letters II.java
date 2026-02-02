class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int m = shifts.length;
        int n = s.length();
        int[] pf = new int[n];
        // populating prefsum cal
        for(int i=0; i<m; i++){
            int left = shifts[i][0];
            int right = shifts[i][1];
            int check = shifts[i][2];

            if(check==0){
                pf[left] += -1;
                if(right+1 <= n-1) pf[right+1] += 1;
            }
            else{
                pf[left] += 1;
                if(right+1 <= n-1) pf[right+1] += -1;
            }
        }
        //calculating its prefSum
        for(int i=1; i<n; i++){
            pf[i] += pf[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int shifting = ((s.charAt(i)-'a') + (pf[i]+26))%26;
            if(shifting < 0) shifting += 26;
            sb.append((char)(shifting+'a'));
        }
        return sb.toString();
    }
} 