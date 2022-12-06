class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for(int i = 0; i < word1.length();i++)
        {
            arr1[word1.charAt(i) - 'a']++;
            arr2[word2.charAt(i) - 'a']++;
        }

        for(int i = 0; i<26;i++)
        {
            System.out.print(arr1[i]);
        }
        
        System.out.print("\n");
        for(int i = 0; i<26;i++)
        {
            System.out.print(arr2[i]);
        }
        
        for(int i = 0; i<26;i++)
        {
            if(arr1[i] == 0 && arr2[i] != 0 || arr1[i] != 0 && arr2[i] == 0)
            {
                return false;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        System.out.print("\n");
        System.out.println("----After sorting----");
        for(int i = 0; i<26;i++)
        {
            System.out.print(arr1[i]);
        }
        System.out.print("\n");
        for(int i = 0; i<26;i++)
        {
            System.out.print(arr2[i]);
        }
    
        return Arrays.equals(arr1,arr2);
    }
}