class Solution {
    private int helper(int r, int c, int m, int n, int [][] dp){
        if(r > m || r < 0 || c > n || c < 0){
            return 0;
        }
        if(r == m && c == n){
            return 1;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int option1 = helper(r + 1, c, m, n, dp);
        int option2 = helper(r, c + 1, m, n, dp);
        int ans = option1 + option2;
        dp[r][c] = ans;
        return ans;

    }
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, m - 1, n - 1, dp);
    }
}
