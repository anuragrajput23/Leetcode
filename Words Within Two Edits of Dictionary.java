class Solution {
    public List<String> twoEditWords(String[] que, String[] dict) {
        List<String> ans = new ArrayList<>();
        int m = que.length;
        int n = dict.length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
            int diff = 0;
                for(int l=0; l<que[0].length(); l++){
                    if(que[i].charAt(l)!=dict[j].charAt(l)){
                        diff++;
                    }
                }
                if(diff <= 2){
                    ans.add(que[i]);
                    diff=0;
                    break;
                }
            }
        }
        return ans;
    }
}