class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int space = 0;
        int left = 0;
        int right=0;
        int distFromOrg = 0;
        for(char ch : moves.toCharArray()){
            if(ch=='L') left++;
            if(ch=='R') right++;
            if(ch=='_') space++;
        }
    if(left > right){
        return left-right+space;
    }else{
return right-left+space;
    }

    }
}