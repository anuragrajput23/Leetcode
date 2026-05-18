class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int curr = q.poll();

                if (curr == n - 1) return steps;

                int left = curr - 1;
                int right = curr + 1;
                if (left >= 0 && !visited[left]) {
                    visited[left] = true;
                    q.offer(left);
                }
                if (right < n && !visited[right]) {
                    visited[right] = true;
                    q.offer(right);
                }
                if (map.containsKey(arr[curr])) {
                    for (int idx : map.get(arr[curr])) {

                        if (!visited[idx]) {
                            visited[idx] = true;
                            q.offer(idx);
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            steps++;
        }
        return -1;
    }
}