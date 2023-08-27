class Solution {
    public String decodeString(String s) {
        
        Stack<StringBuilder> strst = new Stack<>();
        Stack<Integer> numst = new Stack<>();
        
        StringBuilder curr = new StringBuilder();
        int num = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                num = num * 10 + ch - '0';
            }
            else if(ch == '[')
            {
                strst.push(curr);
                numst.push(num);
                curr = new StringBuilder();
                num = 0;
            }
            else if(ch == ']')
            {
                int k = numst.pop();
                StringBuilder parent = strst.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < k;j++)
                {
                    temp.append(curr);
                }
                curr = parent.append(temp);
            }
            else
            {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}