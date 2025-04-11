class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        for(int interval[]: intervals)
        {
            if(pq.isEmpty())
            {
                pq.offer(interval);
            }
            else
            {
                if(pq.peek()[1] < interval[0])
                {
                    pq.poll();
                }
                pq.offer(interval);
            }
        }

        return pq.size();
    }
}