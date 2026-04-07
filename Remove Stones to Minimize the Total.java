class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        int ans=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            pq.offer(piles[i]);
        }
        while(k > 0){
                int temp = (pq.poll()+1)/2;
                // ans += temp;
                pq.offer(temp);
                k--;

        }
        while(!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}