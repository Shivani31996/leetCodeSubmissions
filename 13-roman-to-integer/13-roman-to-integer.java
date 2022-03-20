class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> mapping = new HashMap();
        
        mapping.put('I',1);
        mapping.put('V',5);
        mapping.put('X',10);
        mapping.put('L',50);
        mapping.put('C',100);
        mapping.put('D',500);
        mapping.put('M',1000);
        
        int intResult = 0;
        
        for(int x = 0;x<s.length();x++)
        {
            if(x > 0 && (mapping.get(s.charAt(x)) > mapping.get(s.charAt(x-1))))
            {
                intResult += mapping.get(s.charAt(x)) - 2*(mapping.get(s.charAt(x-1)));
            }
            else
            {
                intResult += mapping.get(s.charAt(x));                 
            }                       
        }  
        
        return intResult;
    }
}