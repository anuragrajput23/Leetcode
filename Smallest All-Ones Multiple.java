class Solution {
    public int minAllOneMultiple(int k) {
        if(k==2 || k==5) return -1;
        int rem = 1;
        int cnt = 1;
        int check = k;
        while(check > 0){
            if(rem%k==0) return cnt;
            rem = (rem*10+1)%k;
            cnt++;
            check--;
        }
        return -1;
    }
}