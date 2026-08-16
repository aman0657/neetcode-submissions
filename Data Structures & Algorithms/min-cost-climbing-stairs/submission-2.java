class Solution {
    private int helper(int [] cost, int [] dp, int n) {
        if(n <= 1){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int option1 = n - 1 >= 0 ? cost[n-1] + helper(cost, dp, n - 1) : Integer.MAX_VALUE;
        int option2 = n - 2 >= 0 ? cost[n-2] + helper(cost, dp, n - 2) : Integer.MAX_VALUE;
        int ans = Math.min(option1, option2);
        dp[n] = ans;
        return ans;

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        return helper(cost, dp, n) ;
    }
}
