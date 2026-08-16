class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int [] > list = new ArrayList<>();
        int i;
        for( i=0;i<intervals.length;i++){
            if(intervals[i][1] >= newInterval[0]){
                break;
            }
            list.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        int start = newInterval[0], end = newInterval[1];
        for(;i<intervals.length;i++){
            if(intervals[i][0] > end){
                break;
            }
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
        }
        list.add(new int[]{start, end});
        for(;i<intervals.length;i++){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        return list.toArray(new int[list.size()][]);

        
    }
}
