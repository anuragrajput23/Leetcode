class Solution {
    public boolean judgeCircle(String moves) {
       int n = moves.length();
       int cntL = 0, cntR=0, cntU=0, cntD=0;
       for(char ch : moves.toCharArray()){
        if(ch=='L') cntL++;
        if(ch=='R') cntR++;
        if(ch=='U') cntU++;
        if(ch=='D') cntD++;
       }
       return cntL==cntR && cntU==cntD;
    }
}