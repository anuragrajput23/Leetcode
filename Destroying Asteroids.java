class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        Arrays.sort(asteroids);
        if(n==1){
            if(mass >= asteroids[0]) return true;
            return false;
        }
        long sum = mass;
        int idx = 0;
        for(int i=0; i<n; i++){
            if(asteroids[i] <= mass){
                sum += asteroids[i];
                idx = i;
            }
        }
        if(n==1){
            if(mass >= asteroids[0]) return true;
            return false;
        }
        int i;
        for(i=idx+1; i<n; i++){
            if(sum >= asteroids[i]){
                sum += asteroids[i];
            }else{
                return false;
            }
        }
        return i>=n-1;
    }
}