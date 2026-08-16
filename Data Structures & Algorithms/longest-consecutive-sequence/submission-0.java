class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longest = 0;
        for(int i=0;i<n;i++){
            // is it the starting of seq
            int len = 0;
            if(set.contains(nums[i] - 1)) {
                continue;
            }
            while(set.contains(nums[i] + len)) {
                len ++;
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }
}
