class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue< int [] > pq = new PriorityQueue<>((int [] a, int [] b ) -> {
            return b[1] - a[1];
        });
        int n = nums.length;
        int [] output = new int[n - k + 1];
        int id = 0;
        for(int i=0;i<k;i++){
            pq.add(new int[]{i, nums[i]});
        }
        output[id++] = pq.peek()[1];
        int l = 0;
        for(int r=k;r<n;r++){
            pq.add(new int[]{r, nums[r]});
            while(!pq.isEmpty() && pq.peek()[0] < (r + 1 - k)){
                pq.poll();
            }
            output[id++]= pq.peek()[1];
        }
        return output;
    }
}
