class Solution {
    public int numTrees(int n) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        map.put(1,1);
        return calculateTrees(map,n);
    }
    
    private int calculateTrees(HashMap<Integer,Integer> map, int n)
    {
        //base
        if(map.containsKey(n))
        {
            return map.get(n);
        }
        
        //logic
        int sum = 0;
        for(int i = 1; i <= n; i++)
        {
            sum += calculateTrees(map,i - 1) * calculateTrees(map,n - i);
        }
        map.put(n,sum);
        return sum;
    }
}