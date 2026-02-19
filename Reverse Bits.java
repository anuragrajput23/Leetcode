class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for(int i=1; i<=32; i++){
            result = result<<1;
            result = result | (n&1);
            n=n>>1;
        }

        return result;
    }
}