class Solution {

    private void addChild(int [][] grid, int row, int col, boolean [][] visited, Queue<int []> q, int n, int m){
        if(row < 0 || row >= n || col < 0 || col >= m || visited[row][col] || grid[row][col] == -1){
            return;
        }
        visited[row][col] = true;
        q.add(new int[] {row, col});
    }
    public void islandsAndTreasure(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;

        boolean [][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = false;
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        // multi source bfs
        int distance = 0;
        
        

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int [] top = q.poll();
                int row = top[0];
                int col = top[1];
                grid[row][col] = distance;
                addChild(grid, row + 1, col, visited, q, n, m);
                addChild(grid, row, col + 1, visited, q, n, m);
                addChild(grid, row - 1, col, visited, q, n, m);
                addChild(grid, row, col - 1, visited, q, n, m);
            }
            distance ++;
        }
    }
}
