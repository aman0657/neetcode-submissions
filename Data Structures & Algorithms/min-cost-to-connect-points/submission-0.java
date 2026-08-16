class Solution {

    private int getParent(int v, int [] parent) {
        if(v == parent[v]){
            return v;
        }
        return getParent(parent[v], parent);
    }

    private int getDistance(int [] first, int [] second){
        return Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // mst (create edges n * n)
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            for(int j=i + 1;j<points.length;j++){
                int w = getDistance(points[i], points[j]);
                Edge edge = new Edge(i, j, w);
                edges.add(edge);
            }
        }
        Collections.sort(edges, (Edge a, Edge b) -> {
            return a.w - b.w;
        });
        int ans = 0;
        int cnt = 0;
        int i = 0;
        int [] parent = new int[n];
        for(int t=0;t<n;t++){
            parent[t] = t;
        }
        while(i < edges.size() && cnt < n){
            Edge curr = edges.get(i);
            int u = curr.u;
            int v = curr.v;
            int w = curr.w;
            int parentU = getParent(u, parent);
            int parentV = getParent(v, parent);
            if(parentU == parentV){
                i ++;
                continue;
            }
            parent[parentU] = parentV;
            ans += w;
            i ++;
            cnt ++;
        }
        return ans;
    }

    private static class Edge {
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
