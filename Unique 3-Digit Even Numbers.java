class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        HashSet<Integer> set = new HashSet<>();
        int ans;
        for(int i=0; i<n; i++){
            ans=0;
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(i==j || j==k || i==k || digits[k]%2==1 || digits[i]==0) continue;
                    ans = digits[i]*100 + digits[j]*10+ digits[k];
                    set.add(ans);
                }
            }
        }
        return set.size();
    }
}