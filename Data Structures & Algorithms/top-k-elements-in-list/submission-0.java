class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((int [] a,int [] b) -> b[1] - a[1]);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        List<Integer> output= new ArrayList<>();
        while(k > 0 && !pq.isEmpty()){
            output.add(pq.poll()[0]);
            k --;
        }
        int [] arr = new int[output.size()];
        for(int i=0;i<output.size();i++){
            arr[i] = output.get(i);
        }
        return arr;



    }
}
