class Solution {

    private void helper(List<List<Integer>> output, List<Integer> curr, int [] nums, int target, int id, int sum) {
        if(id >= nums.length){
            return;
        }
        if(sum == target){
            output.add(new ArrayList<>(curr));
            return;
        }
        if(sum + nums[id] <= target){
            curr.add(nums[id]);
            helper(output, curr, nums, target, id, sum + nums[id]);
            curr.removeLast();
        }
        helper(output, curr, nums, target, id + 1, sum);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        helper(output, new ArrayList<>(), nums, target, 0, 0);
        return output;
    }
}
