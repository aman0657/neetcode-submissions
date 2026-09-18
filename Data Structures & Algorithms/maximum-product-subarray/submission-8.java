class Solution {
    public int maxProduct(int[] nums) {
        int maxValue = 1, minValue = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                maxValue = Math.max(nums[i], maxValue * nums[i]);
                minValue = Math.min(nums[i], minValue * nums[i]);
            } else if(nums[i] < 0){
                int temp = maxValue;
                maxValue = Math.max(nums[i], minValue * nums[i]);
                minValue = Math.min(nums[i], temp * nums[i]);
            } else {
                maxValue = 0;
                minValue = 0;
            }
            ans = Math.max(ans, maxValue);
        }
        return ans;
    }
}
