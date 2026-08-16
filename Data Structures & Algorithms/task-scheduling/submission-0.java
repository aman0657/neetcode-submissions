class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(( a,  b) -> {
            return b - a;
        });
        int len = tasks.length;
        Queue<int []> queue = new LinkedList<>();
        int [] fre = new int[26];
        for(int i=0;i<len;i++){
            char ch = tasks[i];
            fre[ch - 'A'] ++;
        }
        for(int i=0;i<26;i++){
            if(fre[i] > 0)
            pq.add(fre[i]);
        }
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time ++;
            if(!pq.isEmpty()){
                int top = pq.poll();
                if(top > 1)
                queue.add(new int[]{top - 1, time + n});
                
            }
            if(!queue.isEmpty()){
                int [] que = queue.peek();
                if(time == que[1]){
                    pq.add(que[0]);
                    queue.poll();
                }
            }
        }
        return time;
    }
}
