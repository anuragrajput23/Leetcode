class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] result = new long[n];
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new int[]{i, nums1[i], nums2[i]});
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;

        int i = 0;
        while (i < n) {
            int j = i;

            // process same nums1 group
            while (j < n && list.get(j)[1] == list.get(i)[1]) {
                result[list.get(j)[0]] = sum;
                j++;
            }

            // now add all their nums2
            for (int t = i; t < j; t++) {
                pq.add(list.get(t)[2]);
                sum += list.get(t)[2];

                if (pq.size() > k) {
                    sum -= pq.poll();
                }
            }

            i = j;
        }

        return result;
    }
}