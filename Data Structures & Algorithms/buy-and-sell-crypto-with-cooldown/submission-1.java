class Solution {
    private int helper(int [] prices, int id, int flag, int [][] dp) {
        if(id >= prices.length){
            return 0;
        }
        if(dp[id][flag] !=-1){
            return dp[id][flag];
        }
        int option1 = Integer.MIN_VALUE, option2 = Integer.MIN_VALUE;
        if(flag == 0){
            option1 = helper(prices, id + 1, 1, dp) - prices[id];
        } else {
            option2 = helper(prices, id + 2, 0, dp) + prices[id];
        }
        int option3 = helper(prices, id + 1, flag, dp);
        int ans = Math.max(option1, Math.max(option2, option3));
        dp[id][flag] = ans;
        return ans;
    }
    public int maxProfit(int[] prices) {
        int [][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j] = -1;
            }
        }
        return helper(prices, 0, 0, dp);
        // 0 -> not buyed
    }
}
