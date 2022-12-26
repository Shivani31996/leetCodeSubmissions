class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        long curr = (long)1;
        pq.add(curr);
        set.add(curr);
        int count = 0;
        int[] primes = new int[]{2,3,5};
        
        while(count < n)
        {
            curr = pq.poll();
            count++;
            for(int prime: primes)
            {
                Long newUgly = prime*curr;
                if(!set.contains(newUgly))
                {
                    set.add(newUgly);
                    pq.add(newUgly);
                }
            }
        }
        return (int)curr;
    }
}