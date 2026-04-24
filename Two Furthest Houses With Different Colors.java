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
// class Solution {
//     public int maxDistance(int[] colors) {
//         int n = colors.length;
//         int maxi=0;
//         for(int i=0; i<n; i++){
//             for(int j=n-1; j>=i; j--){
//                 if(colors[i]!=colors[j]){
//                     maxi = Math.max(maxi,Math.abs(i-j));
//                     break;
//                 }
//             }
//         }
//         return maxi;
//     }
// }

//more optimised in O(n)
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxi = 0;
        int j=n-1;
        int i=0;
        while(i<=j){
            if(colors[i]!=colors[j]){
                maxi = Math.max(maxi,Math.abs(j-i));
                break;
            }else{
                i++;
            }
        }
        i=0;
        j=n-1;
        while(j>=i){
            if(colors[i]!=colors[j]){
                maxi = Math.max(maxi,Math.abs(j-i));
                break;
            }else{
                j--;
            }
        }
        return maxi;
    }
}