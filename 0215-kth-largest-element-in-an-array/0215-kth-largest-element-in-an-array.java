class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int large = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        for(int num:nums)
        {
            pq.add(num);
            if(pq.size() > (n-k))
            {
                large = Math.min(large,pq.poll());
            }
        }
        return large;
    }
}