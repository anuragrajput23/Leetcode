class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<=n-k; i++){
            set.add(s.substring(i,i+k));
        }
        solve("",k,list);
        return list.size()==set.size();
    }
    public void solve(String str, int k, List<String> list){
        if(str.length()==k){
            list.add(str);
            return;
        }
        solve(str+"0",k,list);
        solve(str+"1",k,list);
    }
}