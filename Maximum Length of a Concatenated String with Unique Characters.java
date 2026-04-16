class Solution {
    public boolean hasDuplicate(String ans, String temp){
        char[] freq = new char[26];
        for(char ch : ans.toCharArray()){
            if(freq[ch-'a']>0) return true;
            freq[ch-'a']++;
        }
        for(char chh : temp.toCharArray()){
            if(freq[chh-'a']>0) return true;
            freq[chh-'a']++;
        }
        return false;
    }
    public int maxLength(List<String> arr) {
        String ans = "";
        int n = arr.size();
        return solve(arr,ans,0,n);
    }
    public int solve(List<String> list, String ans, int i, int n){
        if(i>=n) return ans.length();
        int take = 0;
        int ntake = 0;
        if(hasDuplicate(ans, list.get(i))){
            ntake = solve(list,ans,i+1,n);
        }else{
            take = solve(list,ans+list.get(i),i+1,n);
            ntake = solve(list,ans,i+1,n);
        }
        return Math.max(ntake,take);
    }
}