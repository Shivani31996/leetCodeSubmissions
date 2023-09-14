class Solution {
    public int maxVowels(String s, int k) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int left = 0;
        
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        for(int right = 0; right < s.length(); right++)
        {
            if(set.contains(s.charAt(right)))
            {
                count++;
            }
            if(right >= k - 1)
            {
                max = Math.max(max,count);
                if(set.contains(s.charAt(left)))
                {
                    count--;
                }
                left++;
            }
        }
        return max;
    }
}