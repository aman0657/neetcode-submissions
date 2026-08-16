class Solution {

    private void helper(Set<List<Integer>> output, int [] nums, int target, int id, int sum, List<Integer> curr) {
        if(sum == target){
            output.add(new ArrayList<>(curr));
            return;
        }
        if(id >= nums.length){
            return;
        }
        if(nums[id] + sum <= target) {
            curr.add(nums[id]);
            helper(output, nums, target, id + 1, sum + nums[id], curr);
            curr.remove(curr.size()-1);
        }
        while(id + 1 < nums.length && nums[id] == nums[id+1]){
            id ++;
        }
        helper(output, nums, target, id + 1, sum, curr);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> output = new HashSet<>();
        Arrays.sort(candidates);
        helper(output, candidates, target, 0, 0, new ArrayList<>());
        return new ArrayList<>(output);
    }
}
