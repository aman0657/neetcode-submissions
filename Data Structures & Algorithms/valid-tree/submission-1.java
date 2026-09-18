class Solution {

    private boolean dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> adjList) {
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        for(int child : adjList.get(node)){
            if(child == parent){
                continue;
            }
           if(!dfs(child, node, visited, adjList)){
            return false;
           }
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        // tree can have max n - 1 edge
        if(edges.length > n - 1){
            return false;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        // checking for cyle
        if(!dfs(0, -1, visited, adjList)){
            return false;
        }
        return visited.size() == n;
        // if i visited all the nodes

    }
}
