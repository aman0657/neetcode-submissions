class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 0;
        int zeroCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                if(product == 0){
                    product = 1;
                }
                product = product * nums[i];
            } else {
                zeroCount ++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0 && zeroCount == 1){
                nums[i] = (int)product;
            } else if(zeroCount == 0){
                nums[i] = (int) product / nums[i];
            } else {
                nums[i] = 0;
            }
        }
        return nums;
        
    }
}  
