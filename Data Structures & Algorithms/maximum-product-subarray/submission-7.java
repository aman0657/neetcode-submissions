class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0], minProduct = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] < 0){
                int temp = maxProduct;
                maxProduct = Math.max(nums[i], minProduct * nums[i]);
                minProduct = Math.min(nums[i] , temp * nums[i]);
            } else if(nums[i] > 0){
                maxProduct = Math.max(nums[i], nums[i] * maxProduct);
                minProduct = Math.min(nums[i], nums[i] * minProduct);
            } else {
                maxProduct = 0;
                minProduct = 0;
            }
            ans = Math.max(ans, maxProduct);
        }
        return ans;

    }
}
