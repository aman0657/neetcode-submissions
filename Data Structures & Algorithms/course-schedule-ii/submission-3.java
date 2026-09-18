class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, map, list, visited, cycle)){
                return new int[0];
            }
        }
        int [] output = new int[list.size()];
        for(int i=0;i<output.length;i++){
            output[i] = list.get(i);
        }
        return output;
    }
    private boolean dfs(int i, Map<Integer, List<Integer>> map, List<Integer> list, Set<Integer> visited, Set<Integer> cycle) {
        if(visited.contains(i)){
            return true;
        }
        if(cycle.contains(i)){
            return false;
        }      
        cycle.add(i);
        if(map.containsKey(i))
        for(int v: map.get(i)){
            if(!dfs(v, map, list, visited, cycle)){
                return false;
            }
        }
        cycle.remove(i);
        list.add(i);
        visited.add(i);
        return true;
    }
}

   