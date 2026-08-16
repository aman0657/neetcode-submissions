class Solution {

    private boolean updateNeighbour(int row, int col, int [][]grid, boolean [][] visited, Queue<int []> q, int n, int m) {
        if(row < 0 || col < 0 || row >= n || col >= m || visited[row][col] || grid[row][col] == 0){
            return false;
        }
        visited[row][col] = true;
        q.add(new int[]{row, col});
        return true;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int freshFruits = 0;
        boolean [][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = false;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if(grid[i][j] == 1){
                    freshFruits ++;
                }
            }
        }
        int time = 0;
        while(freshFruits > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int [] top = q.poll();
                int row = top[0];
                int col = top[1];
                if(updateNeighbour(row + 1, col, grid, visited, q, n, m)){
                    freshFruits --;
                }
                if(updateNeighbour(row - 1, col, grid, visited, q, n, m)){
                    freshFruits --;
                }
                if(updateNeighbour(row, col - 1, grid, visited, q, n, m)){
                    freshFruits --;
                }
                if(updateNeighbour(row, col + 1, grid, visited, q, n, m)){
                    freshFruits --;
                }
            }
            time ++;
        }
        if(freshFruits == 0){
            return time;
        }
        return -1;
    }
}
