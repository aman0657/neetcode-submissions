class Solution {
    private int helper(String s, String t, int i, int j, int [][] dp){
        if(j >= t.length()){
            return 1;
        }
        if(i >= s.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int option1 = 0, option2 = 0;
        if(s.charAt(i) == t.charAt(j)){
            option1 = helper(s, t, i + 1, j + 1, dp);
        }
        option2 = helper(s, t, i + 1, j, dp);
        int ans = option1 + option2;
        dp[i][j] = ans;
        return ans;
        

    }
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int [][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        return helper(s, t, 0, 0, dp);
    }
}
