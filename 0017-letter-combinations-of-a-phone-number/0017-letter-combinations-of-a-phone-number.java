class Solution {
    
    HashMap<Character,String> map = new HashMap<>();
    
    List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.length() == 0)
        {
            return result;
        }
        
        dfs(digits,0,result,new StringBuilder());
        return result;
    }
    
    private void dfs(String digits, int index, List<String> result, StringBuilder path)
    {
        //base
        if(path.length() == digits.length())
        {
            result.add(path.toString());
            return;
        }
        
        //logic
        char c = digits.charAt(index);
        String word = map.get(c);
        
        for(char letter: word.toCharArray())
        {
            //action
            path.append(letter);
            //recurse
            dfs(digits,index+1,result,path);
            //backtrack
            path.deleteCharAt(path.length() - 1);
        }
    }
}