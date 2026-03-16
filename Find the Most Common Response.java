class Solution {
    public String findCommonResponse(List<List<String>> res) {
        HashMap<String,Integer> map = new HashMap<>();
        int m = res.size();
        for(int i=0; i<m; i++){
            HashSet<String> set = new HashSet<>();
            List<String> l = res.get(i);
            for(int j=0; j<l.size(); j++){
                String str = l.get(j);
                if(!set.contains(str)){
                    map.put(str,map.getOrDefault(str,0)+1);
                }
                set.add(str);
            }
        }
        int maxStr = 0;
        for(String key : map.keySet()){
            maxStr = Math.max(maxStr, map.get(key));
        }
        List<String> lexi = new ArrayList<>();
        for(String s : map.keySet()){
            if(map.get(s)==maxStr){
                lexi.add(s);
            }
        }
        Collections.sort(lexi);
        return lexi.get(0);
    }
}
//optimised one
class Solution {
    public String findCommonResponse(List<List<String>> res) {
        HashMap<String,Integer> map = new HashMap<>();
        int m = res.size();
        for(int i=0; i<m; i++){
            HashSet<String> set = new HashSet<>();
            List<String> l = res.get(i);
            for(int j=0; j<l.size(); j++){
                String str = l.get(j);
                if(!set.contains(str)){
                    map.put(str,map.getOrDefault(str,0)+1);
                }
                set.add(str);
            }
        }
        int maxStr = 0;
        String str = "~";
        for(String key : map.keySet()){
            maxStr = Math.max(maxStr, map.get(key));
        }
        for(String s : map.keySet()){
            if(map.get(s)==maxStr && s.compareTo(str) < 0){
                str = s;
            }
        }
        return str;
    }
}