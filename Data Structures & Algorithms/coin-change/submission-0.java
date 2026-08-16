class Solution {

    private int helper(int [] coins, int ind, int amount, int [][] dp) {
        if(amount == 0){
            return 0;
        }
       
        if(ind >= coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }
        int option1 = Integer.MAX_VALUE;
        if(amount >= coins[ind])
        option1 = helper(coins, ind, amount - coins[ind], dp);
        if(option1 != Integer.MAX_VALUE){
            option1 += 1;
        }
        int option2 = helper(coins, ind + 1, amount, dp);
        int ans = Math.min(option1, option2);
        dp[ind][amount] = ans;
        return ans;
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        int ans = helper(coins, 0, amount,  dp);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return  ans;
    }
}
