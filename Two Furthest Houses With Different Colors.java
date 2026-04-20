class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxi=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(colors[i]!=colors[j]) maxi = Math.max(maxi,j-i);
            }
        }
        return maxi;
    }
}

//Slight less iteration
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxi=0;
        for(int i=0; i<n; i++){
            for(int j=n-1; j>=i; j--){
                if(colors[i]!=colors[j]){
                    maxi = Math.max(maxi,Math.abs(i-j));
                    break;
                }
            }
        }
        return maxi;
    }
}