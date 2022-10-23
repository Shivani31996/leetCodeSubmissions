class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        if(num.length() == 0)
        {
            return result;
        }
        
        helper(num,target,0,0,0,"");
        return result;
    }
    
    private void helper(String num, int target, int index, long calc, long tail, String path)
    {
        //base
        if(index == num.length())
        {
            if(calc == target)
            {
                result.add(path);
                return;
            }
        }
        //logic
        for(int i = index; i < num.length();i++)
        {
            long curr = Long.parseLong(num.substring(index,i + 1));
            if(i != index && num.charAt(index) == '0')
            {
                continue;
            }
            if(index == 0)
            {
                helper(num, target,i + 1, curr,curr,path + curr);
            }
            
            else
            {
                //+
                helper(num,target,i + 1, calc + curr, curr,path + '+' + curr);
                //-
                helper(num,target,i + 1, calc - curr, -curr,path +'-'+ curr );
                //*
                helper(num, target,i+1,calc - tail + tail * curr,tail*curr,path + '*' + curr );
            }
        }
    }
}