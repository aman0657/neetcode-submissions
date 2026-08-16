class Solution {

    private void helper(int [] nums, int ind, List<List<Integer>> output, List<Integer> curr) {
        if(ind == nums.length){
            List<Integer> temp = new ArrayList<>(curr);
            output.add(temp);
            return;
        }
        curr.add(nums[ind]);
        helper(nums, ind + 1, output, curr);
        curr.removeLast();
        helper(nums, ind + 1, output, curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        helper(nums, 0, output, new ArrayList<>());
        return output;
    }
}
