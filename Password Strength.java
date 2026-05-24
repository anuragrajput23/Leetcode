class Solution {
    public int passwordStrength(String password) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch) && !set.contains(ch)) {
                ans += 1;
                set.add(ch);
            } else if (Character.isUpperCase(ch) && !set.contains(ch)) {
                set.add(ch);
                ans += 2;
            } else if(Character.isDigit(ch) && !set.contains(ch)) {
                set.add(ch);
                ans += 3;
            }else if(!set.contains(ch)){
                set.add(ch);
                ans += 5;
            }
        }
        return ans;
    }
}