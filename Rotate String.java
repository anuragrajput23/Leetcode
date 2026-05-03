class Solution {
    public boolean rotateString(String s, String goal) {
        String str = s+s;
        if(s.length() == goal.length() && str.contains(goal)){
            return true;
        }
        return false;
    }
}