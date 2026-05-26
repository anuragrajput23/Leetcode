class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        HashSet<Character> set = new HashSet<>();
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                set.add(ch);
            }
        }
        int cnt = 0;
        for(char ch : word.toCharArray()){
            if(Character.isLowerCase(ch)){
                if(set.contains(Character.toUpperCase(ch))){
                    cnt++;
                    set.remove(Character.toUpperCase(ch));
            }
            }
        }
        return cnt;

    }
}