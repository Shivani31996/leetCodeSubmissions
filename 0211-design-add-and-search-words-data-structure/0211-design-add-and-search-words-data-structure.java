class WordDictionary {
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
    
    public boolean search(String word) {
        return searchword(word,root,0);
    }
    
    private boolean searchword(String word, TrieNode curr, int index)
    {
        //base
        if(index == word.length())
            return curr.isEnd;
        
        //logic
        char ch = word.charAt(index);
        if(ch == '.')
        {
            for(TrieNode child: curr.children)
            {
                if(child != null && searchword(word,child,index+1))
                {
                    return true;
                }
            }
            return false;
        }
        
        if(curr.children[ch - 'a'] == null)
            return false;
        
        return searchword(word,curr.children[ch - 'a'],index+1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */