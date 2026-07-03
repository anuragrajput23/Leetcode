class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> qu = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]==2){
                    qu.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }
            }
        }
        int time = 0;
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0, 1, 0, -1};
        while(!qu.isEmpty()){
            int[] front = qu.poll();
            int r = front[0];
            int c = front[1];
            int t = front[2];
            time = Math.max(time,t);
            for(int x=0; x<4; x++){
                int newR = r+drow[x];
                int newC = c + dcol[x];
                if(newR>=0 && newR<n && newC>=0 && newC <m && vis[newR][newC]==false && grid[newR][newC]==1){
                    qu.add(new int[]{newR, newC, t+1});
                    vis[newR][newC]=true;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]==1) return -1;
            }
        }
        return time;
    }
}

//slight optmised way
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> qu = new LinkedList<>();
        int freshCnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]==2){
                    qu.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }else{
                    vis[i][j]=false;
                }
                if(grid[i][j]==1)  freshCnt++;
            }
        }
        int time = 0;
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0, 1, 0, -1};
        int cnt = 0;
        while(!qu.isEmpty()){
            int[] front = qu.poll();
            int r = front[0];
            int c = front[1];
            int t = front[2];
            time = Math.max(time,t);
            for(int x=0; x<4; x++){
                int newR = r+drow[x];
                int newC = c + dcol[x];
                if(newR>=0 && newR<n && newC>=0 && newC <m && vis[newR][newC]==false && grid[newR][newC]==1){
                    qu.add(new int[]{newR, newC, t+1});
                    vis[newR][newC]=true;
                    cnt++;
                }
            }
        }
        if(cnt!=freshCnt) return -1;
        return time;
    }
}