class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int []> >adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adjList.get(times[i][0] - 1).add(new int[]{times[i][1] - 1, times[i][2]});
        }
       PriorityQueue<int []> pq = new PriorityQueue<>((int [] a, int [] b) -> {
        return a[1] - b[1];
       });
       pq.add(new int[]{k-1, 0});
       int [] distance = new int[n];
       for(int i=0;i<n;i++){
        distance[i] = Integer.MAX_VALUE;
       }
       distance[k-1] = 0;
       boolean [] visited = new boolean[n];
       for(int i=0;i<n;i++){
        visited[i] = false;
       }
       while(!pq.isEmpty()){
        int [] top = pq.poll();
        int u = top[0];
        int dist = top[1];
        if(visited[u]){
            continue;
        }
        visited[u] = true;
  
        for(int [] child: adjList.get(u)){
            int v = child[0];
            int weight = child[1];
            int newDistance = dist + weight;
            if(distance[v] > newDistance) {
                distance[v] = newDistance;
                pq.add(new int[]{v, distance[v]});
            }
        }
       } 
       int ans = Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
        ans= Math.max(ans, distance[i]);
       }
       if(ans == Integer.MAX_VALUE){
        return -1;
       }
       return ans;

    }
}
