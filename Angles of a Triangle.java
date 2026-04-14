class Solution {
    public double[] internalAngles(int[] sides) {
        int n = sides.length;
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        double[] ans = new double[n];
        boolean check = isValidSide(sides[0], sides[1], sides[2]);
        if(check==false) return new double[]{};
        double A = Math.acos((b*b + c*c - a*a)/(2*b*c))*180.0/Math.PI;
        double B = Math.acos((a*a + c*c - b*b)/(2*a*c))*180.0/Math.PI;
        double C = Math.acos((a*a + b*b - c*c)/(2*a*b))*180.0/Math.PI;
        ans[0] = A;
        ans[1] = B;
        ans[2] = C;
        Arrays.sort(ans);
        return ans;

    }
    public boolean isValidSide(int a, int b, int c){
        return (a+b)>c && (a+c)>b && (b+c)>a;
    }
}