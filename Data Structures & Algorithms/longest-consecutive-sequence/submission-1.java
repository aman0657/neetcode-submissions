class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i] - 1)){
                continue;
            }
            int len = 0;
            while(set.contains(nums[i] + len)){
                len ++;
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }

}
