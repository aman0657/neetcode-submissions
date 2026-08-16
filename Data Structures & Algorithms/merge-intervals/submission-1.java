class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> list = new ArrayList<>();
        int i = 0, n = intervals.length;
        Arrays.sort(intervals, (int [] a, int [] b) -> {
            return a[0] - b[0];
        });
        while(i < n){
            int start = intervals[i][0];
            int max_end = intervals[i][1];
            while(i < n && intervals[i][0] <= max_end){
                max_end = Math.max(max_end, intervals[i][1]);
                i ++;
            }
            list.add(new int[]{start, max_end});
        }   
        return list.toArray(new int[list.size()][]);
        
    }
}
