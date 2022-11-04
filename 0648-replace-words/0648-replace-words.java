class Solution {
    class TrieNode{
            boolean isEnd;
            TrieNode[] children;
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
        
    TrieNode root;
        
    public void insert(String word)
        {
            TrieNode curr = root;
            for(int i = 0; i < word.length();i++)
            {
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null)
                {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String str: dictionary)
        {
            insert(str);
        }
        
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int k = 0; k < words.length;k++)
        {
            if(k != 0)
            {
                result.append(" ");
            }
            StringBuilder replacement = new StringBuilder();
            String word = words[k];
            TrieNode curr = root;
            for(int i = 0; i < word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.isEnd)
                {
                    break;
                }
                replacement.append(c);
                curr = curr.children[c - 'a'];
                
            }
            if(curr.isEnd)
            {
                result.append(replacement);
            }
            else
            {
                result.append(word);
            }
        }
        return result.toString();
    }
}