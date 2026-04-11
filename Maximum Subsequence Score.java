class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = nums1.length;
        for (int i=0; i<n; i++){
            list.add(new int[]{nums1[i], nums2[i]});
        }

        list.sort((a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;

        for (int i = 0; i <= k - 1; i++){
            sum += list.get(i)[0];
            pq.add(list.get(i)[0]);
        }
        long ans = sum*list.get(k - 1)[1];
        for (int i = k; i < n; i++){
            int val = list.get(i)[0];
            if (val > pq.peek()){
                sum -= pq.poll();
                sum += val;
                pq.add(val);
            }
            ans = Math.max(ans, sum * list.get(i)[1]);
        }
        return ans;
    }
}