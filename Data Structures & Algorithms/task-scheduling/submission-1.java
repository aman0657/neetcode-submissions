class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<int []> queue = new LinkedList<>();
        int [] freq = new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i] - 'A'] ++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);
        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                pq.add(freq[i]);
            }
        }
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()){
            time ++;
            if(!pq.isEmpty()){
                int top = pq.poll();
                if(top > 1){
                    queue.add(new int[]{top - 1, time + n});
                }
            }

            if(!queue.isEmpty()){
                int [] to = queue.peek();
                if(to[1] == time){
                    pq.add(to[0]);
                    queue.poll();
                }
            }
        }   
        return time;
    }
}
