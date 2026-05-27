class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        char[] arr = word.toCharArray();
        int cnt =0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(Character.isUpperCase(arr[i])){
              map.putIfAbsent(arr[i], i);
            }else{
                map.put(arr[i],i);
            }
        }
        for(int i=0; i<n; i++){
            if(Character.isLowerCase(arr[i])){
                int lc = map.getOrDefault(arr[i],(int)1e9);
                if(map.containsKey(Character.toUpperCase(arr[i]))){
                    int cc = map.get(Character.toUpperCase(arr[i]));
                    if(lc < cc){
                        cnt++;
                    }
                    map.remove(Character.toUpperCase(arr[i]));
                    map.remove(Character.toLowerCase(arr[i]));
                }
            }
        }
        return cnt;
    }
}