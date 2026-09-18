class Solution {

    private int helper(int [] nums, int [] dp, int n) {
        if(n <= 0){
            return 0;
        }
        if(dp[n] >= 0){
            return dp[n];
        }
        int option1 = helper(nums, dp, n - 1);
        int option2 = helper(nums, dp, n - 2) + nums[n-1];
        dp[n] = Math.max(option1, option2);
        return dp[n];
    }
    public int rob(int[] nums) {
        
        int [] dp = new int[nums.length + 1];
        for(int i=0;i<=nums.length;i++){
            dp[i] = -1;
        }
        return helper(nums, dp, nums.length);
    }
}
