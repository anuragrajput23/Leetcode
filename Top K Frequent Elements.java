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

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         int n = nums.length;
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int ele : nums) map.put(ele, map.getOrDefault(ele,0)+1);
//         PriorityQueue<int[]> pq = new PriorityQueue<>(((a,b)-> a[1]-b[1]));
//         for(int key : map.keySet()){
//             pq.offer(new int[]{key,map.get(key)});
//             while(pq.size()>k){
//                 pq.poll();
//             }
//         }
//         int[] ans = new int[k];
//         for(int i=0; i<k; i++){
//             ans[i] = pq.poll()[0];
//         }
//         return ans;
//     }
// }

//O(n) complexity ans space O(n);
//using Bucket sorting
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        // int[] bucket = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums) map.put(ele,map.getOrDefault(ele,0)+1);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            list.add(new ArrayList<>());
        }
        for(int key : map.keySet()){
            int freq = map.get(key);
            list.get(freq).add(key);
        }
        int[] ans = new int[k];
        int cnt=0;
        for(int i = list.size() - 1; i >= 0 && cnt < k; i--) {
            if (!list.get(i).isEmpty()) {
                for(int num : list.get(i)){
                    ans[cnt++] = num;
                    if(cnt==k) break;
                }
            }
        }
        return ans;
    }
}