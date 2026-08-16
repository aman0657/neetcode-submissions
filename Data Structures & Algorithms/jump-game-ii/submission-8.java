class Solution {
    public int jump(int[] nums) {
        int i = 0, n = nums.length;
        int maxEnd = 0;
        if(n == 1){
            return 0;
        }
        int jump = 0;
        while(i < n){
            int currEnd = maxEnd;
            while(i <= currEnd){
                maxEnd = Math.max(maxEnd, nums[i] + i);
                i ++;
            }
            jump ++;
              if(maxEnd >= n-1){
                return jump;
            }
        }
        return -1;
    }
}
