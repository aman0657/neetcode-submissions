/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        if(intervals.size() == 0){
            return true;
        }
        Interval prev = intervals.get(0);
        int n = intervals.size();
        for(int i=1;i<n;i++){
            if(intervals.get(i).start < prev.end){
                return false;
            } else {
                prev = intervals.get(i);
            }
        }
        return true;
    }
}
