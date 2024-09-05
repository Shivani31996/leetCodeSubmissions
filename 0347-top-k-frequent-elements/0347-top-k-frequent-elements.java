class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        //maintain a key-value pair in HashMap for all nums
        for(int num: nums)
        {
            map.put(num,map.getOrDefault(num,1)+1);
        }
        
        //Add the keys in HashMap to a PQ/minHeap which will order the elements based on the 
        //freq of it
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        
        //Iterate over the keys in HashMap and enter it in PQ
        int result[] = new int[k];
        int i = 0;
        for(int key: map.keySet())
        {
            pq.add(key);
            if(pq.size() > (map.size() - k))
            {
                result[i] = pq.poll();
                i++;
            }
        }
        
        //In the end, only k elements remain in the PQ which is our answer which
        //we write to the result array
        // int result[] = new int[k];
        // for(int i = 0; i<k; i++)
        // {
        //     result[i] = pq.poll();
        // }
        
        return result;
    }
}