class Solution {
    boolean hasCycle = false;

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();
        Set<Character> allChars = new HashSet<>();
        Set<Character> onPath = new HashSet<>();

        for(String word: words)
        {
            for(char ch: word.toCharArray())
            {
                allChars.add(ch);
            }
        }

        for(char ch: allChars)
        {
            map.put(ch, new HashSet<>());
        }

        for(int i = 1; i < words.length; i++)
        {
            String word1 = words[i-1];
            String word2 = words[i];

            int len = Math.min(word1.length(), word2.length());

            if(word1.length() > word2.length() && word1.startsWith(word2))
            {
                return "";
            }

            for(int j = 0; j < len; j++)
            {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if( ch1 != ch2)
                {
                    map.get(ch1).add(ch2);
                    break;
                }
            }
        }

        System.out.println(map);

        for(char ch: map.keySet())
        {
            if(!visited.contains(ch))
            {
                dfs(ch, map, visited, onPath, result);
            }
        }

        if(hasCycle)
        {
            return "";
        }

        for(char ch : allChars)
        {
            if(!visited.contains(ch))
            {
                return "";
            }
        }

        return result.reverse().toString();
    }

    private void dfs(char letter, Map<Character, Set<Character>> map, Set<Character> visited, Set<Character> onPath, StringBuilder result)
    {
        if(onPath.contains(letter))
        {
            hasCycle = true;
            return;
        }

        onPath.add(letter);

        for(char neighbor: map.get(letter))
        {
            if(!visited.contains(neighbor))
            {
                dfs(neighbor, map, visited, onPath, result);
            }
        }

        onPath.remove(letter);
        visited.add(letter);
        result.append(letter);
    }
}