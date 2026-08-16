class Solution {
    public int jump(int[] nums) {
        int i = 0, n = nums.length;
        int maxEnd = 0;
        if(n == 1){
            return 0;
        }
        int jump = 0;
        int currEnd = 0;
        while(i < n){
            maxEnd = currEnd;
            while(i <= currEnd && i < n){
                maxEnd = Math.max(maxEnd, nums[i] + i);
                i ++;
            }
            jump ++;
            currEnd = maxEnd;
            // maxEnd = Math.max(maxEnd, nums[i] + i);
              if(maxEnd >= n-1){
                return jump;
            }
        }
        return -1;
    }
}
