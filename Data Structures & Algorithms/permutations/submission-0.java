class Solution {

    private void helper(List<List<Integer>> output, int [] nums, Set<Integer> set, List<Integer> curr) {
        if(curr.size() == nums.length){
            output.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            curr.add(nums[i]);
            set.add(nums[i]);
            helper(output, nums, set, curr);
            curr.removeLast();
            set.remove(nums[i]);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Set<Integer> visited = new HashSet<>(); 
        helper(output, nums, visited, new ArrayList<>());
        return output;
    }
}
