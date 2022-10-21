class Solution {
    int i;
    
    public String decodeString(String s) {
        
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        while(i < s.length())
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
                i++;
            }
            
            else if(c == '[')
            {
                i++;
                String decode = decodeString(s);
                for(int j = 0;j < num;j++)
                {
                    currStr.append(decode);
                }
                num = 0;
            }
            
            else if(c == ']')
            {
                i++;
                return currStr.toString();
            }
            else
            {
                i++;
                currStr.append(c);
            }
        }
    return currStr.toString();
    }
}