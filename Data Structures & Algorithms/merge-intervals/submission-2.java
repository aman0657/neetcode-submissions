class Solution {
    public int[][] merge(int[][] intervals) {
        int maxEnd = 0;
        Arrays.sort(intervals, (int [] a, int [] b) -> {
            return a[0] - b[0];
        });
        List<int []> output = new ArrayList<>();
        int i = 0, n = intervals.length;
        while(i < n){
            int start = intervals[i][0];
            maxEnd = intervals[i][1];
            while(i < n && intervals[i][0] <= maxEnd){
                maxEnd = Math.max(maxEnd, intervals[i][1]);
                i ++;
            }
            output.add(new int[]{start, maxEnd});
        }
        return output.toArray(new int[output.size()][]);
    }
}
