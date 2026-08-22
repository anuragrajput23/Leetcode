class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        solve(0, s, list, ans);
        return ans;
    }

    public void solve(int i, String s, List<String> list, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int idx = i; idx < s.length(); idx++) {
            if (isPalindrome(s, i, idx)) {
                // Add the current palindrome substring
                list.add(s.substring(i, idx + 1));

                // Recurse for the remaining string
                solve(idx + 1, s, list, ans);

                // Backtrack
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int st, int end) {
        while (st < end) {
            if (s.charAt(st) != s.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }

        return true;
    }
}