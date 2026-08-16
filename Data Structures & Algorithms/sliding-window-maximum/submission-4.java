class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // monotonic deque
        Deque<Integer> deque = new LinkedList<>();
        int l = 0, n = nums.length, r = 0;
        int [] output = new int[n - k + 1];
        while(r < n){
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[r]){
                deque.removeLast();
            }
            deque.addLast(r);
               if (l > deque.getFirst()) {
                deque.removeFirst();
            }
            if( (r + 1) >= k){
                output[l] = nums[deque.getFirst()];
                l ++;
            }
            r ++;
        }
        return output;
    }
}
