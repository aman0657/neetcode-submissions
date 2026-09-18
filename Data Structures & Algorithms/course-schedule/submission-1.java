class Solution {

    private boolean dfs(int i, Map<Integer, List<Integer>> map, boolean [] visited) {
        if(visited[i]){
            return false;
        }
        if(!map.containsKey(i) || map.get(i).size() == 0){
            return true;
        }       
         visited[i] = true;

        for(int v: map.get(i)){
            if(!dfs(v, map, visited)){
                return false;
            }
        }
        visited[i] = false;
        map.put(i, new ArrayList<>());
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }
        boolean [] visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            visited[i] = false;
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, map, visited)){
                return false;
            }
        }
        return true;
    }
}
