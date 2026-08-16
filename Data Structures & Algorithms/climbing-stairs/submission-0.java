class Solution {


    private int helper(int n, int [] dp) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int option1 = helper(n-1, dp);
        int option2 = helper(n-2, dp);
        dp[n] =  option1 + option2;
        return dp[n];
    }
    public int climbStairs(int n) {
        int [] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        return helper(n, dp);
    }
}
