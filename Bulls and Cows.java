class Solution {
    public String getHint(String s, String g) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int bulls=0,cow=0;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            char ch2=g.charAt(i);
            if(ch==ch2){
                bulls++;
                int fre=map.get(ch);
                if(fre>1){
                    map.put(ch,fre-1);
                }else{
                    map.remove(ch);
                }
            }
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            char ch2=g.charAt(i);
            if(ch==ch2){
                continue;
            }
            if(map.containsKey(ch2) ){
                cow++;
                int fre=map.get(ch2);
                if(fre>1){
                    map.put(ch2,fre-1);
                }else{
                    map.remove(ch2);
                }
            }
        }
        return bulls+"A"+cow+"B";
    }
}

