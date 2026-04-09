// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         int n = nums.length;
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int ele : nums) map.put(ele, map.getOrDefault(ele,0)+1);
//         PriorityQueue<int[]> pq = new PriorityQueue<>(((a,b)-> b[1]-a[1]));
//         for(int key : map.keySet()){
//             pq.offer(new int[]{key,map.get(key)});
//         }
//         int[] ans = new int[k];
//         for(int i=0; i<k; i++){
//             ans[i] = pq.poll()[0];
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums) map.put(ele, map.getOrDefault(ele,0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(((a,b)-> a[1]-b[1]));
        for(int key : map.keySet()){
            pq.offer(new int[]{key,map.get(key)});
            while(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}