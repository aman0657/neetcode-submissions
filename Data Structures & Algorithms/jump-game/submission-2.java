class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0;i<nums.length;i++){
            maxReach = Math.max(maxReach, nums[i] + i);
            if(maxReach <= i && i < nums.length - 1){
                return false;
            }
        }
        return true;
        
    }
}
