class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);
        int conh=1;
        int side1=1;
        for(int i=1;i<h.length;i++){
            if(h[i]-h[i-1]==1){
                conh++;
            }else{
                conh=1;
            }
            side1=Math.max(side1,conh);
        }
        int conv=1;
        int side2=1;
        for(int i=1;i<v.length;i++){
            if(v[i]-v[i-1]==1){
                conv++;
            }else{
                conv=1;
            }
            side2=Math.max(side2,conv);
        }
        int side=Math.min(side1,side2)+1;
        return side*side;

    }
}