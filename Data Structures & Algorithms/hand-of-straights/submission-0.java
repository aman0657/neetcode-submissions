class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        for(int i=0;i<n;i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry.getKey());
        }
        while(!pq.isEmpty()){
            int min = pq.peek();
            for(int i=min;i<min+groupSize;i++){
                if(!map.containsKey(i)){
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0){
                    pq.poll();
                }
            }
        }
        return true;
    }
}
