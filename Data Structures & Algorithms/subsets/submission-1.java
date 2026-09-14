class Solution {

    private void helper(int [] nums, int id,  List<Integer> list, List<List<Integer>> output) {
        if(id >= nums.length){
            output.add(new ArrayList<>(list));
            return;
        }
        helper(nums, id + 1, list, output);
        list.add(nums[id]);
        helper(nums, id + 1, list, output);
        list.removeLast();
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer> > output = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), output);
        return output;
    }
}
