class Solution {
    public class Pair {
        int val;
        char ch;
        public Pair(int val, char ch){
            this.val = val;
            this.ch = ch;
        }
    }
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry: map.entrySet())
            {
                Pair pair = new Pair(entry.getValue(),entry.getKey());
                pq.add(pair);
            }
        
        while(!pq.isEmpty())
        {
            Pair pair = pq.remove();
            char ch = pair.ch;
            int count = pair.val;
            
            while(count > 0)
            {
                sb.append(ch);
                count--;
            }
        }
                    
    return sb.toString();
    }
}