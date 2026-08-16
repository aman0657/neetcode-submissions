class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> list = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (int [] a, int [] b) -> {
            return a[0] - b[0];
        });
        int [] prev = intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0] <= prev[1]){
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                list.add(new int[]{prev[0], prev[1]});
                prev = intervals[i];
            }
        }
        list.add(prev);
        return list.toArray(new int[list.size()][]);
        
    }
}
