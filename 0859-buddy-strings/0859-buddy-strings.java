class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        int count = 0;
        int s_arr[] = new int[26];
        int goal_arr[] = new int[26];
        
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != goal.charAt(i))
            {
                count++;
            }
        }
        
        if(s.equals(goal))
        {
            for(int i = 0; i < s.length(); i++)
            {
                if(!set.add(s.charAt(i)))
                {
                    return true;
                }
            }
            return false;
        }
        
        if(count > 2)
        {
            return false;
        }
        
        for(int i = 0; i < s.length(); i++)
        {
            s_arr[s.charAt(i) - 'a']++;
            goal_arr[goal.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i< s_arr.length; i++)
        {
            if(s_arr[i] != goal_arr[i])
            {
                return false;
            }
        }
        
        if(count == 2)
        {
            return true;
        }
        
        return false;
    }
}