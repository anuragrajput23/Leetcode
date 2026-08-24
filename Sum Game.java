class Solution {
    public boolean sumGame(String num) {
        char[] arr = num.toCharArray();
        int n = num.length();
        int i=0;
        int j=n-1;
        int leftSum = 0;
        int rightSum = 0;
        int t1 = 0;
        int t2 = 0;
        while(i < j){
            if(arr[i]!='?'){
                leftSum += arr[i]-'0';
            }else{
                t1++;
            }
            if(arr[j]!='?'){
                rightSum += arr[j]-'0';
            }else{
                t2++;
            }
            i++;
            j--;
        }
        return 2 * (leftSum - rightSum) != 9 * (t2 - t1);

    }
}

//slight optimisation
class Solution {
    public boolean sumGame(String num) {
        char[] arr = num.toCharArray();
        int n = num.length();
        int i=0;
        int leftSum = 0;
        int rightSum = 0;
        int t1 = 0;
        int t2 = 0;
        while(i < n/2){
            if(arr[i]!='?'){
                leftSum += arr[i]-'0';
            }else{
                t1++;
            }
            if(arr[n-1-i]!='?'){
                rightSum += arr[n-1-i]-'0';
            }else{
                t2++;
            }
            i++;
        }
        return 2 * (leftSum - rightSum) != 9 * (t2 - t1);
    }
}