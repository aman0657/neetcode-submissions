class Solution {

    private int helper(int [] arr, int n, int id, int [] dp) {
       
        if(id >= n){
            return 0;
        }
        if(dp[id] != -1){
            return dp[id];
        }
        int option1 = helper(arr, n, id + 2, dp) + arr[id];
        int option2 = helper(arr, n, id + 1, dp);
        dp[id] = Math.max(option1, option2);
        return dp[id];
    }
    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int [] first = new int[n-1];
        int [] second = new int[n-1];
        for(int i=0;i<n-1;i++){
            first[i] = nums[i];
        }
        for(int i=1;i<n;i++){
            second[i-1] = nums[i];
        }
        int [] dp = new int[n-1];
        int [] te = new int[n-1];
        for(int i=0;i<n-1;i++){
            dp[i] = -1;
            te[i] = -1;
        }
        return Math.max(helper(first, n-1, 0, dp) , helper(second, n-1, 0, te));
    }
}
