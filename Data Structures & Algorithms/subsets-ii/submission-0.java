class Solution {
    private void helper(List<List<Integer>> output, List<Integer> curr, int [] nums, int id) {
        if(id >= nums.length){
            output.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[id]);
        helper(output, curr, nums, id + 1);
        curr.removeLast();
        while(id + 1 < nums.length && nums[id] == nums[id+ 1]){
            id ++;
        }
        helper(output, curr, nums, id + 1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        helper(output, new ArrayList<>(), nums, 0);
        return output;
    }
}
