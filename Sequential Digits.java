class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for(int i=low; i<=high; i++){
            if(check(i)==true){
                list.add(i);
            }
        }
        return list;
    }
    public boolean check(int num){
        String str = num + "";
        for(int i=1; i<str.length(); i++){
            if((str.charAt(i-1)-'0')+1 != str.charAt(i)-'0'){
                return false;
            }
        }
        return true;
    }
}