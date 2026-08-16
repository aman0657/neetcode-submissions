class MedianFinder {
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;
    public MedianFinder() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        maxPq.add(num);
        if(maxPq .size() - minPq.size() > 1 || (!minPq.isEmpty() && maxPq.peek() > minPq.peek())){
            minPq.add(maxPq.poll());
        }
        if(minPq.size() - maxPq.size() > 1){
            maxPq.add(minPq.poll());
        }
        

    }
    
    public double findMedian() {
        int minPqSize = minPq.size();
        int maxPqSize = maxPq.size();
        if(minPqSize == maxPqSize) {
            return (double) (minPq.peek() + maxPq.peek()) / 2;
        } else {
            if(minPqSize > maxPqSize){
                return (double) minPq.peek();
            } else {
                return (double) maxPq.peek();
            }

        }
    }
}
