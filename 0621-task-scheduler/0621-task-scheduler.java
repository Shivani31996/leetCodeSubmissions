class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        
        for(char task:tasks)
        {
            int count = map.getOrDefault(task,0);
            count++;
            maxFreq = Math.max(maxFreq,count);
            map.put(task,count);
        }
        
        for(char key:map.keySet())
        {
            if(map.get(key) == maxFreq)
            {
                maxCount++;
            }
        }
        
        int partition = maxFreq - 1;
        int aSlots = partition * (n - (maxCount - 1));
        int pSlots = tasks.length - (maxCount*maxFreq);
        int idle = Math.max(0,aSlots-pSlots);
        return tasks.length + idle;
    }
}