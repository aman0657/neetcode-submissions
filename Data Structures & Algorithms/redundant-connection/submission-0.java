class Solution {

    private int getParent(int v, int [] parent){
        if(v == parent[v]){
            return v;
        }
        return getParent(parent[v], parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int [] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int i=0;i<edges.length;i++){
            int [] edge = edges[i];
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int parentU = getParent(u, parent);
            int parentV = getParent(v, parent);
            if(parentU == parentV){
                return new int []{u+ 1, v+ 1};
            }
            parent[parentU] = parentV;
        }
        return new int[]{};
    }
}
