class Solution {
    public int[] asteroidCollision(int[] stone) {
        int n = stone.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            boolean check = false;
            while(!st.isEmpty() && st.peek()>0 && stone[i]<0){
                int toPositive = -stone[i];
                int m = st.peek();
                if(toPositive > m) st.pop();
                else if(toPositive == m) {st.pop(); check=true; break;}
                else{ check = true; break;}
            }
            if(check==false)  st.push(stone[i]);
        }
        List<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        Collections.reverse(list);
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}

//more optimised
class Solution {
    public int[] asteroidCollision(int[] stone) {
        int n = stone.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            boolean check = false;
            while(!st.isEmpty() && st.peek()>0 && stone[i]<0){
                int toPositive = -stone[i];
                int m = st.peek();
                if(toPositive > m) st.pop();
                else if(toPositive == m) {st.pop(); check=true; break;}
                else{ check = true; break;}
            }
            if(check==false)  st.push(stone[i]);
        }
        int len = st.size();
        int[] ans = new int[len];
        for (int i = len - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}