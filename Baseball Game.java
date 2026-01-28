class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops){
            if (op.equals("C")) {
                stack.pop();
            }
            else if (op.equals("D")){
                stack.push(2 *stack.peek());
            }
            else if (op.equals("+")){
                int last = stack.pop();
                int secondLast = stack.peek();
                stack.push(last);
                stack.push(last + secondLast);
            }
            else{
                //number (can be multi-digit or negative)
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int val : stack) sum += val;
        return sum;
    }
}