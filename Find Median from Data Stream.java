class MedianFinder {
    PriorityQueue<Integer> pq_min = new PriorityQueue<>();
    PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(pq_max.isEmpty() || num <= pq_max.peek()){
            pq_max.offer(num);
        }else{
            pq_min.offer(num);
        }

        while(pq_max.size() < pq_min.size()){
            pq_max.offer(pq_min.peek());
            pq_min.poll();
        }
        while (pq_max.size() > pq_min.size() + 1){
            pq_min.offer(pq_max.poll());
        }
    }

    public double findMedian() {
        if(pq_max.size()==pq_min.size()){
            return (double)(pq_max.peek()+pq_min.peek())/2.0;
        }
        return (double)pq_max.peek();
    }
}

