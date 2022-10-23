class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        
        if(num.length() == 0)
        {
            return result;
        }
        
        helper(num,target,0,0,0,new StringBuilder());
        return result;
    }
    
    private void helper(String num, int target, long calc, long tail, int index, StringBuilder path){
        //base
        if(index == num.length())
        {
            if(calc == target)
            {
                result.add(path.toString());
            }
            return;
        }
        //logic

        for(int i = index; i<num.length();i++)
        {
                    if(i != index && num.charAt(index) == '0')
        {
            continue;
        }
            long curr = Long.parseLong(num.substring(index,i + 1));
            int le = path.length();
            
            if(index == 0)
            {
                //action
                path.append(curr); 
                //recurse
                helper(num,target,curr,curr,i + 1,path);
                //backtrack
                path.setLength(le);
            }
            
            else
            {
                //+
                //action
                path.append('+');
                path.append(curr);
                
                //recurse
                helper(num,target,calc + curr, curr, i + 1,path);
                
                //backtrack
                path.setLength(le);
                
                //-
                //action
                path.append('-');
                path.append(curr);
                
                //recurse
                helper(num,target,calc - curr,-curr,i+1,path);
                
                //backtrack
                path.setLength(le);
                
                //*
                //action
                path.append('*');
                path.append(curr);
                
                //recurse
                helper(num,target,calc - tail + tail * curr, tail*curr,i + 1, path);
                
                //backtrack
                path.setLength(le);
            }
        }
    }
}