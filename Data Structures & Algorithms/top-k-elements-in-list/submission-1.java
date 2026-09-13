class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> [] freq = new List[nums.length + 1];
        for(int i=0;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            freq[value].add(key);
        }
        int idx = 0;
        int [] result = new int[k];
        for(int i=freq.length-1;i>0 && idx < k;i--){
            for(int j: freq[i]){
                result[idx++] = j;
                if(idx == k){
                    return result;
                }
            }
        }
        return result;
    }

}
