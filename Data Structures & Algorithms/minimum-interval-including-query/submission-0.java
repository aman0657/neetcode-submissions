class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (int [] a, int [] b) -> {
            return a[0] - b[0];
        });
        int [] queriesSorted = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            queriesSorted[i] = queries[i];
        }
        Arrays.sort(queriesSorted);
        int n = intervals.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((int [] a, int [] b)-> {
            return a[0] - b[0];
        });
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        // below i am not doing n* n because for each query i am not traversing whole intervals, duplicate and repetatioin handled.
        // for query q, it multiple intervals are satisfying the condigion, i am not checking them iterative way, just doing in logn (pqueue)
        for(int q=0;q<queriesSorted.length;q++){
            int query = queriesSorted[q];
            while(i < n && intervals[i][0] <= query){
                pq.add(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i ++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < query){
                pq.poll();
            }
            if(pq.isEmpty()){
                map.put(query, -1);
            } else 
            map.put(query, pq.peek()[0]);
        }
        int [] output = new int[queries.length];
        for( i=0;i<queries.length;i++){
            output[i] = map.get(queries[i]);
        }
        return output;
    }
}
