class Solution {

    private void updateNeighbour(int x, int y, int [][] grid, Queue<int [] > queue) {
        if(x - 1 >= 0 && grid[x-1][y] == Integer.MAX_VALUE){
            queue.add(new int[]{x -1 , y});
            grid[x-1][y] = grid[x][y] + 1;
        }
        if(y - 1 >= 0 && grid[x][y-1] == Integer.MAX_VALUE){
            queue.add(new int[]{x, y - 1});
            grid[x][y - 1] = grid[x][y] + 1;
        }
        if(x + 1 < grid.length && grid[x+1][y] == Integer.MAX_VALUE) {
            queue.add(new int[]{x + 1, y});
            grid[x+1][y] = grid[x][y] + 1;
        }
        if(y + 1 < grid[x].length && grid[x][y + 1] == Integer.MAX_VALUE) {
            queue.add(new int[]{x, y + 1});
            grid[x][y + 1] = grid[x][y] + 1;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int [] top = queue.poll();
                int x = top[0];
                int y = top[1];
                if(grid[x][y] == Integer.MAX_VALUE){
                    grid[x][y] = cnt;
                }
                updateNeighbour(x, y, grid, queue);
            }   
            cnt ++;
        }

    }
}
