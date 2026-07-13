class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for(int i=low; i<=high; i++){
            if(check(i)==true){
                list.add(i);
            }
        }
        return list;
    }
    public boolean check(int num){
        String str = num + "";
        for(int i=1; i<str.length(); i++){
            if((str.charAt(i-1)-'0')+1 != str.charAt(i)-'0'){
                return false;
            }
        }
        return true;
    }
}

//More optimised O(N) and O(N);
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(1);
        qu.offer(2);
        qu.offer(3);
        qu.offer(4);
        qu.offer(5);
        qu.offer(6);
        qu.offer(7);
        qu.offer(8);
        //bfs
        while(!qu.isEmpty()){
            int front = qu.poll();
            if(front >= low && front <= high){
                list.add(front);
            }
            int lastElem = front%10;
            if(lastElem < 9){
                int nextElem = front*10+lastElem+1;
                if(nextElem <= high) qu.offer(nextElem);

            }
        }
        return list;
    }
}