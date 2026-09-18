class Solution {
    private boolean helper(int [] nums, int [][] dp, int sum, int id) {
        if(id == nums.length){
            if(sum == 0){
                return true;
            }
            return false;
        }
        if(sum == 0){
            return true;
        }
        if(dp[id][sum] != -1){
            return dp[id][sum] == 1 ? true : false;
        }
        boolean option1 = helper(nums, dp, sum, id + 1);
        boolean option2 = false;
        if(sum >= nums[id])
             option2 = helper(nums, dp, sum - nums[id] , id + 1);
        boolean ans = option1 || option2;
        dp[id][sum] = ans == true ? 1 : 0;
        return ans;

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int [][] dp = new int[nums.length+1][sum / 2 + 1];
        for(int i=0;i<=nums.length;i++){
            for(int j=0;j<= sum / 2;j++){
                dp[i][j] = -1;
            }
        }
        return helper(nums, dp, sum / 2, 0);
    }
}
