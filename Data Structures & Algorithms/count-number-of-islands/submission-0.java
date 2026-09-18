class Solution {

    private void dfs(char [][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) {
            return;
        }
        grid[row][col] = '0';
        if(row + 1 < grid.length && grid[row + 1][col] == '1')
        dfs(grid, row + 1, col);
        if(row - 1 >= 0 && grid[row-1][col] == '1')
        dfs(grid, row - 1, col);
        if(col + 1 < grid[row].length && grid[row][col + 1] == '1')
        dfs(grid, row, col + 1);
        if(col - 1 >= 0 && grid[row][col - 1] == '1')
        dfs(grid, row, col - 1);

        
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[i].length;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);;
                    count ++;
                }
            }
        }
        return count;
    }
}
