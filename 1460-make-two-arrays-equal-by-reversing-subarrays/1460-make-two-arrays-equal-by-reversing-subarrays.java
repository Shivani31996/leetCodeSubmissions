class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < target.length;i++)
        {
            map.put(target[i],map.getOrDefault(target[i],0)+1);
        }
        System.out.println(map);
        
        for(int i = 0; i < arr.length; i++)
        {
            map2.put(arr[i],map2.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map2);
        
        return map.equals(map2);
    }
}