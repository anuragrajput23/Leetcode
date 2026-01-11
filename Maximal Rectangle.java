class Solution {
    public int[] getNSR(int[] height) {
        int n = height.length;
        int[] NSR = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=n-1; i >= 0;i--){
            while (!st.isEmpty() && height[st.peek()] >= height[i]){
                st.pop();
            }
            NSR[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return NSR;
    }

    public int[] getNSL(int[] height){
        int n = height.length;
        int[] NSL = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++){
            while (!st.isEmpty() && height[st.peek()] >= height[i]){
                st.pop();
            }
            NSL[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return NSL;
    }

    public int findingmax_area(int[] height) {
        int n = height.length;

        int[] NSR = getNSR(height);
        int[] NSL = getNSL(height);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = width * height[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];

        // first row
        for (int i = 0; i < n; i++) {
            height[i] = (matrix[0][i] == '1') ? 1 : 0;
        }

        int maxArea = findingmax_area(height);

        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '0') {
                    height[col] = 0;
                } else {
                    height[col] += 1;
                }
            }
            maxArea = Math.max(maxArea, findingmax_area(height));
        }
        return maxArea;
    }
}
