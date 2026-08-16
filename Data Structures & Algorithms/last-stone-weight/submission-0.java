class Solution {
    PriorityQueue<Integer> pq;
    Solution(){
        pq = new PriorityQueue<>(( a ,  b) ->  b - a);
    }
    public int lastStoneWeight(int[] stones) {
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size() > 1){
            int top = pq.poll();
            int stop = pq.poll();
            int diff = Math.abs(top - stop);
            if(diff > 0){
                pq.add(diff);
            }
        }
        if(pq.size() == 0){
            return 0;
        } else {
            return pq.poll();
        }
    }
}
