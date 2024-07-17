class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode()
        {
            children = new TrieNode[10];
        }
    }
    
    TrieNode root = new TrieNode();
    int ans = 0;

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++)
        {
            TrieNode curr = root;
            String num = Integer.toString(arr1[i]);
            for(int j = 0; j < num.length();j++)
            {
                char ch = num.charAt(j);
                if(curr.children[ch - '0'] == null)
                {
                    curr.children[ch - '0'] = new TrieNode();
                }
                curr = curr.children[ch - '0'];
            }
            curr.isEnd = true;
        }
        
        
        for(int i = 0; i < arr2.length; i++)
        {
            TrieNode curr = root;
            String num = Integer.toString(arr2[i]);
            int count = 0;
            for(int j = 0; j < num.length(); j++)
            {
                char ch = num.charAt(j);
                if(curr.children[ch - '0'] != null)
                {
                    count++;
                    curr = curr.children[ch - '0'];
                }
                else
                {
                    break;
                }
            }
            ans = Math.max(ans,count);
        }
        
        return ans;
    }
}