class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(A[i]==B[i]){
                count++;
                ans[i] = count;
            }
            else{
                if(!map.containsKey(A[i])){
                    map.put(A[i],1);
                }
                else{
                    count++;
                }
                if(!map.containsKey(B[i])){
                    map.put(B[i],1);
                }
                else{
                    count++;
                }
                ans[i]=count;
            }
        }
        return ans;
    }
}