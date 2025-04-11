class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> Character.compare(b,a));
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        pq.addAll(map.keySet());

        while(!pq.isEmpty())
        {
            char ch = pq.poll();
            int freq = map.get(ch);

            int repeat = Math.min(freq, repeatLimit);
            for(int i = 0; i < repeat; i++)
            {
                sb.append(ch);
            }

            map.put(ch, freq-repeat);
            if(map.get(ch) > 0)
            {
                if(pq.isEmpty())
                {
                    break;
                }
                char next = pq.poll();
                sb.append(next);
                map.put(next, map.get(next)-1);

                if(map.get(next) > 0)
                {
                    pq.add(next);
                }
                else
                {
                    map.remove(next);
                }
                pq.add(ch);
            }
            else
            {
                map.remove(ch);
            }
        }

        return sb.toString();
    }
}