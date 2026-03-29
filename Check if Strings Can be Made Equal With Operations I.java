class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for(int i=0; i<m; i++){
            if(arr1[i]==arr2[i]){
                continue;
            }else{
                if(i+2<arr1.length && arr1[i+2]==arr2[i]){
                    reverse_position(arr1, i);
                }else{
                    return false;
                }
            }
        }
        return String.valueOf(arr1).equals(String.valueOf(arr2));

    }
    public void reverse_position(char[] arr1, int i){
        char temp = arr1[i];
        arr1[i] = arr1[i+2];
        arr1[i+2] = temp;
    }
}