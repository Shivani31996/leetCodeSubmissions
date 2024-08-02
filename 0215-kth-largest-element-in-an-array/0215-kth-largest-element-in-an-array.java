class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int large = Integer.MAX_VALUE;
        
        for(int num: nums)
        {
            pq.add(num);
            if(pq.size() > (nums.length-k))
            {
                large = Math.min(large,pq.poll());
            }
        }
        
        return large;
    }
}