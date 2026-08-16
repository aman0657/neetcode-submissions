class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // minimize the deletion operaiton so that we have non overlapping intervals

        // == maximize the picking operation so that we have non overlapping intervals

        // take as many possible (sort by end date) qucick finish -> pick next

        Arrays.sort(intervals, (int [] a, int [] b) -> {
            return a[1] - b[1];
        });

        int cnt = 1;
        int [] prev = intervals[0];
        int n = intervals.length;
        for(int i=1;i<n;i++){
            int [] curr = intervals[i];
            if(curr[0] >= prev[1]){
                prev = curr;
                cnt ++;
            }
        }
        return n - cnt;


    }
}
