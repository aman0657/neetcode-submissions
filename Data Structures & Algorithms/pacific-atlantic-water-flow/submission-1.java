class Solution {
    private void dfs(int row, int col, boolean [][] pacific, int [][] heights, int n, int m) {
        pacific[row][col] = true;
        int curr_height = heights[row][col];
        if(row < n - 1 && heights[row+1][col] >= curr_height && !pacific[row+1][col]){
            dfs(row + 1, col, pacific, heights, n, m);
        }
        if(col < m - 1 && heights[row][col + 1] >= curr_height && !pacific[row][col+ 1]){
            dfs(row, col + 1, pacific, heights, n, m);
        }
        if(row > 0 && heights[row-1][col] >= curr_height && !pacific[row-1][col]){
            dfs(row - 1, col, pacific, heights, n, m);
        }
        if(col > 0 && heights[row][col-1] >= curr_height && !pacific[row][col-1]){
            dfs(row, col - 1, pacific, heights, n, m);
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean [][] pacific = new boolean[n][m];
        boolean [][] artic = new boolean[n][m];
        

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pacific[i][j] = false;
                artic[i][j] = false;
            }
        }

        // fill for pacific

        for(int i=0;i<n;i++){ // -> first column
            dfs(i, 0, pacific, heights, n, m);
            dfs(i, m-1, artic, heights, n, m);
        }

        for(int i=0;i<m;i++){
            dfs(0,i, pacific, heights, n, m);
            dfs(n-1, i, artic, heights, n, m);
        }

        List<List<Integer>> output = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && artic[i][j]){
                    output.add(List.of(i, j));
                }
            }
        }
        return output;

    


    }
}
