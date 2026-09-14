class Solution {
    public int jump(int[] nums) {
        int max_jump = 0;
        int i = 0;
        int count = 0;
        if(nums.length == 1){
            return 0;
        }
        while(i < nums.length){
            int curr_jump = max_jump;
            while( i <= curr_jump){
                max_jump = Math.max(max_jump, nums[i] + i);
                i ++;
            }
            count ++;
            if(max_jump >= nums.length - 1){
                return count;
            }
        }
        return -1;
    }
}
