class Solution {
    public int jump(int[] nums) {
        int maxEnd = 0, currEnd = 0;
        int i = 0, n = nums.length;
        int jump = 0;
        if(nums.length == 1){
            return 0;
        }
        while(i < n){
            currEnd = maxEnd;
            while(i <= currEnd ){
                maxEnd = Math.max(maxEnd, i + nums[i]);
                i ++;
            }
            jump ++;
            if(maxEnd >= n - 1){
                return jump;
            }
        }
        return -1;
    
    }
}
