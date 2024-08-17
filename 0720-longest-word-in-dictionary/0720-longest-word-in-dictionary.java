class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    StringBuilder currStr;
    public String longestWord(String[] words) {
        root = new TrieNode();
        currStr = new StringBuilder();
        for(String word: words)
        {
            insert(word);
        }
        
        backtrack(root, new StringBuilder());
        return currStr.toString();
    }
    
    public void insert(String word)
    {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null)
            {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public void backtrack(TrieNode curr,StringBuilder sb)
    {
        //base
        if(sb.length() > currStr.length())
        {
            currStr = new StringBuilder(sb);
        }
        
        //logic
        for(int i = 0; i < 26; i++)
        {
            if(curr.children[i] != null && curr.children[i].isEnd)
            {
                //action
                int length = sb.length();
                //recurse
                backtrack(curr.children[i],sb.append((char)(i + 'a')));
                
                //backtrack
                sb.setLength(length);
            }
        }
    }
    
    
}