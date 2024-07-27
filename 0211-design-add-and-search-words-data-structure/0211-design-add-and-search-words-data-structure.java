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
    
    private boolean searchword(String word, TrieNode root, int index)
    {
        //base
        if(index == word.length())
            return root.isEnd;
        
        //logic
        char ch = word.charAt(index);
        if(ch == '.')
        {
            for(TrieNode child: root.children)
            {
                if(child != null && searchword(word,child,index+1))
                {
                    return true;
                }
            }
            return false;
        }
        
        if(root.children[ch - 'a'] == null)
            return false;
        
        return searchword(word,root.children[ch - 'a'],index+1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */