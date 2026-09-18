class Solution {


     private int dfs(int [][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) {
            return 0;
        }
        grid[row][col] = 0;
        int ans = 1;
        if(row + 1 < grid.length && grid[row + 1][col] == 1)
        ans += dfs(grid, row + 1, col);
        if(row - 1 >= 0 && grid[row-1][col] == 1)
        ans += dfs(grid, row - 1, col);
        if(col + 1 < grid[row].length && grid[row][col + 1] == 1)
        ans += dfs(grid, row, col + 1);
        if(col - 1 >= 0 && grid[row][col - 1] == 1)
        ans += dfs(grid, row, col - 1);
        return ans;

        
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[i].length;j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }
}
